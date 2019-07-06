package cn.lhj.csp.admin.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name="csp-admin-menu")
public interface AdminMenuApiInterface {
	//获取所有后台菜单
	@RequestMapping(value="/getAll")
	public String getAll();
	//获取菜单表列名
	@RequestMapping(value="/getColumnName")
	public String getColumnName();
	//获取所有后台菜单以LayUI数据格式返回
	@RequestMapping(value="/getAllToLayUI")
	public String getAllToLayUI();
	//根据ID查询后台菜单
	@RequestMapping("/getById")
	public int getById(@RequestParam("id") Integer id)throws Exception;
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception;
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception;
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception;
}
