package cn.yzj.shop.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.AdminRole;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.AdminRoleService;

/*
 *yzj
 *2019
 *2019年9月21日
 */
@RestController
@RequestMapping("/api")
public class AdminRoleApi {
	@Autowired
	private AdminRoleService roleService;
	
	@RequestMapping("/getRoleList")
	public Serializable getRoleList(@RequestParam(value ="limit",defaultValue ="20")int limit,@RequestParam(value ="page",defaultValue ="1")int page) throws Exception {
		return roleService.dataPage(limit, page);
		
	}
	@RequestMapping("/addRole")
	public Msg addRole(AdminRole role) throws Exception {
		return roleService.add(role);
		
	}
	
	@RequestMapping("/deleteRole")
	public Msg deleteRole(@RequestParam("ids")String ids) throws Exception {
		return roleService.delete(ids);
	}
	
	@RequestMapping("/updateRole")
	public Msg updataRole(AdminRole role) throws Exception {
		return roleService.updata(role);
	}
	@RequestMapping("/getRoleTree")
	public Serializable getRoleTree() throws Exception {
		return roleService.find();
	}
}
