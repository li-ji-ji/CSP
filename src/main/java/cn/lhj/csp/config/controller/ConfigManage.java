//package cn.lhj.csp.config.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
//import cn.lhj.csp.config.po.Config;
//import cn.lhj.csp.config.po.ConfigCategory;
//import cn.lhj.csp.config.service.ConfigCategoryService;
//import cn.lhj.csp.config.service.ConfigService;
//import cn.lhj.csp.config.vm.ConfigVm;
//
//@Controller
//@RequestMapping("/config")
//public class ConfigManage {
//	
//	@Autowired
//	private ConfigService configService;
//	@Autowired
//	private ConfigCategoryService configCategoryService;
//	
//	@RequestMapping("/list")
//	public String list(ModelMap map,@RequestParam(required = false, defaultValue = "0")Integer id,@RequestParam(required = false, defaultValue = "null")String enable,@RequestParam(required = false, defaultValue = "null")String operation) {
//		if(!enable.equals("null")) {
//			configService.updateEnableById(id, enable);
//		}
//		if(operation.equals("delete")) {
//			configService.delete(id);
//		}
//		List<String> types = configService.getTypes();	
//		List<ConfigVm> configVms = new ArrayList<>();
//		for(String  type : types) {	
//			ConfigVm configVm = new ConfigVm();
//			List<Config> list = configService.selectByType(type);
//			configVm.setType(type);
//			configVm.setConfigs(list);
//			configVms.add(configVm);
//		}
//		map.addAttribute("configVms", configVms);
//		return "ftl/config/list";
//	}
//	
//	@RequestMapping("/edit")
//	public String edit(ModelMap map,String operation,Config config,@RequestParam(required = false, defaultValue = "0")int id,@RequestParam(required = false, defaultValue = "")String dataType) {
//		List<ConfigCategory> configCategorys = configCategoryService.getAll();
//		if(operation.equals("update")) {
//			config = configService.findById(id);
//			map.addAttribute("config", config);
//			map.addAttribute("configCategorys", configCategorys);
//			return "ftl/config/update";
//		}
//		else if(operation.equals("insert")) {
//			config=new Config(0,"","",dataType,"","");
//			map.addAttribute("config", config);
//			map.addAttribute("operation", "insert");
//			map.addAttribute("configCategorys", configCategorys);
//			return "ftl/config/insert";
//		}
//		return "ftl/config/insert";
//	}
//	
//}
//
