package cn.yzj.shop.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.PaymentWithBLOBs;
import cn.yzj.shop.service.PaymentConfigService;

/*
 *yzj
 *2019
 *2019年9月23日
 */
@RestController
@RequestMapping("/api")
public class PaymentConfigApi {
	@Autowired
	private PaymentConfigService paymentConfigService;
	
	@RequestMapping("/getPaymentList")
	public Serializable getPaymentList(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue ="20")int limit) throws Exception {
		return paymentConfigService.dataPage(limit, page);
		
	}
	@RequestMapping("/addPayment")
	public Msg addPayment(PaymentWithBLOBs paymentWithBLOBs) throws Exception {
		return paymentConfigService.add(paymentWithBLOBs);
		
	}
	@RequestMapping("/deletePayment")
	public Msg deletePayment(@RequestParam("ids")String ids) throws Exception {
		return paymentConfigService.delete(ids);
		
	}
	@RequestMapping("/updatePayment")
	public Msg updatePayment(PaymentWithBLOBs paymentWithBLOBs) throws Exception {
		return paymentConfigService.updata(paymentWithBLOBs);
	}
	

}
