package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.PersonFileinfo;

@Controller
@RequestMapping("/personFileInfo")
public class PersonFileInfoController {
		
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<PersonFileinfo> personFileInfos = fileInfoApiInterface.getAllPersonFileInfo();
			map.addAttribute("personFileInfos", personFileInfos);
			return "ftl/personfileinfo/list";
		}
		
		@RequestMapping("/todelete")
		public String todelete(@RequestParam("id")Integer id) {
			fileInfoApiInterface.deletePersonFileInfo(id);
			return "ftl/personfileinfo/list";
		}
		
		@RequestMapping("/toupdate")
		public String toupdate(ModelMap map,@RequestParam("id")Integer id) {
			PersonFileinfo personFileInfo = fileInfoApiInterface.findByIdPersonFileInfo(id);
			map.addAttribute("personFileInfo", personFileInfo);
			return "ftl/personfileinfo/update";
		}
}
