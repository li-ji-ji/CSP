package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.Printer;

@RestController
public class PrinterInfoApi {
		
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/api/printer/getAll")
		public List<Printer> getAllPrinter(){
			return fileInfoApiInterface.getAllPrinter();
		}
		
		@RequestMapping("/api/printer/insert")
		public String insertPrinter(@RequestBody Printer printer) {
			return fileInfoApiInterface.insertPrinter(printer);
		}
		
		@RequestMapping("/api/printer/delete")
		public String deletePrinter(Integer id) {
			return fileInfoApiInterface.deletePrinter(id);
		}
		
		@RequestMapping("/api/printer/update")
		public String updatePrinter(@RequestBody Printer printer) {
			return fileInfoApiInterface.updatePrinter(printer);
		}
		
		@RequestMapping("/api/printer/findById")
		public Printer findByIdPrinter(Integer id) {
			return fileInfoApiInterface.findByIdPrinter(id);
		}
}
