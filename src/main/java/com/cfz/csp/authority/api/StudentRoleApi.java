package com.cfz.csp.authority.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cfz.csp.authority.po.Student;
import com.cfz.csp.authority.po.SysStudentRole;
import com.cfz.csp.authority.service.SysStudentRoleService;

@RestController
@RequestMapping("/bg/studentroleapi")
public class StudentRoleApi {
	@Autowired
	private SysStudentRoleService sysStudentRoleService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		List<SysStudentRole> data = sysStudentRoleService.select(page, limit);
		List<SysStudentRole> datas = null;
		datas = sysStudentRoleService.selectByExample(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", datas.size());
		map.put("data", data);
		return map;
	}
	
	@RequestMapping("/toedit")
	public SysStudentRole toEdit(Integer id) throws Exception {
		System.out.println(id);
		SysStudentRole sysStudentRole = null;
		if (id != null && id > 0) {
			sysStudentRole = sysStudentRoleService.selectByPrimaryKey(id);
		}
		return sysStudentRole;
	}
	
	@RequestMapping("/onedit")
	public Integer edit(@RequestBody SysStudentRole sysStudentRole) throws Exception {
		System.out.println(sysStudentRole);
		Integer row = null;
		if (sysStudentRole.getId() != null && sysStudentRole.getId() > 0) {
			row = sysStudentRoleService.updateByPrimaryKey(sysStudentRole);
		} else {
			row = sysStudentRoleService.insert(sysStudentRole);
		}
		return row;
	}
	 
	@RequestMapping("/delete")
	public Integer delete(Integer id) throws Exception {
		Integer row = sysStudentRoleService.deleteByPrimaryKey(id);
		return row;
	}
	
	@RequestMapping("/batchdelete")
	public Integer batchDelete(String jsonStr) {
		Integer rows = 0;
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		for (Object obj : jsonArray) {
			JSONObject dataObj = JSONObject.parseObject(obj.toString());
			String id = dataObj.getString("id");
			int idI = Integer.parseInt(id);
			int row = sysStudentRoleService.deleteByPrimaryKey(idI);
			rows+=row;
		}
		return rows;
	}
}
