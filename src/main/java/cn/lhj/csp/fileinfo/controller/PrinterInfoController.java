package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.service.PrinterInfoService;

@Controller
@RequestMapping("/printerinfo")
public class PrinterInfoController {
	
		@Autowired
		private PrinterInfoService printerInfoService;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<Printer> printers = printerInfoService.getAll();
			map.addAttribute("printers", printers);
			return "ftl/printerinfo/list";
		}
		
		@RequestMapping("/toinsert")
		public String list() {
			return "ftl/printerinfo/insert";
		}
		
		@RequestMapping("/todelete")
		public String delete(ModelMap map,Integer id) {
			List<Printer> printers = printerInfoService.getAll();
			map.addAttribute("printers", printers);
			printerInfoService.delete(id);
			return "ftl/printerinfo/list";
		}
		
		@RequestMapping("/toupdate")
		public String update(ModelMap map,Integer id){
			Printer printer = printerInfoService.findById(id);
			map.addAttribute("printer", printer);
			return "ftl/printerinfo/update";
		}
		
}
