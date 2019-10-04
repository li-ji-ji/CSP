package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.service.FileInfoService;

@Controller
@RequestMapping("/fileinfo")
public class FileInfoController {

	@Autowired
	private FileInfoService fileInfoService;

	@RequestMapping("/list")
	public String list(ModelMap map, FileInfo fileInfo,
			@RequestParam(required = false, defaultValue = "null") String operation,
			@RequestParam(required = false, defaultValue = "0") Integer id) {

		if (operation.equals("insert")) {
			fileInfoService.insert(fileInfo);
		}
		if (operation.equals("update")) {
			fileInfoService.update(fileInfo);
		}
		if (operation.equals("delete")) {
			fileInfoService.delete(id);
		}
		List<FileInfo> fileInfos = fileInfoService.getAll();
		map.addAttribute("fileInfos", fileInfos);
		return "ftl/fileinfo/list";
	}

	@RequestMapping("/edit")
	public String edit(ModelMap map, String operation, FileInfo fileInfo,
			@RequestParam(required = false, defaultValue = "0") int id,
			@RequestParam(required = false, defaultValue = "0") Integer folderId) {
		if (operation.equals("update")) {
			fileInfo = fileInfoService.getById(id);
			map.addAttribute("fileInfo", fileInfo);
			map.addAttribute("operation", "update");
		} else if (operation.equals("insert")) {
			fileInfo = new FileInfo(0, "", "", "", "", folderId, "", "", "");
			map.addAttribute("fileInfo", fileInfo);
			map.addAttribute("operation", "insert");
		}
		return "ftl/fileinfo/edit";
	}
	

}
