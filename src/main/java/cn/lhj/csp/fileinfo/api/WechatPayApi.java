package cn.lhj.csp.fileinfo.api;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.service.PaySystemService;


@RestController
public class WechatPayApi {

	@Autowired
	private PaySystemService paySystemService;
	
	/*
	 * 下单接口
	 */
	@RequestMapping("/api/wechatPay/placeOrder")
	public String placeOrder(HttpServletRequest request,@RequestParam("openid")String openid,@RequestParam("reward")int reward,@RequestParam("orderNo")String orderNo,HttpServletResponse response)throws Exception{
		String ip="127.0.0.1";
		if (request.getHeader("x-forwarded-for") == null) {  
			ip=request.getRemoteAddr();
	    } else {
	    	ip=request.getHeader("x-forwarded-for");
		}
		System.out.println(ip);
		ip=ip+", 47.106.220.247";
		ip=ip.substring(0,ip.indexOf(","));
		System.out.println(ip);
	    return paySystemService.placeOrder(openid,ip,reward,orderNo);  
	}

	/*
	 * 支付接口
	 */
	@RequestMapping("/api/wechatPay/notifyUrl")
	public String notify_url(HttpServletRequest request) throws Exception {
		BufferedReader reader = request.getReader();
		String line = "";
		StringBuffer inputString = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			inputString.append(line);
		}
		request.getReader().close();
		System.out.println(inputString.toString());
		return paySystemService.notify_url(inputString.toString());
	}

	/*
	 * 取消订单接口
	 */
	
	@RequestMapping("/api/wechatPay/cancelOrder")
	public String cancelOrder(@RequestParam("out_trade_no")String out_trade_no,@RequestParam("total_fee") int total_fee) throws Exception{
		return paySystemService.cancelOrder(out_trade_no, total_fee);
	}
}
