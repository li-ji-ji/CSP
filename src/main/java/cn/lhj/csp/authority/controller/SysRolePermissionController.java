package cn.lhj.csp.authority.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhj.csp.authority.feign.StudentRemote;
import cn.lhj.csp.authority.po.SysRole;
import cn.lhj.csp.authority.po.SysRolePermission;

@Controller
@RequestMapping("/authority/rolepermission")
public class SysRolePermissionController {
	
	@Autowired
	private StudentRemote studentRemote;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("bg --->> rolepermission  ---> index");
		return "/ftl/rolepermission/list";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		studentRemote.rolePermissionDelete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		studentRemote.rolePermissionBatchDelete(jsonStr);
		return "redirect:index";
	}
	
	
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer id) throws Exception {
		System.out.println("bg --->> rolepermission  ---> toedit --->> id: "+id);
		SysRolePermission sysRolePermission = studentRemote.rolePermissionToEdit(id);
		model.addAttribute("sysRolePermission",sysRolePermission);
		return "ftl/rolepermission/edit";
	}
	
	@RequestMapping("/onedit")
	public String edit(SysRolePermission sysRolePermission) throws Exception {
		System.out.println("bg --->> rolepermission  ---> onedit ");
		studentRemote.rolePermissionEdit(sysRolePermission);
		return "redirect:index";
	}
	
	
	/**
	 * 列表数据渲染
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		System.out.println("bg --->> rolepermission  ---> all");
		return studentRemote.getRolePermissionAll(page, limit);
	}
}
