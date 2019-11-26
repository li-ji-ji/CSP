package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.PrintShop;
import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.service.PrintShopService;
import cn.lhj.csp.fileinfo.service.PrinterInfoService;

@RestController
@CrossOrigin
public class PrintShopApi {
		
		@Autowired
		private PrintShopService printShopService;
		@Autowired
		private PrinterInfoService printerInfoService;
		
		@RequestMapping("/api/printShop/getLayuiAll")
		public List<PrintShop> getAllPrintShop(){
			List<PrintShop> printShops = printShopService.getAll();
			for(int i = 0;i<printShops.size();i++) {
				List<Printer> printers = printerInfoService.findByPrintShopName(printShops.get(i).getName());
				printShops.get(i).setPrints(printers);
			}
			return printShops;
		}
		
		@RequestMapping("/api/printShop/insert")
		public String insertPrintShop(@RequestBody PrintShop printShop) {
			return printShopService.insert(printShop);
		}
		
		@RequestMapping("/api/printShop/delete")
		public String deletePrintShop(@RequestParam(value = "id")Integer id) {
			return printShopService.delete(id);
		}
		
		@RequestMapping("/api/printShop/update")
		public String updatePrintShop(@RequestBody PrintShop printShop) {
			return printShopService.update(printShop);
		}
		
		@RequestMapping("/api/printShop/findById")
		public PrintShop findByIdPrintShop(@RequestParam(value = "id") Integer id) {
			return printShopService.findById(id);
		}
}
