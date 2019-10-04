package cn.lhj.csp.fileinfo.api;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.service.FileInfoService;
import cn.lhj.csp.fileinfo.service.impl.RedisTemplateServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin
@RestController
public class FileUploadApi {

	@Autowired
	private FileInfoService fileInfoService;

	@Autowired
	RedisTemplateServiceImpl redisTemplateService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
	public Map<String, Object> uploadFile(@RequestPart("file") MultipartFile file,
			@RequestParam(value = "folderName", defaultValue = "其他") String folderName) throws IOException {
		System.out.println(folderName);
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> maps2 = new HashMap<String, Object>();
		// 获取文件名
		System.out.println("file:" + file.getOriginalFilename());
		String fileName = file.getOriginalFilename();
		// 获取文件后缀
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		// 用uuid作为文件名，防止生成的临时文件重复
		FileInfoApi fileInfoApi = new FileInfoApi();
		final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
		// 将MultipartFile转为File
		file.transferTo(excelFile);

		String config = redisTemplateService.getValue("tengxunConfig");
		if (config == null) {
			String url = "http://qzimp.cn/api/assist/api/config/getTengXunYunAll";
			try {
				ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
				config = results.getBody();
				redisTemplateService.set("tengxunConfig", config);
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
				if (job.get("configKey").equals("secretId")) {
					secretId = (String) job.get("configValue");
				}
				if (job.get("configKey").equals("secretKey")) {
					secretKey = (String) job.get("configValue");
				}
				if (job.get("configKey").equals("bucketName")) {
					bucketName = (String) job.get("configValue");
				}
			}
		}
		// 调用腾讯云工具上传文件
		fileName = TencentCOS.uploadfile(excelFile, secretId, secretKey, bucketName);
		// 访问路径
		String path = "https://"+bucketName+".cos.ap-guangzhou.myqcloud.com/" + fileName;
		// 程序结束时，删除临时文件
		deleteFile(excelFile);

		fileName = file.getOriginalFilename();
		prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		// 判断文件大小
		int filesize = (int) file.getSize();
		String size = "";
		if (filesize > 1048576) {
			filesize /= 1048576;
			size = String.valueOf(filesize) + "mb";
		} else if (filesize > 1024) {
			filesize /= 1024;
			size = String.valueOf(filesize) + "kb";
		} else {
			size = String.valueOf(filesize) + "k";
		}
		FileInfo fileInfo = new FileInfo(0, fileName, "", "", file.getName(), 0, path, dateFormat.format(date), size);
		fileInfoService.insert(fileInfo);
		maps2.put("src", path);
		maps.put("code", "0");
		maps.put("msg", "");
		maps.put("data", maps2);
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
