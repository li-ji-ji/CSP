package cn.yzj.shop.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.yzj.shop.po.LoginDTO;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.AdminService;
import cn.yzj.shop.service.ConfigService;
import cn.yzj.shop.service.SystemsModule;
import cn.yzj.shop.util.RequestUtil;
import cn.yzj.shop.util.WXPayUtil;

/*
 * 
 *yzj
 *2019
 *2019年9月15日
 */
@Controller
@RequestMapping("/admin")
public class AdminControler {

	@Autowired
	private SystemsModule systemsModule;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ConfigService config;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("/admin/index");
		modelAndView.addObject("model", systemsModule.getSelectTree());
		modelAndView.addObject("config", config.find("admin_index"));
		Cookie[] cookies = request.getCookies();
		short user = 0;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				user = Short.valueOf(cookie.getValue());
			}
		}
		modelAndView.addObject("user", adminService.find(user));
		return modelAndView;
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome(ModelAndView modelAndView, HttpServletRequest request) throws Exception {
		modelAndView.setViewName("/admin/welcome");
		modelAndView.addObject("time", WXPayUtil.getNewTime());
		Map<String, String> map = new HashMap<String, String>();
		InetAddress addr = InetAddress.getLocalHost();
		map.put("localHost", addr.getHostAddress());// 服务器ip
		map.put("localName", addr.getHostName());// 服务器名
		map.put("localOs",
				System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version"));// 服务器
		map.put("javaVersion", System.getProperty("java.version"));// java

		map.put("osName", RequestUtil.getOsName(request));// 操作系统
		map.put("manufacturer", RequestUtil.getDeviceManufacturer(request));// 客户端生产商
		map.put("devicetype", RequestUtil.getDevicetype(request));// 客户端类型
		map.put("borderGroup",
				RequestUtil.getBorderGroup(request) + " / " + RequestUtil.getBrowserVersion(request) + " / "
						+ RequestUtil.getBorderRenderingEngine(request) + " / " + RequestUtil.getBorderType(request)
						+ " / " + RequestUtil.getBrowserManufacturer(request));// 浏览器信息
		modelAndView.addObject("information", map);
		modelAndView.addObject("config", config.find("admin_welcome"));
		Cookie[] cookies = request.getCookies();
		short user = 0;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				user = Short.valueOf(cookie.getValue());
			}
		}
		modelAndView.addObject("user", adminService.find(user));
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		String uuid = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("token")) {
				uuid = cookie.getValue();
			}
		}
		modelAndView.setViewName("/admin/login");
		modelAndView.addObject("config", config.find("admin_index"));
		if (redisTemplate.getExpire(uuid) > 0) {
			response.sendRedirect("/admin/index");
		}
		return modelAndView;
	}

}
