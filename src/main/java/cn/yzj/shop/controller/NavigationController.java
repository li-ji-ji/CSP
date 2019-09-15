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
	public String toNavList(ModelMap modelmap,@RequestParam(value = "position", required = false) String position) throws Exception {	
		if (position != null && position.equals("top")) {//获取所有顶部导航
			List<Navigation> navigations = navigationService.findNavByPosition(position);
			modelmap.addAttribute("navigations", navigations);
		}
		
		else if(position != null && position.equals("bottom")) {//获取所有底部导航
			List<Navigation> navigations = navigationService.findNavByPosition(position);
			modelmap.addAttribute("navigations", navigations);
		}
		
		else {//获取所有导航
			List<Navigation> navigations = (List<Navigation>) navigationService.find();
			modelmap.addAttribute("navigations", navigations);
		}
		return "navigation/navigationlist";
		
	}
	
	//跳到导航编辑
	@RequestMapping("/toNavEdit")
	public String toNavEdit(ModelMap modelmap,@RequestParam("id") Integer id) throws Exception {
		//根据导航ID查询一条导航信息
		Navigation navigation = (Navigation) navigationService.find(id);
		modelmap.addAttribute("navigation",navigation);
		return "navigation/navigationedit";
	}
	
	//导航修改
	@RequestMapping("/updateNavigation")
	public String updateNavigation(Navigation navigation) throws Exception {
		
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
	public String toNavAdd(ModelMap modelmap) {
		
		return "navigation/navigationadd";
	}
	
	//导航添加
	@RequestMapping("/addNavigation")
	public String addNavigation(Navigation navigation) throws Exception {
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
		
		Msg msg = navigationService.add(navigation);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toNavList";
	}
	
	//根据导航ID删除一条导航
	@RequestMapping("/deleteNavigation")
	public String deleteNavigation(@RequestParam("id") Integer id) throws Exception {
		Msg msg = navigationService.delete(id);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		return "redirect:toNavList";
	}
}
