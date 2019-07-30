package cn.lhj.csp.config.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
import cn.lhj.csp.config.po.Config;

@RestController
@RequestMapping("/api/config")
@CrossOrigin
public class ConfigFeignAPI {
	
	@Autowired
	private AdminMenuApiInterface configFeign;

	@RequestMapping("/getConfigById")
	public Config getConfigById(Integer id) {
		return configFeign.getConfigById(id);
	}
	
	@RequestMapping("/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestParam(value = "configJSON") String getConfig, @RequestParam(value="id",required = false, defaultValue = "0") int id) throws Exception {
		Config config=JSON.parseObject(getConfig, Config.class);
		System.out.println(operation);
		System.out.println(config.toString());
		System.out.println(id);
		if (operation.equals("delete")) {
			configFeign.delete(id);
		} else if (operation.equals("insert")) {
			configFeign.insertConfigOne(config);
		} else if (operation.equals("update")) {
			configFeign.updateConfigOne(config);
		}
		return ;
	}
	
	@RequestMapping("/insertConfigOne")
	public int insertConfigOne(@RequestBody Config config)throws Exception{
		System.out.println(config.getConfigValue());
		return configFeign.insertConfigOne(config);
	}
}
