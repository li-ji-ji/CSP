package cn.lhj.csp.adminmenu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.adminmenu.po.CspBackgroundMenu;
import cn.lhj.csp.adminmenu.service.CspBackgroundMenuService;

@RestController
@RequestMapping("csp/api/adminmenu")
@CrossOrigin
public class CspBackgroundMenuAPI {

	@Autowired
	private CspBackgroundMenuService cspBackgroundMenuService;
	
	//获取所有后台菜单以JSON格式返回
	@RequestMapping("/getAll")
	public List<CspBackgroundMenu> getAll()throws Exception{
		return cspBackgroundMenuService.getAll();
	}
}
