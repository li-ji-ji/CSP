package cn.lhj.csp.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;


/*
 *通过feign获取数据
 * */
@RestController
@RequestMapping("/feign/adminMenu")
@CrossOrigin
public class AdminMenuApiFeign {
	
	@Autowired
	AdminMenuApiInterface adminMenuApiInterface;
	
	//获取普通JSON数据
	@RequestMapping("/getAll")
	public String getAll() {
		return adminMenuApiInterface.getAll();
	}
	
	//获取LayUI接口格式jSON数据
	@RequestMapping("/getAllToLayUI")
	public String getAllToLayUI() {
		return adminMenuApiInterface.getAllToLayUI();
	}

	//分页获取数据并以Layui数据格式返回
	@RequestMapping(value="/getMenuLimit")
	public String getMenuLimit(@RequestParam("page")Integer page,@RequestParam("limit")Integer count){
		return adminMenuApiInterface.getMenuLimit(page, count);
	}
	
	//获取数据表字段名
	@RequestMapping("/getColumnName")
	public String getColumnName() {
		return adminMenuApiInterface.getColumnName();
	}
	
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception{
		return adminMenuApiInterface.addOne(getMsg);
	}

	//根据ID查询后台菜单
	@RequestMapping("/getById")
	public int getById(@RequestParam("id") Integer id)throws Exception{
		return adminMenuApiInterface.getById(id);
	}
	@RequestMapping("/getLayUIJSONByPid")
	public String getLayUIJSONByPid(@RequestParam("pid") Integer pid,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception{
		return adminMenuApiInterface.getLayUIJSONByPid(pid, page, limit);
	}
	
	
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception{
		return adminMenuApiInterface.delById(id);
	}
	
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception{
		return adminMenuApiInterface.updateOne(getMsg);
	}
}
