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
import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.po.SysStudentRole;
import com.cfz.csp.authority.service.SysRoleService;

@RestController
@RequestMapping("/bg/roleapi")
public class RoleApi {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		List<SysRole> data = sysRoleService.select(page, limit);
		List<SysRole> datas = null;
		datas = sysRoleService.selectByExample(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", datas.size());
		map.put("data", data);
		return map;
	}
	
	@RequestMapping("/toedit")
	public SysRole toEdit(Integer id) throws Exception {
		System.out.println(id);
		SysRole sysRole = null;
		if (id != null && id > 0) {
			sysRole = sysRoleService.selectByPrimaryKey(id);
		}
		return sysRole;
	}
	
	@RequestMapping("/onedit")
	public Integer edit(@RequestBody SysRole sysRole) throws Exception {
		System.out.println(sysRole);
		Integer row = null;
		if (sysRole.getId() != null && sysRole.getId() > 0) {
			row = sysRoleService.updateByPrimaryKey(sysRole);
		} else {
			row = sysRoleService.insert(sysRole);
		}
		return row;
	}
	 
	@RequestMapping("/delete")
	public Integer delete(Integer id) throws Exception {
		Integer row = sysRoleService.deleteByPrimaryKey(id);
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
			int row = sysRoleService.deleteByPrimaryKey(idI);
			rows+=row;
		}
		return rows;
	}
}
