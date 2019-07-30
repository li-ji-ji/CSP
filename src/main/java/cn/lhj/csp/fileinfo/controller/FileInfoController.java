package cn.lhj.csp.fileinfo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.FileInfo;

@Controller
@RequestMapping("/fileinfo")
public class FileInfoController {

	@Autowired
	private FileInfoApiInterface fileInfoApiInterface;

	@RequestMapping("/list")
	public String list(ModelMap map, FileInfo fileInfo,
			@RequestParam(required = false, defaultValue = "null") String operation,
			@RequestParam(required = false, defaultValue = "0") Integer id) {

		if (operation.equals("insert")) {
			fileInfoApiInterface.insert(fileInfo);
		}
		if (operation.equals("update")) {
			fileInfoApiInterface.update(fileInfo);
		}
		if (operation.equals("delete")) {
			fileInfoApiInterface.delete(id);
		}
		List<FileInfo> fileInfos = fileInfoApiInterface.getAll();
		map.addAttribute("fileInfos", fileInfos);
		return "ftl/fileinfo/list";
	}

	@RequestMapping("/edit")
	public String edit(ModelMap map, String operation, FileInfo fileInfo,
			@RequestParam(required = false, defaultValue = "0") int id,
			@RequestParam(required = false, defaultValue = "0") Integer folderId) {
		if (operation.equals("update")) {
			fileInfo = fileInfoApiInterface.getById(id);
			map.addAttribute("fileInfo", fileInfo);
			map.addAttribute("operation", "update");
		} else if (operation.equals("insert")) {
			fileInfo = new FileInfo(0, "", "", "", "", folderId, "", "", "");
			map.addAttribute("fileInfo", fileInfo);
			map.addAttribute("operation", "insert");
		}
		return "ftl/fileinfo/edit";
	}
	
	@RequestMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile,@RequestParam(required = false, defaultValue = "其他")String folderName)throws Exception{
		return fileInfoApiInterface.uploadPrintOrder(multfile, folderName);
	}
}
