package cn.lhj.csp.authority.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.service.StudentService;
import cn.lhj.csp.authority.util.AesCbcUtil;
import cn.lhj.csp.authority.util.HttpRequestsUtil;

@RestController
@RequestMapping("/wx/api")
public class WXLoginController {
	@Autowired
	private StudentService studentService;

	/**
	 * 小程序自动登入
	 * 
	 * @param code
	 * @param encryptedData
	 * @param iv
	 * @param request
	 * @return
	 */
	@RequestMapping("/weixin")
	public Map loginByWeixin(String code, String encryptedData, String iv, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}
		try {
			// 拿到用户session_key和用户敏感数据进行解密，拿到用户信息。
			String sendGet = loginByWeixin(code); // 根据code去调用接口获取用户openid和session_key
			JSONObject json = JSONObject.parseObject(sendGet);
			String sessionkey = json.getString("session_key");// 会话秘钥
			String openid = json.getString("openid");// 用户唯一标识
			Map<String, Object> userInfo = new HashMap<String, Object>();
			userInfo.put("sessionkey", sessionkey);
			userInfo.put("openid", openid);
			System.out.println(sessionkey);
			String decrypts = AesCbcUtil.decrypt(encryptedData, sessionkey, iv, "utf-8");// 解密
			JSONObject jsons = JSONObject.parseObject(decrypts);
			String nickName = jsons.getString("nickName"); // 用户昵称
			String avatarUrl = jsons.getString("avatarUrl"); // 用户头像
			String gender = jsons.getString("gender");// 性别
			String unionid = jsons.getString("unionid"); // unionid
			String city = jsons.getString("city"); // 城市
			String province = jsons.getString("province");// 省份
			String country = jsons.getString("country"); // 国家
			userInfo.put("nickName", nickName);
			userInfo.put("avatarUrl", avatarUrl);
			userInfo.put("gender", gender);
			userInfo.put("unionid", unionid);
			userInfo.put("city", city);
			userInfo.put("province", province);
			userInfo.put("country", country);
			// 查找数据库if（存在openid跟学号对应的 返回status为10，否则status为11）
			map.put("status", 10);
			map.put("msg", "登入成功！");
			map.put("userInfo", userInfo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("status", 0);
		map.put("msg", "解密失败");
		return map;
	}

	/**
	 * 小程序绑定学号
	 * 
	 * @param code
	 * @param encryptedData
	 * @param iv
	 * @param sn
	 * @param request
	 * @return
	 */
	@RequestMapping("/register")
	public Map registerByWeixin(String code, String encryptedData, String iv, String sn, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}
		Student student = null;
		student = studentService.selectByPrimaryKey(Integer.parseInt(sn));
		System.out.println(student);
		if (sn == null || student == null) {
			map.put("status", 0);
			map.put("msg", "改学号不存在！");
			return map;
		}

		try {
			// 拿到用户session_key和用户敏感数据进行解密，拿到用户信息。
			String sendGet = loginByWeixin(code); // 根据code去调用接口获取用户openid和session_key
			JSONObject json = JSONObject.parseObject(sendGet);
			String sessionkey = json.getString("session_key");// 会话秘钥
			String openid = json.getString("openid");// 用户唯一标识
			Map<String, Object> userInfo = new HashMap<String, Object>();
			userInfo.put("sessionkey", sessionkey);
			userInfo.put("openid", openid);
			System.out.println(sessionkey);
			String decrypts = AesCbcUtil.decrypt(encryptedData, sessionkey, iv, "utf-8");// 解密
			JSONObject jsons = JSONObject.parseObject(decrypts);
			String nickName = jsons.getString("nickName"); // 用户昵称
			String avatarUrl = jsons.getString("avatarUrl"); // 用户头像
			String gender = jsons.getString("gender");// 性别
			String unionid = jsons.getString("unionid"); // unionid
			String city = jsons.getString("city"); // 城市
			String province = jsons.getString("province");// 省份
			String country = jsons.getString("country"); // 国家
			userInfo.put("nickName", nickName);
			userInfo.put("avatarUrl", avatarUrl);
			userInfo.put("gender", gender);
			userInfo.put("unionid", unionid);
			userInfo.put("city", city);
			userInfo.put("province", province);
			userInfo.put("country", country);
			userInfo.put("student", student);
			// 将改用户的微信的相关信息openid插ru到该学生中
			map.put("status", 10);
			map.put("msg", "绑定成功！");
			map.put("userInfo", userInfo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("status", 0);
		map.put("msg", "绑定失败");
		return map;
	}

	/**
	 * 微信登录业务实现类:
	 * 
	 * @param openid 用户id
	 * @return User
	 */
	public String loginByWeixin(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 发送
		// https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
		// 获取用户的openid和session_key
		// 注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret
		// 这个也一样，我这里是用了常量来进行保存方便多次使用
		String appId = "wxf8c87e5d14aa1aa5";
		String appSecret = "ae57e2cc64b4653453d39ef69293c3aa";
		String params = "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code
				+ "&grant_type=authorization_code";
		String WeChatTool = "https://api.weixin.qq.com/sns/jscode2session";
		String sendGet = HttpRequestsUtil.sendGet(WeChatTool, params); // 发起请求拿到key和openid
		return sendGet;
	}

}
