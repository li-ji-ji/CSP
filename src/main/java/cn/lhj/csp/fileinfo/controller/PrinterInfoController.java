package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.Printer;

@Controller
@RequestMapping("/printerinfo")
public class PrinterInfoController {
	
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<Printer> printers = fileInfoApiInterface.getAllPrinter();
			map.addAttribute("printers", printers);
			return "ftl/printerinfo/list";
		}
		
		@RequestMapping("/toinsert")
		public String list() {
			return "ftl/printerinfo/insert";
		}
		
		@RequestMapping("/todelete")
		public String delete(ModelMap map,Integer id) {
			List<Printer> printers = fileInfoApiInterface.getAllPrinter();
			map.addAttribute("printers", printers);
			fileInfoApiInterface.deletePrinter(id);
			return "ftl/printerinfo/list";
		}
		
		@RequestMapping("/toupdate")
		public String update(ModelMap map,Integer id){
			Printer printer = fileInfoApiInterface.findByIdPrinter(id);
			map.addAttribute("printer", printer);
			return "ftl/printerinfo/update";
		}
		
}
