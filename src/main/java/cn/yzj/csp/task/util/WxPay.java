package cn.yzj.csp.task.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.codec.Charsets;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.yzj.csp.task.po.PayPram;
import cn.yzj.csp.task.po.RefundDTO;
import net.sf.json.JSONObject;

@Component
public class WxPay {
//	@Autowired
//	private RestTemplate restTemplate;
//	private String appid = "wxe721fcd7e4f66bda";// 小程序ip 68
//	private String mch_id = "1546321581";// 商户id 86
//	private String nonce_str;// 随机字符串 86
//	private String trade_type = "JSAPI";// 交易类型 86
//	private String notify_url = "http://244z00029g.zicp.vip/notify_url";// 通知地址
//	private String spbill_create_ip = "";// 主机ip
//	private int total_fee = 0;// 金额
//	private String out_trade_no = "";// 商户订单编号 唯一
//	private String body = "CSP=任务支付测试";
//	private String sign = "";// 参数签名
	private String key = "QZXXGCXYlbz187603238431234567890";

	public String getPrepayId(String code, String ip, int total_fee) throws Exception {
		String isOK = "{code:FAIl}";
		// 请求接口获取openid
		RestTemplate restTemplate = new RestTemplate();
		PayPram payPram = new PayPram();
		payPram.setNonce_str(getNonce_str());
		payPram.setSpbill_create_ip(ip);
		payPram.setTotal_fee(total_fee);
		payPram.setOut_trade_no(getNonce_str());
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + payPram.getAppid()
				+ "&secret=8ab77f2e1e2c0f4c148c9bf43a6422a2&js_code=" + code + "&grant_type=authorization_code";
		String massage = restTemplate.getForObject(url, String.class);
		JSONObject jsonObject = JSONObject.fromObject(massage);
		String Openid = jsonObject.getString("openid");
		payPram.setOpenid(Openid);
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
		isOK = getxml + ip;
		Map<String, String> getMap = WXPayUtil.xmlToMap(getxml);
		System.out.println(getMap.get("return_code"));
		// 解析数据并返回Json字符串
		if (getMap.get("return_code").equals("SUCCESS") && getMap.get("result_code").equals("SUCCESS")) {
			Map<String, String> apiMap = new HashMap<String, String>();
			apiMap.put("package", "prepay_id=" + getMap.get("prepay_id"));
			apiMap.put("appId", payPram.getAppid());
			apiMap.put("timeStamp", String.valueOf(getTime()));
			apiMap.put("nonceStr", getNonce_str());
			apiMap.put("signType", "MD5");
			apiMap.put("paySign", WXPayUtil.generateSignature(apiMap, key));
			apiMap.put("code", "SUCCESS");
			new JSONObject();
			return JSONObject.fromObject(apiMap).toString();
		}

		return isOK;
	}

	/**
	 * 退款模块
	 * 
	 * @return String code
	 * @throws Exception
	 */
	public String refund(String out_trade_no, int total_fee) throws Exception {
		String code = "{code:FAIl}";
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
		xmlStr = TransferRestTemplate(url, xmlStr);
		map = WXPayUtil.xmlToMap(xmlStr);
		System.out.println(map.get("return_code"));
		return code;
	}

	public String getNonce_str() throws Exception {
		String nonce_str = null;
		String number = "";
		for (int i = 0; i < 5; i++) {
			int double1 = (int) (Math.random() * 10);
			number = number + double1;
		}

		long date = getTime();
		nonce_str = date + number.trim();
		return nonce_str;
	}

	public Long getTime() {
		Date dates = new Date();
		long date = dates.getTime();
		return date;
	}

	public String packageSign(Map<String, String> params, boolean urlEncoder) {
		// 先将参数以其参数名的字典序升序进行排序
		TreeMap<String, String> sortedParams = new TreeMap<String, String>(params);
		// 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Entry<String, String> param : sortedParams.entrySet()) {
			String value = param.getValue();
			if (isEmpty(value)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				sb.append("&");
			}
			sb.append(param.getKey()).append("=");
			if (urlEncoder) {
				try {
					value = urlEncode(value);
				} catch (UnsupportedEncodingException e) {
				}
			}
			sb.append(value);
		}
		return sb.toString();
	}

	public static boolean isEmpty(String s) {
		return s == null || "".equals(s) || "null".equals(s);
	}

	public static String urlEncode(String src) throws UnsupportedEncodingException {
		return URLEncoder.encode(src, Charsets.UTF_8.name()).replace("+", "%20");
	}

	public static String MD5(String data, String key) throws Exception {
		key = "&key=" + key;
		data = data + "key";
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	public String TransferRestTemplate(String url, String data) throws KeyStoreException, IOException,
			CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File("E:/cert/apiclient_cert.p12"));
		keyStore.load(instream, "1546321581".toCharArray());
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContextBuilder.create().loadKeyMaterial(keyStore, "1546321581".toCharArray())
				.build();
		// Allow TLSv1 protocol only
		HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				hostnameVerifier);

		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpclient);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Connection", "keep-alive");
		requestHeaders.add("Accept", "*/*");
		requestHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		requestHeaders.add("Host", "api.mch.weixin.qq.com");
		requestHeaders.add("X-Requested-With", "XMLHttpRequest");
		requestHeaders.add("Cache-Control", "max-age=0");
		requestHeaders.add("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String response = restTemplate.postForObject(url,data,
				String.class);
		return response;

	}

}
