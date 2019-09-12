package cn.yzj.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Navigation;
import cn.yzj.shop.service.NavigationService;

@Controller
@RequestMapping("/navigation")
public class NavigationController {
	@Autowired
	private NavigationService navigationService;
	
	//跳到导航列表
	@RequestMapping("/toNavList")
	public String toNavList(ModelMap modelmap) {
		List<Navigation> navigations = (List<Navigation>) navigationService.find();
		modelmap.addAttribute("navigations", navigations);
		return "navigation/navigationlist";
	}
	
	//跳到导航编辑
	@RequestMapping("/toNavEdit")
	public String toNavEdit(ModelMap modelmap,@RequestParam("id") Integer id) {
		//根据导航ID查询一条导航信息
		Navigation navigation = (Navigation) navigationService.find(id);
		modelmap.addAttribute("navigation",navigation);
		return "navigation/navigationedit";
	}
	
	//导航修改
	@RequestMapping("/updateNavigation")
	public String updateNavigation(Navigation navigation) {
		
		if(navigation.getIsShow()==null) {
			navigation.setIsShow(false);
		}
		else {
			navigation.setIsShow(true);
		}
		
		if(navigation.getIsNew()==null) {
			navigation.setIsNew(false);
		}
		else {
			navigation.setIsNew(true);
		}
		
		Msg msg = navigationService.updata(navigation);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toNavList";
	}
	
	
	//跳到导航添加
	@RequestMapping("/toNavAdd")
	public String addNavigation(ModelMap modelmap) {
		
		return "navigation/navigationadd";
	}

}
