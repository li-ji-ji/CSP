package cn.lhj.csp.authority.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.authority.feign.StudentRemote;
import cn.lhj.csp.authority.po.SysStudentRole;

@Controller
@RequestMapping("/authority/studentrole")
public class SysStudentRoleController {
	
	@Autowired
	private StudentRemote studentRemote;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("bg --->> studentrole  ---> index");
		return "/ftl/studentrole/list";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		studentRemote.studentRoleDelete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		studentRemote.studentRoleBatchDelete(jsonStr);
		return "redirect:index";
	}
	
	
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer id) throws Exception {
		System.out.println("bg --->> studentrole  ---> toedit --->> id: "+id);
		SysStudentRole sysStudentRole = studentRemote.studentRoleToEdit(id);
		model.addAttribute("sysStudentRole",sysStudentRole);
		return "ftl/studentrole/edit";
	}
	
	@RequestMapping("/onedit")
	public String edit(SysStudentRole sysStudentRole) throws Exception {
		System.out.println("bg --->> studentrole  ---> onedit ");
		studentRemote.studentRoleEdit(sysStudentRole);
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
		System.out.println("bg --->> studentrole  ---> all");
		return studentRemote.getStudentRoleAll(page, limit);
	}
}
