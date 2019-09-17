package cn.yzj.shop.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Config;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.ConfigService;

/*
 *yzj
 *2019
 *2019年9月16日
 */
@RestController
@RequestMapping("/api")
public class ConfigApi {
	@Autowired
	private ConfigService service;
	@RequestMapping("/getConfigs")
	public Serializable getConfigs(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit) throws Exception {
		return service.dataPage(limit, page);
	}
	@RequestMapping("/addConfig")
	public Msg addConfig(@Validated Config config) throws Exception {
		return service.add(config);
	}
	@RequestMapping("/deleteConfig")
	public Msg deleteConfig(@RequestParam("ids")String ids) throws Exception {
		return service.delete(ids);
	}
	@RequestMapping("/updataConfig")
	public Msg updataConfig(Config config) throws Exception{
		return service.updata(config);
	}
}
