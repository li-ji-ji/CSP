package cn.lhj.csp.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;

import cn.lhj.csp.menu.service.CspAdminMenuService;

/*
 * 后台管理界面controller
 * */

@Controller
@RequestMapping("/admin")
@CrossOrigin
public class CspAdminPageController {
	
	@Autowired
	private CspAdminMenuService adminMenuService;
	
	
	// 跳转到后台管理界面
	@RequestMapping("/toIndex")
	public String toIndex(Model model) throws Exception {
		return "ftl/admin/AdminPage";
	}
	
	// 跳转到所有菜单表格
	@RequestMapping("/toTable")
	public String toMenuTable() throws Exception {
		//List<Map> stringList = cspBackgroundMenuService.getColunmByTableName(tableName);
		// System.out.println("获取的列名:" + stringList);
		//model.addAttribute("nameList", stringList);
		return "ftl/admin/Table";
	}
	
	//跳转到添加菜单表单
	@RequestMapping("/toForm")
	public String toMenuFrom(Model model)throws Exception{
		System.out.println(adminMenuService.getAll());
		JSONArray AdminMenuList =JSONArray.parseArray(adminMenuService.getShowMenuToJson());
		model.addAttribute("AdminMenuList",AdminMenuList);
		return "ftl/admin/Form";
	}
	
	//跳转到欢迎页
	@RequestMapping("/toWelcome")
	public String toWelcome(@RequestParam("name") String name,Model model)throws Exception{
		model.addAttribute("name", name);
		return "ftl/admin/welcome";
	}
}
