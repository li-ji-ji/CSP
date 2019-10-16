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

import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.service.SysPermissionService;

@RestController
@RequestMapping("/bg/permissionapi")
public class PermissionApi {
	@Autowired
	private SysPermissionService sysPermissonService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		List<SysPermission> data = sysPermissonService.select(page, limit);
		List<SysPermission> datas = null;
		datas = sysPermissonService.selectByExample(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", datas.size());
		map.put("data", data);
		return map;
	}
	
	@RequestMapping("/toedit")
	public SysPermission toEdit(Integer id) throws Exception {
		System.out.println(id);
		SysPermission sysPermission = null;
		if (id != null && id > 0) {
			sysPermission = sysPermissonService.selectByPrimaryKey(id);
		}
		return sysPermission;
	}
	
	@RequestMapping("/onedit")
	public Integer edit(@RequestBody SysPermission sysPermission) throws Exception {
		System.out.println(sysPermission);
		Integer row = null;
		if (sysPermission.getId() != null && sysPermission.getId() > 0) {
			row = sysPermissonService.updateByPrimaryKey(sysPermission);
		} else {
			row = sysPermissonService.insert(sysPermission);
		}
		return row;
	}
	 
	@RequestMapping("/delete")
	public Integer delete(Integer id) throws Exception {
		Integer row = sysPermissonService.deleteByPrimaryKey(id);
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
			int row = sysPermissonService.deleteByPrimaryKey(idI);
			rows+=row;
		}
		return rows;
	}
}
