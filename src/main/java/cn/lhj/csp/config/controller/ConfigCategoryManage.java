//package cn.lhj.csp.config.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
//import cn.lhj.csp.config.po.ConfigCategory;
//import cn.lhj.csp.config.service.ConfigCategoryService;
//
//@Controller
//@RequestMapping("/configCategory")
//public class ConfigCategoryManage {
//	
//	@Autowired
//	private ConfigCategoryService configCategoryService;
//	
//	@RequestMapping("/list")
//	public String list(ModelMap map,@RequestParam(required = false, defaultValue = "0")Integer id,@RequestParam(required = false, defaultValue = "null")String operation) {
//		
//		if(operation.equals("delete")) {
//			configCategoryService.delete(id);
//		}	
//		List<ConfigCategory> configCategorys = configCategoryService.getAll();
//		map.addAttribute("configCategorys", configCategorys);
//		return "ftl/configcategory/list";
//	}
//	
//	@RequestMapping("/edit")
//	public String edit(ModelMap map,String operation,ConfigCategory configCategory,@RequestParam(required = false, defaultValue = "0")int id,@RequestParam(required = false, defaultValue = "")String dataType) {
//		if(operation.equals("update")) {
//			configCategory = configCategoryService.findById(id);
//			map.addAttribute("configCategory", configCategory);
//			map.addAttribute("operation", "update");
//		}
//		else if(operation.equals("insert")) {
//			configCategory=new ConfigCategory(0,"");
//			map.addAttribute("configCategory", configCategory);
//			map.addAttribute("operation", "insert");
//		}
//		return "ftl/configcategory/edit";
//	}
//}
