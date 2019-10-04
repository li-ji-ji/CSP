package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.fileinfo.po.PersonFileinfo;
import cn.lhj.csp.fileinfo.service.PersonFileInfoService;

@Controller
@RequestMapping("/personFileInfo")
public class PersonFileInfoController {
		
		@Autowired
		private PersonFileInfoService personFileInfoService;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<PersonFileinfo> personFileInfos = personFileInfoService.getAll();
			map.addAttribute("personFileInfos", personFileInfos);
			return "ftl/personfileinfo/list";
		}
		
		@RequestMapping("/todelete")
		public String todelete(@RequestParam("id")Integer id) {
			personFileInfoService.delete(id);
			return "ftl/personfileinfo/list";
		}
		
		@RequestMapping("/toupdate")
		public String toupdate(ModelMap map,@RequestParam("id")Integer id) {
			PersonFileinfo personFileInfo = personFileInfoService.findById(id);
			map.addAttribute("personFileInfo", personFileInfo);
			return "ftl/personfileinfo/update";
		}
}
