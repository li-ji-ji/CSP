package cn.lhj.csp.config.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigCategory;

@RestController
@CrossOrigin
public class ConfigFeignAPI {
	
	@Autowired
	private AdminMenuApiInterface configFeign;

	@RequestMapping("/api/config/getConfigById")
	public Config getConfigById(Integer id) {
		return configFeign.getByIdConfig(id);
	}
	
	@RequestMapping("/api/config/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestParam(value = "configJSON") String getConfig, @RequestParam(value="id",required = false, defaultValue = "0") int id) throws Exception {
		Config config=JSON.parseObject(getConfig, Config.class);
		if (operation.equals("delete")) {
			configFeign.delete(id);
		} else if (operation.equals("insert")) {
			configFeign.insertConfigOne(config);
		} else if (operation.equals("update")) {
			configFeign.updateConfigOne(config);
		}
		return ;
	}
	
	@RequestMapping("/api/config/insert")
	public String insertConfig(@RequestBody Config config) throws Exception {
		configFeign.insertConfigOne(config);
		System.out.println("增加");
		return "增加成功";
	}
	
	@RequestMapping("/api/config/delete")
	public String deleteConfig(@RequestParam("id")Integer id) {
		configFeign.delete(id);
		return "删除成功";
	}
	
	@RequestMapping("/api/config/update")
	public String updateConfig(@RequestBody Config config) throws Exception {
		configFeign.updateConfigOne(config);
		System.out.println("修改");
		return "修改成功";
	}
	
	@RequestMapping("/api/config/insertConfigOne")
	public int insertConfigOne(@RequestBody Config config)throws Exception{
		return configFeign.insertConfigOne(config);
	}
	
	@RequestMapping("/api/configCategory/getAll")
	public List<ConfigCategory> getAllConfigCategory(){
		return configFeign.getAllConfigCategory();
	}
	
	@RequestMapping("/api/configCategory/edit")
	public void editConfigCategory(@RequestParam("operation")String operation,@RequestParam("editid")String editid,@RequestParam("name")String name, @RequestParam(required = false, defaultValue = "0") int id) {
		ConfigCategory configCategory = new ConfigCategory(Integer.parseInt(editid), name);		
		if (operation.equals("delete")) {
			configFeign.deleteConfigCategory(id);
		} else if (operation.equals("insert")) {		
			configFeign.insertConfigCategory(configCategory);
		} else if (operation.equals("update")) {		
			configFeign.updateConfigCategory(configCategory);
		}
	}
	
	@RequestMapping("/api/configCategory/insert")
	public String insertConfigCategory(@RequestBody ConfigCategory configCategory) {
		configFeign.insertConfigCategory(configCategory);
		return "增加成功";
	}
	
	@RequestMapping("/api/configCategory/delete")
	public String deleteConfigCategory(@RequestParam("id") Integer id) {
		configFeign.deleteConfigCategory(id);
		return "删除成功";
	}
	
	@RequestMapping("/api/configCategory/update")
	public String updateConfigCategory(@RequestBody ConfigCategory configCategory) {
		configFeign.updateConfigCategory(configCategory);
		return "修改成功";
	}
	
	@RequestMapping("/api/configCategory/findById")
	public ConfigCategory findByIdConfigCategory(@RequestParam("id")Integer id) {
		return configFeign.findByIdConfigCategory(id);
	}
}
