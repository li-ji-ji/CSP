package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Navigation;
import cn.yzj.shop.service.NavigationService;

@RestController
@RequestMapping("/api")
public class NavigationApi {

	@Autowired
	private NavigationService navigationService;
	
	//获取所有导航
	@RequestMapping("/getAllNavigation")
	public Serializable getAllNavigation() {
		
		return navigationService.find();
	}
	
	//根据导航ID查询一条导航信息
	@RequestMapping("/getNavigationById")
	public Serializable getNavigationById(@RequestParam("id") Integer id) {
		return navigationService.find(id);
	}
	
	//根据实体修改一条导航信息
	@RequestMapping("/updateNavigation")
	public Msg updateNavigation(Navigation navigation) {
		return navigationService.updata(navigation);
	}
	
	//根据实体添加一条导航
	@RequestMapping("/addNavigation")
	public Msg addNavigation(Navigation navigation) {
		return navigationService.add(navigation);
	}
	
	//根据导航ID删除一条导航
	@RequestMapping("/deleteNavigation")
	public Msg deleteNavigation(@RequestParam("id") Integer id) {
		return navigationService.delete(id);
	}
	
	//批量删除导航
	@RequestMapping("/batchDeleteNavigation")
	public Msg batchDeleteNavigation(@RequestParam("idList") List<Integer> idList) throws Exception {
		return navigationService.batchDeleteNavigation(idList);
	}
}
