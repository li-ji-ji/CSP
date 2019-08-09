package cn.lhj.csp.config.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CosController {
	
	/**
     * 把文件上传到腾讯云存储服务器
     * @param multfile
     * @return
     * @throws Exception
     */
	
    @RequestMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile)throws Exception{
        // 获取文件名
    	Map<String,Object> maps = new HashMap<String,Object>();
		Map<String,Object> maps2 = new HashMap<String,Object>();
    	System.out.println("file:"+multfile);
        String fileName = multfile.getOriginalFilename();
        
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-"+System.currentTimeMillis(), prefix);
        // 将MultipartFile转为File
        multfile.transferTo(excelFile);
        String path = "https://csp-1257312123.cos.ap-guangzhou.myqcloud.com/"+fileName;
        //调用腾讯云工具上传文件
 		fileName = TencentCOS.uploadfile(excelFile);

        //程序结束时，删除临时文件
        deleteFile(excelFile);
		//存入图片名称，用于网页显示
        //返回图片名称
		maps2.put("src", path);
		maps.put("code", "0");
		maps.put("msg", "");
		maps.put("data", maps2);
        return maps;
    }

    /**
     * 删除临时文件
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
