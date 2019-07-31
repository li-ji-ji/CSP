package cn.lhj.csp.authority.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhj.csp.authority.feign.StudentRemote;
import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysRolePermission;

@Controller
@RequestMapping("/authority/permission")
public class SysPermissionController {
	
	@Autowired
	private StudentRemote studentRemote;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("bg --->> permission  ---> index");
		return "/ftl/permission/list";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		studentRemote.permissionDelete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		studentRemote.permissionBatchDelete(jsonStr);
		return "redirect:index";
	}
	
	
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer id) throws Exception {
		System.out.println("bg --->> permission  ---> toedit --->> id: "+id);
		SysPermission sysPermission = studentRemote.permissionToEdit(id);
		model.addAttribute("sysPermission",sysPermission);
		return "ftl/permission/edit";
	}
	
	@RequestMapping("/onedit")
	public String edit(SysPermission sysPermission) throws Exception {
		System.out.println("bg --->> permission  ---> onedit ");
		studentRemote.permissionEdit(sysPermission);
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
		System.out.println("bg --->> permission  ---> all");
		return studentRemote.getPermissionAll(page, limit);
	}
}
