package cn.lhj.csp.fileinfo.service.impl;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.lhj.csp.fileinfo.po.PrintOrder;
import cn.lhj.csp.fileinfo.po.RefundDTO;
import cn.lhj.csp.fileinfo.po.ShopCart;
import cn.lhj.csp.fileinfo.service.PaySystemService;
import cn.lhj.csp.fileinfo.service.PrintOrderService;
import cn.lhj.csp.fileinfo.service.ShopCartInfoService;
import cn.lhj.csp.fileinfo.util.WXPayMapUtil;
import cn.lhj.csp.fileinfo.util.WXPayUtil;
import cn.lhj.csp.fileinfo.util.WxConfig;
import cn.lhj.csp.task.po.PayPram;
import net.sf.json.JSONObject;

@Service
public class PaySystemServiceImpl implements PaySystemService {

	@Autowired
	private PrintOrderService printOrderService;

	@Autowired
	private ShopCartInfoService shopCartInfoService;
	/*
	 * 统一下单接口
	 */

	@Override
	@Transactional
	public String placeOrder(String openid, String ip, int total_fee, String orderNo) throws Exception {
		WxConfig wxConfig = new WxConfig();
		String key = wxConfig.getKey();
		String isOK = "{code:FAIl}";
		RestTemplate restTemplate = new RestTemplate();
		PayPram payPram = new PayPram();
		payPram.setAppid(wxConfig.getAppid());
		payPram.setMch_id(wxConfig.getMch_id());
		payPram.setNonce_str(WXPayUtil.generateNonceStr());
		payPram.setSpbill_create_ip(ip);
		payPram.setTotal_fee(total_fee);
		payPram.setOut_trade_no(orderNo);
		payPram.setOpenid(openid);
		// 设置请求参数
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("appid", payPram.getAppid());
		paraMap.put("mch_id", payPram.getMch_id());
		paraMap.put("nonce_str", payPram.getNonce_str());
		paraMap.put("trade_type", payPram.getTrade_type());
		paraMap.put("notify_url", payPram.getNotify_url());
		paraMap.put("spbill_create_ip", payPram.getSpbill_create_ip());
		paraMap.put("total_fee", String.valueOf(payPram.getTotal_fee()));
		paraMap.put("out_trade_no", payPram.getOut_trade_no());
		paraMap.put("body", payPram.getBody());
		paraMap.put("openid", payPram.getOpenid());
		
		// 请求统一下单接口获取prepayId等数据
		String getxml = WXPayUtil.generateSignedXml(paraMap, key);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		getxml = restTemplate.postForObject("https://api.mch.weixin.qq.com/pay/unifiedorder", getxml, String.class);
		Map<String, String> getMap = WXPayUtil.xmlToMap(getxml);
		System.out.println(getMap.get("return_code"));
		// 解析数据并返回Json字符串
		if (getMap.get("return_code").equals("SUCCESS") && getMap.get("result_code").equals("SUCCESS")) {
			/*
			 * 改变状态
			 */
			ShopCart shopCart = shopCartInfoService.selectByOrderNo(orderNo);
			shopCart.setStatus("等待商家接单");
			shopCartInfoService.update(shopCart);
			List<PrintOrder> printOrders = printOrderService.selectListByOrderNo(orderNo);
			for (int i = 0; i < printOrders.size(); i++) {
				printOrders.get(i).setStatus("支付成功");
				printOrderService.update(printOrders.get(i));
			}
			
			Map<String, String> apiMap = new HashMap<String, String>();
			apiMap.put("package", "prepay_id=" + getMap.get("prepay_id"));
			apiMap.put("appId", payPram.getAppid());
			apiMap.put("timeStamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
			apiMap.put("nonceStr", WXPayUtil.generateNonceStr());
			apiMap.put("signType", "MD5");
			apiMap.put("paySign", WXPayUtil.generateSignature(apiMap, key));
			apiMap.put("code", "SUCCESS");
			new JSONObject();
			return JSONObject.fromObject(apiMap).toString();
		} else {
			isOK = getMap.get("err_code_des");
		}
		return isOK;
	}

	/**
	 * 支付成功回调接口 更新订单状态 完成下单业务
	 * 
	 * @throws Exception
	 */

	@Transactional
	public String notify_url(String data) throws Exception {
		WxConfig config = new WxConfig();
		String key = config.getKey();
		String isok = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		Map<String, String> map = new HashMap<String, String>();
		map = WXPayUtil.xmlToMap(data);
		System.out.println(map.get("result_code"));
		if (WXPayUtil.isSignatureValid(data, key)) {

			if (map.get("result_code").equals("SUCCESS") && map.get("return_code").equals("SUCCESS")) {

//				PrintOrder order = new PrintOrder();
//				order = printOrderService.selectByOrderNo(map.get("out_trade_no"));
//				order.setStatus("等待商家接单。。。");
//				printOrderService.update(order);
				isok = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

			}
		} else {
			isok = map.get("err_code_des");
		}
		return isok;
	}

	/*
	 * 
	 * 取消订单接口
	 */

	@Transactional
	public String cancelOrder(String out_trade_no, int total_fee) throws Exception {
		String isOK = "{code:FAIl}";
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		RestTemplate restTemplate = new RestTemplate();
		WxConfig wxConfig = new WxConfig();
		String key = wxConfig.getKey();
		RefundDTO refundDTO = new RefundDTO();
		refundDTO.setAppid(wxConfig.getAppid());
		refundDTO.setMch_id(wxConfig.getMch_id());
		refundDTO.setNonce_str(WXPayUtil.generateNonceStr());
		refundDTO.setOut_refund_no(WXPayUtil.generateNonceStr());
		refundDTO.setOut_trade_no(out_trade_no);
		refundDTO.setRefund_fee(total_fee);
		refundDTO.setTotal_fee(total_fee);
		Map<String, String> map = WXPayMapUtil.entityToMap(refundDTO);
		String xmlStr = WXPayUtil.generateSignedXml(map, key);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		xmlStr = WXPayUtil.TransferRestTemplate(url, xmlStr);
		map = WXPayUtil.xmlToMap(xmlStr);
		if (map.get("return_code").equals("SUCCESS") && map.get("result_code").equals("SUCCESS")) {
			ShopCart shopCart = new ShopCart();
			shopCart = shopCartInfoService.selectByOrderNo(map.get("out_trade_no"));
			shopCart.setStatus("退款成功");
			// PrintOrder order = new PrintOrder();
			// order = printOrderMapper.selectByOrderNo(map.get("out_trade_no"));
			// order.setStatus("正在退款中");
			// printOrderMapper.updateByPrimaryKeySelective(order);
			shopCartInfoService.update(shopCart);
			isOK = "退款成功";
		} else {
			isOK = map.get("err_code_des");
		}
		return isOK;
	}

	/**
	 * 退款成功回调接口
	 */
	@Transactional
	public String refund_url(String data) throws Exception {
		String isok = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		Decoder decoder = Base64.getDecoder();
		byte[] bt = decoder.decode(data);
		String code = bt.toString();
		return isok;
	}

}
