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

import cn.lhj.csp.authority.mapper.SysStudentRoleMapper;
import cn.lhj.csp.authority.po.SysStudentRole;
import cn.lhj.csp.authority.service.SysStudentRoleService;

@Controller
@RequestMapping("/bg/studentrole")
public class SysStudentRoleController {
	
	@Autowired
	private SysStudentRoleMapper sysStudentRoleMapper;
	
	@Autowired
	private SysStudentRoleService sysStudentRoleService;
	
	@RequestMapping("/index")
	public String index() {
		return "studentrole/list";
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
			SysStudentRole sysStudentRole = sysStudentRoleService.selectByPrimaryKey(id);
			model.addAttribute("sysStudentRole",sysStudentRole);
		}
		return "studentrole/edit";
	}

	/**
	 * 添加,跟新记录
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/onedit")
	public String edit(SysStudentRole sysStudentRole) throws Exception {
		if(sysStudentRole.getId() != null && sysStudentRole.getId() > 0) {
//			编辑
			sysStudentRoleService.updateByPrimaryKey(sysStudentRole);
		}else{
//			添加
			sysStudentRoleService.insert(sysStudentRole);
		}
		return "redirect:index";
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
		int row = sysStudentRoleService.deleteByPrimaryKey(id);
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
		System.out.println("student -->> batchdelete");
		/**
		 * json字符串解析
		 */
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		for (Object obj : jsonArray) {
			JSONObject dataObj = JSONObject.parseObject(obj.toString());
			String id = dataObj.getString("id");
			int idI = Integer.parseInt(id);
			int row = sysStudentRoleService.deleteByPrimaryKey(idI);
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
}
