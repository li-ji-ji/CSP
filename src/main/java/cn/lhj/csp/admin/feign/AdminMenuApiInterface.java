package cn.lhj.csp.admin.feign;


import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.config.po.Config;




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
	//分页获取数据并以Layui数据格式返回
	@RequestMapping(value="/getMenuLimit")
	public String getMenuLimit(@RequestParam("page")Integer page,@RequestParam("limit")Integer count);
	//根据ID查询后台菜单
	@RequestMapping("/getById")
	public int getById(@RequestParam("id") Integer id)throws Exception;
	@RequestMapping("/getLayUIJSONByPid")
	public String getLayUIJSONByPid(@RequestParam("pid") Integer pid,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception;	
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception;
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception;
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception;
	
	/*配置管理*/
	@RequestMapping("/api/config/getAllConfig")
	public List<Config> getAllConfig();
	
	@RequestMapping("/api/config/layuigetAll")
	public Map<String, Object> layuigetAll(@RequestParam(value = "name") int page,
			@RequestParam(value = "limit") int limit);
	
	@RequestMapping("/api/config/getConfigById")
	public Config getConfigById(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/config/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestBody Config config, @RequestParam(value="id",required = false, defaultValue = "0") int id);
	
	@RequestMapping("/api/config/updateEnableById")
	public void updateEnableById(@RequestParam(value = "id")Integer id,@RequestParam(value = "enable") String enable);
	
	@RequestMapping("/api/config/delete")
	public void delete(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/config/selectByType")
	public List<Config> selectByType(@RequestParam(value = "type")String type);
	
	@RequestMapping("/api/config/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile)throws Exception;
	
	@RequestMapping("/api/config/insertConfigOne")
	public int insertConfigOne(@RequestBody Config config )throws Exception;
	
	@RequestMapping("/api/config/updateConfigOne")
	public int updateConfigOne(@RequestBody Config config )throws Exception;
}
