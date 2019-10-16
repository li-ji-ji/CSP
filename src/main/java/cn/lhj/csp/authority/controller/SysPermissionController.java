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

import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.service.SysPermissionService;

@Controller
@RequestMapping("/bg/permission")
public class SysPermissionController {
	@Autowired
	private SysPermissionService sysPermissonService;

	@RequestMapping("/index")
	public String index() {
		return "permission/list";
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
		int row = sysPermissonService.deleteByPrimaryKey(id);
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
			SysPermission sysPermission = sysPermissonService.selectByPrimaryKey(id);
			model.addAttribute("sysPermission",sysPermission);
		}
		return "permission/edit";
	}
	
	/**
	 * 添加,跟新记录
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/onedit")
	public String edit(SysPermission sysPermission) throws Exception {
		if(sysPermission.getId() != null && sysPermission.getId() > 0) {
//			编辑
			System.out.println("编辑");
			sysPermissonService.updateByPrimaryKey(sysPermission);
			System.out.println("&--------");
		}else{
//			添加
			System.out.println("添加");
			sysPermissonService.insert(sysPermission);
			System.out.println("+----------");
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
			int row = sysPermissonService.deleteByPrimaryKey(idI);
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
}
