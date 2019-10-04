package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.service.FolderInfoService;


@Controller
@RequestMapping("/folderinfo")
public class FolderInfoController {
	
	@Autowired
	private FolderInfoService folderInfoService;
	
	@RequestMapping("/list")
	public String list(ModelMap map,FolderInfo folderInfo,@RequestParam(required = false, defaultValue = "null")String operation,@RequestParam(required = false, defaultValue = "0")Integer id) {
		if(operation.equals("insert")) {
			folderInfoService.insert(folderInfo);
		}
		if(operation.equals("update")) {
			folderInfoService.update(folderInfo);
		}
		if(operation.equals("delete")) {
			folderInfoService.delete(id);
		}
		List<FolderInfo> folderInfos = folderInfoService.getAll();
		map.addAttribute("folderInfos", folderInfos);
		return "ftl/folderInfo/list";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap map,String operation,FolderInfo folderInfo,@RequestParam(required = false, defaultValue = "0")int id) {
		if(operation.equals("update")) {
			folderInfo = folderInfoService.getById(id);
			map.addAttribute("folderInfo", folderInfo);
			map.addAttribute("operation", "update");
		}
		else if(operation.equals("insert")) {
			folderInfo=new FolderInfo(0,"","",0);
			map.addAttribute("folderInfo", folderInfo);
			map.addAttribute("operation", "insert");
		}
		return "ftl/folderInfo/edit";
	}
}
