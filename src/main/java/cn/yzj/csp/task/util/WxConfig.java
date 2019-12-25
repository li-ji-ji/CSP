package cn.yzj.csp.task.util;

import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WxConfig {
	private String appid;
	private String appSecret;
	private String mch_id;
	private String key;

	public WxConfig() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/csp/api/config/getWeChatPayAll";
		String JsonStr = restTemplate.getForObject(url, String.class);
		JSONArray array = JSONArray.fromObject(JsonStr);
		for (Object object : array) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			switch (jsonObject.getString("configKey")) {
			case "商户id":
				this.mch_id = jsonObject.getString("configValue");
				break;
			case "商户key":
				this.key=jsonObject.getString("configValue");
				break;
			case "appid":
				this.appid=jsonObject.getString("configValue");
				break;
			case "appkey":
				this.appSecret=jsonObject.getString("configValue");
				break;
			default:
				break;
			}
		}
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
