package cn.lhj.csp.adminmenu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lhj.csp.adminmenu.service.CspAdminMenuService;

@Controller
@RequestMapping("/csp/adminmenu")
public class AdminMenuController {

	@Autowired
	private CspAdminMenuService cspAdminMenuService;
	
	@RequestMapping("/toIndex")
	public String toIndex(Model model)throws Exception{
		return "ftl/admin/Table";
	}
}
