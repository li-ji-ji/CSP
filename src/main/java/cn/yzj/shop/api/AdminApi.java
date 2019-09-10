package cn.yzj.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.SystemsModule;

@RestController
@RequestMapping("/api")
public class AdminApi {
	@Autowired
	private SystemsModule systemsModule;
	@RequestMapping("/getSystemModuleByPid")
	public LayUIJSON<Object> getSystemModuleAll(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit,@RequestParam(value="pid",defaultValue = "0")short pid) throws Exception{
		PageHelper.startPage(page,limit);
		List<SystemModule> modules=(List<SystemModule>) systemsModule.find(pid);
		PageInfo<SystemModule> pageInfo=new PageInfo<SystemModule>(modules);
		long count=pageInfo.getTotal();
		LayUIJSON<Object> uijson=new LayUIJSON<>();
		uijson.setCount(count);
		uijson.setData(modules);
		return uijson;
	}
	@RequestMapping("/addSystemModule")
	public boolean addSystemModule(SystemModule module) throws Exception {
		return systemsModule.addSystemModule(module);
	}
}
