//package cn.lhj.csp.fileinfo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
//import cn.lhj.csp.fileinfo.po.PrintOrder;
//import cn.lhj.csp.fileinfo.service.PrintOrderService;
//import cn.lhj.csp.fileinfo.service.PrinterInfoService;
//
//@Controller
//@RequestMapping("/printOrder")
//public class PrintOrderController {
//
//	@Autowired
//	private PrintOrderService printOrderService;
//
//	@RequestMapping("/list")
//	public String list(ModelMap map, PrintOrder printOrder,
//			@RequestParam(required = false, defaultValue = "null") String operation,
//			@RequestParam(required = false, defaultValue = "0") Integer id,
//			@RequestParam(required = false, defaultValue = "0") String orderNo) {
//
//		if (operation.equals("insert")) {
//			printOrderService.insert(printOrder);
//		}
//		if (operation.equals("update")) {
//			printOrderService.update(printOrder);
//		}
//		if (operation.equals("delete")) {
//			printOrderService.delete(id);
//		}
//
//		List<PrintOrder> printOrders = new ArrayList<PrintOrder>();
//		if (orderNo.equals("0")) {
//			printOrders = printOrderService.getAll();
//		} else {
//			PrintOrder printOrderOrderNo = printOrderService.selectByOrderNo(orderNo);
//			printOrders.add(printOrderOrderNo);
//		}
//		map.addAttribute("printOrders", printOrders);
//		return "ftl/printorder/list";
//	}
//
//	@RequestMapping("/edit")
//	public String edit(ModelMap map, String operation, PrintOrder printOrder,
//			@RequestParam(required = false, defaultValue = "0") int id) {
//		if (operation.equals("update")) {
//			printOrder = printOrderService.findById(id);
//			map.addAttribute("printOrder", printOrder);
//			map.addAttribute("operation", "update");
//		} else if (operation.equals("insert")) {
//			printOrder = new PrintOrder(0, "", 0,"", "", "", "", "", "", "", "", "", "", 0, "", (float) 0.0, "", "", "",
//					"", "", "", "");
//			map.addAttribute("printOrder", printOrder);
//			map.addAttribute("operation", "insert");
//		}
//		return "ftl/printorder/edit";
//	}
//
//}
