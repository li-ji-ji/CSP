package cn.lhj.csp.fileinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.lhj.csp.fileinfo.po.PrintShop;
import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.service.PrintShopService;

@Controller
@RequestMapping("/printshop")
public class PrintShopController {
		
		@Autowired
		private PrintShopService printShopService;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<PrintShop> printshops = printShopService.getAll();
			map.addAttribute("printshops", printshops);
			return "ftl/printshop/list";
		}
		
		@RequestMapping("/toinsert")
		public String list() {
			return "ftl/printshop/insert";
		}
		
		@RequestMapping("/todelete")
		public String delete(ModelMap map,Integer id) {
			printShopService.delete(id);
			List<PrintShop> printshops = printShopService.getAll();
			map.addAttribute("printshops", printshops);
			return "ftl/printshop/list";
		}
		
		@RequestMapping("/toupdate")
		public String update(ModelMap map,Integer id){
			PrintShop printShop = printShopService.findById(id);
			map.addAttribute("printShop", printShop);
			return "ftl/printshop/update";
		}
}
