package cn.lhj.csp.admin.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.lhj.csp.admin.utils.PublicMsg;
import cn.lhj.csp.admin.utils.Ueditor;


@Controller
public class UEditorController {


	@RequestMapping(value="/ueditor")
    @ResponseBody
    public String ueditor(@RequestParam("action") String param,MultipartFile upfile,HttpServletRequest request) {
		Ueditor ueditor = new Ueditor();
		if(param!=null&param.equals("config")){
			return PublicMsg.UEDITOR_CONFIG;	
	    }else if(param!=null&param.equals("uploadimage")||param.equals("uploadscrawl")){
	    	if(upfile!=null){
	    		//{state：”数据状态信息”，url：”图片回显路径”，title：”文件title”，original：”文件名称”，···}
	    		try {
					return uploadImg(upfile,request);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ueditor.setState("出现异常");
		    		return JSON.toJSONString(ueditor);
				}
	    	}else{
	    		ueditor.setState("文件为空");
	    		return JSON.toJSONString(ueditor);
	    	}
	    }else{
	    	ueditor.setState("不支持该操作");
    		return JSON.toJSONString(ueditor);
	    }
    }
 
    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(@RequestParam("action") String param,MultipartFile upfile,HttpServletRequest request) {
		Ueditor ueditor = new Ueditor();
        return ueditor;
    }
    
	public String uploadImg(MultipartFile file,
			HttpServletRequest request) throws IOException {
		Ueditor ueditor = new Ueditor();
		String path = request.getSession().getServletContext()
				.getRealPath("ueditor/jsp/upload/image");
		String ct = file.getContentType() ;
		String fileType = "";
		if (ct.indexOf("/")>0) {
			fileType = ct.substring(ct.indexOf("/")+1);
		}
		String fileName = UUID.randomUUID() + "." + fileType;
		File targetFile = new File(path);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		File targetFile2 = new File(path+"/"+fileName);
		if (!targetFile2.exists()) {
			targetFile2.createNewFile();
		}
		// 保存
		try {
			file.transferTo(targetFile2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ueditor.setState("SUCCESS");
		ueditor.setTitle(fileName);
		ueditor.setOriginal(fileName);
		ueditor.setUrl("/ueditor/jsp/upload/image"+File.separator+fileName);
		System.out.println( JSON.toJSONString(ueditor));
		return JSON.toJSONString(ueditor);
	}
}
