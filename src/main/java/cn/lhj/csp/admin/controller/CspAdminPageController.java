package cn.lhj.csp.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;

/*
 * 后台管理界面controller
 * */

@Controller
@RequestMapping("/csp/admin")
@CrossOrigin
public class CspAdminPageController {
	
	@Autowired
	AdminMenuApiInterface adminMenuApi;
	
	
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
	public String toMenuFrom()throws Exception{
		return "ftl/admin/Form";
	}
}
