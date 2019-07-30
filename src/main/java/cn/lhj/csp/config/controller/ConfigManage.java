package cn.lhj.csp.config.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.config.feign.ConfigApiInterface;
import cn.lhj.csp.config.po.Config;

@Controller
@RequestMapping("/config")
public class ConfigManage {
	
	@Autowired
	private ConfigApiInterface configApiInterface;
	
	@RequestMapping("/list")
	public String list(ModelMap map,@RequestParam(required = false, defaultValue = "0")Integer id,@RequestParam(required = false, defaultValue = "null")String enable,@RequestParam(required = false, defaultValue = "null")String operation) {
		if(!enable.equals("null")) {
			configApiInterface.updateEnableById(id, enable);
		}
		if(operation.equals("delete")) {
			configApiInterface.delete(id);
		}
		List<Config> systems = configApiInterface.selectByType("系统配置");
		List<Config> websites = configApiInterface.selectByType("网站配置");
		List<Config> mails = configApiInterface.selectByType("邮件配置");
		List<Config> messages = configApiInterface.selectByType("短信配置");
		List<Config> tencentClouds = configApiInterface.selectByType("腾讯云配置");
		List<Config> wechats = configApiInterface.selectByType("微信支付配置");
		map.addAttribute("systems", systems);
		map.addAttribute("websites", websites);
		map.addAttribute("mails", mails);
		map.addAttribute("messages", messages);
		map.addAttribute("tencentClouds", tencentClouds);
		map.addAttribute("wechats", wechats);
		return "ftl/config/list";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap map,String operation,Config config,@RequestParam(required = false, defaultValue = "0")int id,@RequestParam(required = false, defaultValue = "")String dataType) {
		if(operation.equals("update")) {
			config = configApiInterface.getById(id);
			map.addAttribute("config", config);
			map.addAttribute("operation", "update");
		}
		else if(operation.equals("insert")) {
			config=new Config(0,"","",dataType,"","");
			map.addAttribute("config", config);
			map.addAttribute("operation", "insert");
		}
		return "ftl/config/edit";
	}
	
	@RequestMapping("/upload")
	public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile)throws Exception{
		return configApiInterface.upload(multfile);
	}
	
}

