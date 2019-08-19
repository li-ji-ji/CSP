package cn.lhj.csp.config.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigCategory;
import cn.lhj.csp.config.service.ConfigCategoryService;
import cn.lhj.csp.config.service.ConfigService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
public class ConfigApi {

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private ConfigCategoryService configCategoryService;

	@ApiOperation(value = "获取配置详细信息")
	@RequestMapping("/api/config/getAll")
	public List<Config> getAllConfig() {
		return configService.selectAll();
	}

	@ApiOperation(value = "获取layui所有配置详细信息")
	@RequestMapping("/api/config/layuigetAll")
	public Map<String, Object> layuigetAllConfig(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "100") int limit) {
		List<Config> data = configService.select(page, limit);
		List<Config> datas = configService.selectAll();
		int count = datas.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", data);
		return map;
	}

	@ApiOperation(value = "获取配置详细信息", notes = "根据url的id来获取配置详细信息")
	@RequestMapping("/api/config/getById")
	public Config getByIdConfig(@RequestParam("id")Integer id) {
		return configService.findById(id);
	}

	@ApiOperation(value = "增加配置详细信息", notes = "增加配置详细信息")
	@RequestMapping("/api/config/insert")
	public String insertConfig(@RequestBody Config config) {
		configService.insert(config);
		return "增加成功";
	}
	
	@RequestMapping("/api/config/delete")
	public String deleteConfig(@RequestParam("id")Integer id) {
		configService.delete(id);
		return "删除成功";
	}
	
	@RequestMapping("/api/config/update")
	public String updateConfig(@RequestBody Config config) {
		configService.update(config);
		System.out.println("修改");
		return "修改成功";
	}
	
	@RequestMapping("/api/config/updateEnableById")
	public void updateEnableById(@RequestParam("id")Integer id, @RequestParam("enable")String enable) {
		configService.updateEnableById(id, enable);
	}
	
	@RequestMapping("/api/config/selectByType")
	public List<Config> selectByType(@RequestParam("type")String type){
		return configService.selectByType(type);
	}
	
	@RequestMapping("/api/config/getTypes")
	public List<String> getTypes() {
		return configService.getTypes();
	}
	
	@RequestMapping("/api/configCategory/getAll")
	public List<ConfigCategory> getAllConfigCategory(){
		return configCategoryService.getAll();
	}
	
	@ApiOperation(value = "增加配置分类详细信息", notes = "增加配置分类详细信息")
	@RequestMapping("/api/configCategory/edit")
	public void editConfigCategory(@RequestParam("operation")String operation,@RequestParam("editid")String editid,@RequestParam("name")String name, @RequestParam(required = false, defaultValue = "0") int id) {
		ConfigCategory configCategory = new ConfigCategory(Integer.parseInt(editid), name);		
		if (operation.equals("delete")) {
			configCategoryService.delete(id);
		} else if (operation.equals("insert")) {		
			configCategoryService.insert(configCategory);
		} else if (operation.equals("update")) {		
			configCategoryService.update(configCategory);
		}
	}
	
	@RequestMapping("/api/configCategory/insert")
	public String insertConfigCategory(@RequestBody ConfigCategory configCategory) {
		configCategoryService.insert(configCategory);
		return "增加成功";
	}
	
	@RequestMapping("/api/configCategory/delete")
	public String deleteConfigCategory(@RequestParam("id")Integer id) {
		configCategoryService.delete(id);
		return "删除成功";
	}
	
	@RequestMapping("/api/configCategory/update")
	public String updateConfigCategory(@RequestBody ConfigCategory configCategory) {
		configCategoryService.update(configCategory);
		return "修改成功";
	}
	
	
	@RequestMapping("/api/configCategory/findById")
	public ConfigCategory findByIdConfigCategory(@RequestParam("id")Integer id) {
		return configCategoryService.findById(id);
	}
	
	@RequestMapping("/api/configCategory/findByConfigKey")
	public Config findByConfigKey(String configKey) {
		return configService.findByConfigKey(configKey);
	}
	
}
