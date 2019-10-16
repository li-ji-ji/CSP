package cn.lhj.csp.authority.api;

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

import cn.lhj.csp.authority.po.SysRolePermission;
import cn.lhj.csp.authority.service.SysRolePermissionService;

@RestController
@RequestMapping("/bg/rolepermissionapi")
public class RolePermissionApi {
	@Autowired
	private SysRolePermissionService sysRolePermissonService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		List<SysRolePermission> data = sysRolePermissonService.select(page, limit);
		List<SysRolePermission> datas = null;
		datas = sysRolePermissonService.selectByExample(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", datas.size());
		map.put("data", data);
		return map;
	}
	
	@RequestMapping("/toedit")
	public SysRolePermission toEdit(Integer id) throws Exception {
		System.out.println(id);
		SysRolePermission sysRolePermission = null;
		if (id != null && id > 0) {
			sysRolePermission = sysRolePermissonService.selectByPrimaryKey(id);
		}
		return sysRolePermission;
	}
	
	@RequestMapping("/onedit")
	public Integer edit(@RequestBody SysRolePermission sysRolePermission) throws Exception {
		System.out.println(sysRolePermission);
		Integer row = null;
		if (sysRolePermission.getId() != null && sysRolePermission.getId() > 0) {
			row = sysRolePermissonService.updateByPrimaryKey(sysRolePermission);
		} else {
			row = sysRolePermissonService.insert(sysRolePermission);
		}
		return row;
	}
	 
	@RequestMapping("/delete")
	public Integer delete(Integer id) throws Exception {
		Integer row = sysRolePermissonService.deleteByPrimaryKey(id);
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
			int row = sysRolePermissonService.deleteByPrimaryKey(idI);
			rows+=row;
		}
		return rows;
	}
}
