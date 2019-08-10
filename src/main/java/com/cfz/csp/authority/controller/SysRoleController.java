package com.cfz.csp.authority.controller;

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
import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.service.SysRoleService;

@Controller
@RequestMapping("/bg/role")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/index")
	public String index() {
		return "role/list";
	}
	
	/**
	 * 删除
	 * 
	 * @param sn
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		System.out.println(id);
		int row = sysRoleService.deleteByPrimaryKey(id);
		return "redirect:index";
	}
	
	/**
	 * 跳转到编辑
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toedit")
	public String toEdit(Model model,Integer id) throws Exception {
		if (id != null && id > 0) {
			SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
			System.out.println(sysRole.getAvailable());
			model.addAttribute("sysRole",sysRole);
		}
		return "role/edit";
	}
	
	/**
	 * 添加,跟新记录
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/onedit")
	public String edit(SysRole sysRole) throws Exception {
		if(sysRole.getId() != null && sysRole.getId() > 0) {
//			编辑
			sysRoleService.updateByPrimaryKey(sysRole);
		}else{
//			添加
			sysRoleService.insert(sysRole);
		}
		return "redirect:index";
	}
	
	/**
	 * 批量删除
	 * 
	 * @param jsonStr
	 * @return
	 */
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		/**
		 * json字符串解析
		 */
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		for (Object obj : jsonArray) {
			JSONObject dataObj = JSONObject.parseObject(obj.toString());
			String id = dataObj.getString("id");
			int idI = Integer.parseInt(id);
			int row = sysRoleService.deleteByPrimaryKey(idI);
		}
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
}
