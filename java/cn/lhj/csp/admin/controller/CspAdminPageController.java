package cn.lhj.csp.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/csp/admin")
@CrossOrigin
public class CspAdminPageController {
	

	// 跳转到后台管理界面
	@RequestMapping("/toIndex")
	public String toIndex() throws Exception {
		return "ftl/admin/AdminPage";
	}

	// 跳转到通用所有菜单表格
	@RequestMapping("/toTable")
	public String toMenuTable(String tableName, Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		tableName = request.getParameter("tableName");
		//List<Map> stringList = cspBackgroundMenuService.getColunmByTableName(tableName);
		// System.out.println("获取的列名:" + stringList);
		//model.addAttribute("nameList", stringList);
		return "ftl/admin/Table";
	}
}
