package cn.lhj.csp.admin.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.menu.po.CspAdminMenu;
import cn.lhj.csp.menu.service.CspAdminMenuService;



/*
 *通过feign获取数据
 * */
@RestController
@RequestMapping("/feign/adminMenu")
@CrossOrigin
public class AdminMenuFeignAPI {
	
	@Autowired
	private CspAdminMenuService adminMenuService;
	
	//获取普通JSON数据
	@RequestMapping("/getAll")
	public String getAll() throws Exception {
		return JSON.toJSONString(adminMenuService.getAll());
	}
	
	//获取LayUI接口格式jSON数据
	@RequestMapping("/getAllToLayUI")
	public String getAllToLayUI() throws Exception {
		return JSON.toJSONString(adminMenuService.getAllMenuToLayuiJson());
	}

	//分页获取数据并以Layui数据格式返回
	@RequestMapping(value="/getMenuLimit")
	public String getMenuLimit(@RequestParam("page")Integer page,@RequestParam("limit")Integer count) throws Exception {
		return JSON.toJSONString(adminMenuService.selectMenuLimitToJSON(page, count));
	}
	
	//获取数据表字段名
	@RequestMapping("/getColumnName")
	public String getColumnName() throws Exception  {
		List<Map> getColumn=adminMenuService.getColunmByTableName("csp_admin_menu");
		JSONArray column=JSONArray.parseArray(JSONObject.toJSONString(getColumn));
		return column.toJSONString();
	}
	
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception{
		CspAdminMenu menu=JSON.parseObject(getMsg, CspAdminMenu.class);
		return adminMenuService.insert(menu);
	}

	//根据ID查询后台菜单
	@RequestMapping("/getById")
	public CspAdminMenu getById(@RequestParam("id") Integer id)throws Exception{
		return adminMenuService.getById(id);
	}
	@RequestMapping("/getLayUIJSONByPid")
	public String getLayUIJSONByPid(@RequestParam("pid") Integer pid,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception{
		return JSON.toJSONString(adminMenuService.getLayUIJSONByPid(pid, page, limit));
	}
	
	
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception{
		return adminMenuService.deleteById(id);
	}
	
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception{
		CspAdminMenu menu=JSON.parseObject(getMsg, CspAdminMenu.class);
		return adminMenuService.updateSeletiveById(menu);
	}
}
