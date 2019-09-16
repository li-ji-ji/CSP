package cn.yzj.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yzj.shop.po.FriendLink;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.FriendLinkService;


@Controller
@RequestMapping("/friendlink")
public class FriendLinkController {
	@Autowired
	private FriendLinkService friendLinkService;
	
	//跳到友情链接列表
	@RequestMapping("/toFriendLinkList")
	public String toFriendLinkList(ModelMap modelmap) throws Exception {
		
		List<FriendLink> friendLinks = (List<FriendLink>) friendLinkService.find();
		modelmap.addAttribute("friendLinks", friendLinks);
		
		return "friendlink/friendlinklist";
	}
	
	//跳到友情链接编辑
	@RequestMapping("/toFriendLinkEdit")
	public String toFriendLinkEdit(ModelMap modelmap,@RequestParam("linkId") Short linkId) throws Exception{
		//根据linkId查询一条友情链接
		FriendLink friendLink = (FriendLink) friendLinkService.find(linkId);
		modelmap.addAttribute("friendLink",friendLink);
		return "friendlink/friendlinkedit";
	}
	
	//友情链接修改
	@RequestMapping("/updateFriendLink")
	public String updateFriendLink(FriendLink friendLink) throws Exception{
		
		if(friendLink.getIsShow()==null) {
			friendLink.setIsShow(false);
		}
		else {
			friendLink.setIsShow(true);
		}
		
		if(friendLink.getTarget()==null) {
			friendLink.setTarget(false);
		}
		else {
			friendLink.setTarget(true);
		}
		
		Msg msg = friendLinkService.updata(friendLink);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toFriendLinkList";
	}
	
	//跳到友情链接添加
	@RequestMapping("/toFriendLinkAdd")
	public String toFriendLinkAdd(ModelMap modelmap) {
		
		return "friendlink/friendlinkadd";
	}
	
	//友情链接添加
	@RequestMapping("/addFriendLink")
	public String addFriendLink(FriendLink friendLink) throws Exception{
		
		if(friendLink.getIsShow()==null) {
			friendLink.setIsShow(false);
		}
		else {
			friendLink.setIsShow(true);
		}
		
		if(friendLink.getTarget()==null) {
			friendLink.setTarget(false);
		}
		else {
			friendLink.setTarget(true);
		}
		
		Msg msg = friendLinkService.add(friendLink);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toFriendLinkList";
	}
	
	//根据linkID删除一条友情链接
	@RequestMapping("/deleteFriendLink")
	public String deleteFriendLink(@RequestParam("linkId") Short linkId) throws Exception{
		Msg msg = friendLinkService.delete(linkId);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		return "redirect:toFriendLinkList";
	}
	
	
}
