package cn.lhj.csp.fileinfo.api;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.service.PrintOrderService;
import cn.lhj.csp.fileinfo.service.impl.RedisTemplateServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin
@RestController
public class PrintUploadApi {
	
	@Autowired
	private PrintOrderService printOrderService;
	
	@Autowired
    RedisTemplateServiceImpl redisTemplateService;
	
	@Autowired
	private RestTemplate restTemplate;
	/**
	 * 把文件上传到腾讯云存储服务器
	 * 
	 * @param multfile
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/print/upload")
	public Map<String, Object> upload(@RequestPart("file") MultipartFile file,
			@RequestParam(required = false, defaultValue = "其他") String folderName) throws Exception {

		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> maps1 = new HashMap<String, Object>();

		// 获取文件名
		System.out.println("file:" + file.getOriginalFilename());
		String fileName = file.getOriginalFilename();
		// 获取文件后缀
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(prefix);
		// 用uuid作为文件名，防止生成的临时文件重复
		PrintOrderApi fileInfoApi = new PrintOrderApi();
		final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
		// 将MultipartFile转为File
		file.transferTo(excelFile);
		int num = 0;
		String msg = "";
		if (prefix.equals(".docx")) {//判断docx页数
			try {
				XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage(excelFile.getPath()));
				num = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
			} catch (Exception e) {}
		}
		else if (prefix.equals(".doc")) {//判断doc页数
			try {
				WordExtractor doc = new WordExtractor(new FileInputStream(excelFile.getPath()));
				num = doc.getSummaryInformation().getPageCount();// 总页数
			} catch (Exception e) {}
		}
		else if (prefix.equals(".pdf")) {//判断pdf页数
			try {
				File file2 = new File(excelFile.getPath());
				PDDocument pdf = PDDocument.load(file2);
				num = pdf.getNumberOfPages();
			} catch (Exception e) {}
		}
		else if (prefix.equals(".png") || prefix.equals(".jpg")) {//判断png,jpg页数
			num++;
		}
		else if (prefix.equals(".ppt")) {//判断ppt页数
			try {
				FileInputStream fis = new FileInputStream(excelFile.getPath());
				SlideShow pptfile = new SlideShow(new HSLFSlideShow(fis));
				num = pptfile.getSlides().length;
			} catch (Exception e) {}
		}
		else if (prefix.equals(".pptx")) {//判断pptx页数
			try {
				XSLFSlideShow fis = new XSLFSlideShow(excelFile.getPath());
				XMLSlideShow pptxfile = new XMLSlideShow(fis);
				num = pptxfile.getSlides().length;
			} catch (Exception e) {}
		}
		else {
			msg="暂不支持该文件";
		}
		String config = redisTemplateService.getValue("tengxunConfig");
		if (config == null) {
			String url = "http://localhost:8080/csp/api/config/getTengXunYunAll";
			//String url = "https://qzimp.cn/api/assist/api/config/getTengXunYunAll";
			try {
				ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
				config = results.getBody();
			} catch (Exception e) {
				ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
				config = results.getBody();
				redisTemplateService.set("tengxunConfig", config);
			}
		}
		JSONArray json = JSONArray.fromObject(config);
		String secretId = "";
		String secretKey = "";
		String bucketName = "";
		if (json.size() > 0) {
			for (int i = 0; i < json.size(); i++) {
				JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				if(job.get("configKey").equals("secretId")) {
					secretId = (String) job.get("configValue");
				}
				if(job.get("configKey").equals("secretKey")) {
					secretKey = (String) job.get("configValue");
				}
				if(job.get("configKey").equals("bucketName")) {
					bucketName = (String) job.get("configValue");
				}
			}
		}
		// 调用腾讯云工具上传文件
		fileName = TencentCOS.uploadfile(excelFile,secretId,secretKey,bucketName);
		// 访问路径
		String path = "https://"+bucketName+".cos.ap-guangzhou.myqcloud.com/" + fileName;
		// 程序结束时，删除临时文件
		deleteFile(excelFile);

		fileName = file.getOriginalFilename();
		prefix = fileName.substring(fileName.lastIndexOf("."));
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		// 判断文件页数
		maps1.put("src", path);
		maps1.put("page", num);
		maps.put("code", "0");
		maps.put("msg", msg);
		maps.put("data", maps1);
		return maps;
	}

	/**
	 * 删除临时文件
	 * 
	 * @param files
	 */

	private void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

}
