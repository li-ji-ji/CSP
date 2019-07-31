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
import cn.lhj.csp.authority.po.SysStudentRole;

@Controller
@RequestMapping("/authority/role")
public class SysRoleController {
	
	@Autowired
	private StudentRemote studentRemote;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("bg --->> role  ---> index");
		return "/ftl/role/list";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		studentRemote.roleDelete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		studentRemote.roleBatchDelete(jsonStr);
		return "redirect:index";
	}
	
	
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer id) throws Exception {
		System.out.println("bg --->> role  ---> toedit --->> id: "+id);
		SysRole sysRole = studentRemote.roleToEdit(id);
		model.addAttribute("sysRole",sysRole);
		return "ftl/role/edit";
	}
	
	@RequestMapping("/onedit")
	public String edit(SysRole sysRole) throws Exception {
		System.out.println("bg --->> role  ---> onedit ");
		studentRemote.roleEdit(sysRole);
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
		System.out.println("bg --->> role  ---> all");
		return studentRemote.getRoleAll(page, limit);
	}
}
