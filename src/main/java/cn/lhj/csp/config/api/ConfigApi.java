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
import cn.lhj.csp.config.service.impl.ConfigServiceImpl;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/config")
@CrossOrigin
public class ConfigApi {

	@Autowired
	private ConfigServiceImpl configServiceImpl;

	@ApiOperation(value = "获取配置详细信息")
	@RequestMapping("/getAllConfig")
	public List<Config> getAllConfig() {
		return configServiceImpl.selectAll();
	}

	@ApiOperation(value = "获取layui所有配置详细信息")
	@RequestMapping("/layuigetAll")
	public Map<String, Object> layuigetAll(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "100") int limit) {
		List<Config> data = configServiceImpl.select(page, limit);
		List<Config> datas = configServiceImpl.selectAll();
		int count = datas.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", data);
		return map;
	}

	@ApiOperation(value = "获取配置详细信息", notes = "根据url的id来获取配置详细信息")
	@RequestMapping("/getConfigById")
	public Config getConfigById(Integer id) {
		return configServiceImpl.findById(id);
	}

	@ApiOperation(value = "增加配置详细信息", notes = "增加配置详细信息")
	@RequestMapping("/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestBody Config config, @RequestParam(value="id",required = false, defaultValue = "0") int id) {
		System.out.println(operation);
		System.out.println(config.getId());
		System.out.println(id);
		if (operation.equals("delete")) {
			configServiceImpl.delete(id);
		} else if (operation.equals("insert")) {
			configServiceImpl.insert(config);
		} else if (operation.equals("update")) {
			configServiceImpl.update(config);
		}
	}
	
	@RequestMapping("/updateEnableById")
	public void updateEnableById(Integer id, String enable) {
		configServiceImpl.updateEnableById(id, enable);
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam("id")Integer id) {
		configServiceImpl.delete(id);
	}
	
	@RequestMapping("/selectByType")
	public List<Config> selectByType(String type){
		return configServiceImpl.selectByType(type);
	}
	
	@RequestMapping("/insertConfigOne")
	public int insertConfigOne(@RequestBody Config config )throws Exception{
		try {
			configServiceImpl.insert(config);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("/updateConfigOne")
	public int updateConfigOne(@RequestBody Config config )throws Exception{
		try {
			configServiceImpl.update(config);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
