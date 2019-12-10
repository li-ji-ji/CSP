package cn.lhj.csp.config.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

//import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigCategory;
import cn.lhj.csp.config.service.ConfigCategoryService;
import cn.lhj.csp.config.service.ConfigService;
import cn.lhj.csp.fileinfo.service.impl.RedisTemplateServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin
public class ConfigAPI {
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private RedisTemplateServiceImpl redisTemplateServiceImpl;
	
	@Autowired
	private ConfigCategoryService configCategoryService;

	@RequestMapping("/api/config/getConfigById")
	public Config getConfigById(Integer id) {
		return configService.findById(id);
	}
	
	@RequestMapping("/api/config/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestParam(value = "configJSON") String getConfig, @RequestParam(value="id",required = false, defaultValue = "0") int id) throws Exception {
		Config config=JSON.parseObject(getConfig, Config.class);
		if (operation.equals("delete")) {
			configService.delete(id);
		} else if (operation.equals("insert")) {
			configService.insert(config);
		} else if (operation.equals("update")) {
			configService.update(config);
		}
		return ;
	}
	
	@RequestMapping("/api/config/insert")
	public String insertConfig(@RequestBody Config config) throws Exception {
		configService.insert(config);
		System.out.println("增加");
		return "增加成功";
	}
	
	@RequestMapping("/api/config/delete")
	public String deleteConfig(@RequestParam("id")Integer id) {
		configService.delete(id);
		return "删除成功";
	}
	
	@RequestMapping("/api/config/update")
	public String updateConfig(@RequestBody Config config) throws Exception {
		configService.update(config);
		System.out.println("修改");
		return "修改成功";
	}
	
	@RequestMapping("/api/config/selectByType")
	public List<Config> selectByType(@RequestParam("type")String type){
		return configService.selectByType(type);
	}
	
	@RequestMapping("/api/config/insertConfigOne")
	public int insertConfigOne(@RequestBody Config config)throws Exception{
		return configService.insert(config);
	}
	
	@RequestMapping("/api/configCategory/getAll")
	public List<ConfigCategory> getAllConfigCategory(){
		return configCategoryService.getAll();
	}
	
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
	public String deleteConfigCategory(@RequestParam("id") Integer id) {
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
	
	@RequestMapping("/api/config/getTengXunYunAll")
	public List<Config> getTengXunYunAll() {
		String config = redisTemplateServiceImpl.getValue("tengxunyun");
		if (config == null) {
			config = String.valueOf(JSONArray.fromObject(configService.selectByType("腾讯云配置")));
			redisTemplateServiceImpl.set("tengxunyun", config);
			return configService.selectByType("腾讯云配置");
		} else {
			return AnalysisJsonArray(config);
		}
	}
	
	@RequestMapping("/api/config/getSystemPicture")
	public Config getSystemPicture() {
		String config = redisTemplateServiceImpl.getValue("systempicture");
		if (config == null) {
			config = String.valueOf(JSONArray.fromObject(configService.findByConfigKey("系统图片")));
			redisTemplateServiceImpl.set("systempicture", config);
			return configService.findByConfigKey("系统图片");
		} else {
			return AnalysisOneJsonArray(config);
		}
	}
	
	/*
	 * 解析jsonArray字符串
	 */
	public List<Config> AnalysisJsonArray(String config) {
		JSONArray json = JSONArray.fromObject(config);
		List<Config> configs = new ArrayList<>();
		if (json.size() > 0) {
			for (int i = 0; i < json.size(); i++) {
				Config configObject = null;
				JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				configObject = new Config((Integer) job.get("id"), (String) job.get("configKey"),
						(String) job.get("configValue"), (String) job.get("dataType"), (String) job.get("type"),
						(String) job.get("enable"));
				configs.add(configObject);
			}
		}
		return configs;
	}
	
	/*
	 * 解析一条jsonArray数据
	 * 
	 */
	public Config AnalysisOneJsonArray(String config) {
		JSONArray json = JSONArray.fromObject(config);
		Config configObject = null;
		if (json.size() > 0) {
			JSONObject job = json.getJSONObject(0);// 遍历 jsonarray 数组，把每一个对象转成 json 对象
			configObject = new Config((Integer) job.get("id"), (String) job.get("configKey"),
					(String) job.get("configValue"), (String) job.get("dataType"), (String) job.get("type"),
					(String) job.get("enable"));
		}
		return configObject;
	}
}
