package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.service.PrinterInfoService;

@RestController
@CrossOrigin
public class PrinterInfoApi {
		
		@Autowired
		private PrinterInfoService printerInfoService;
		
		@RequestMapping("/api/printer/getAll")
		public List<Printer> getAllPrinter(){
			return printerInfoService.getAll();
		}
		
		@RequestMapping("/api/printer/insert")
		public String insertPrinter(@RequestBody Printer printer) {
			return printerInfoService.insert(printer);
		}
		
		@RequestMapping("/api/printer/delete")
		public String deletePrinter(Integer id) {
			return printerInfoService.delete(id);
		}
		
		@RequestMapping("/api/printer/update")
		public String updatePrinter(@RequestBody Printer printer) {
			return printerInfoService.update(printer);
		}
		
		@RequestMapping("/api/printer/findById")
		public Printer findByIdPrinter(Integer id) {
			return printerInfoService.findById(id);
		}
}
