package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.PrintShop;

@RestController
public class PrintShopApi {
		
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/api/printShop/getLayuiAll")
		public List<PrintShop> getAllPrintShop(){
			return fileInfoApiInterface.getLayuiGetAllPrintShop();
		}
		
		@RequestMapping("/api/printShop/insert")
		public String insertPrintShop(@RequestBody PrintShop printShop) {
			return fileInfoApiInterface.insertPrintShop(printShop);
		}
		
		@RequestMapping("/api/printShop/delete")
		public String deletePrintShop(@RequestParam(value = "id")Integer id) {
			return fileInfoApiInterface.deletePrintShop(id);
		}
		
		@RequestMapping("/api/printShop/update")
		public String updatePrintShop(@RequestBody PrintShop printShop) {
			return fileInfoApiInterface.updatePrintShop(printShop);
		}
		
		@RequestMapping("/api/printShop/findById")
		public PrintShop findByIdPrintShop(@RequestParam(value = "id") Integer id) {
			return fileInfoApiInterface.findByIdPrintShop(id);
		}
}
