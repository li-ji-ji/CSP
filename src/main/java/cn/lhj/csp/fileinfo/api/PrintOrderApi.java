package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.PrintOrder;
import cn.lhj.csp.fileinfo.service.PrintOrderService;

@RestController
public class PrintOrderApi {
		
		@Autowired
		private PrintOrderService printOrderService;
		
		@RequestMapping("/api/printOrder/getAll")
		public List<PrintOrder> getAll(){
			return printOrderService.getAll();
		}
		
		@RequestMapping("/api/printOrder/insert")
		public void insert(@RequestBody PrintOrder printOrder) {
			printOrderService.insert(printOrder);
		}
		
		@RequestMapping("/api/printOrder/delete")
		public void delete(Integer id) {
			printOrderService.delete(id);
		}
		
		@RequestMapping("/api/printOrder/update")
		public void update(@RequestBody PrintOrder printOrder) {
			printOrderService.update(printOrder);
		}
		
		@RequestMapping("/api/printOrder/findById")
		public PrintOrder findById(Integer id) {
			return printOrderService.findById(id);
		}
		
		@RequestMapping("/api/printOrder/selectByOrderNo")
		public PrintOrder selectByOrderNoPrintOrder(String orderNo) {
			return printOrderService.selectByOrderNo(orderNo);
		}

}
