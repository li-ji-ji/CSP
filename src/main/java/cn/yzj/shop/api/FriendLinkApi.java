package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.FriendLink;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.FriendLinkService;


@RestController
@RequestMapping("/api")
public class FriendLinkApi {
	@Autowired
	private FriendLinkService friendLinkService;
	
	//获取所有友情链接,按排序升序
	@RequestMapping("/getAllFriendLink")
	public Serializable getAllFriendLink() throws Exception{
		
		return friendLinkService.find();
	}
	
	//根据实体修改一条友情链接信息
	@RequestMapping("/updateFriendLink")
	public Msg updateFriendLink(FriendLink friendLink) throws Exception{
		return friendLinkService.updata(friendLink);
	}

	//根据linkId查询一条友情链接
	@RequestMapping("/getFriendLinkById")
	public Serializable getFriendLinkById(@RequestParam("linkId") Short linkId) throws Exception {
		return friendLinkService.find(linkId);
	}
	
	//根据实体添加一条友情链接
	@RequestMapping("/addFriendLink")
	public Msg addFriendLink(FriendLink friendLink) throws Exception {
		return friendLinkService.add(friendLink);
	}
	
	//根据linkID删除一条友情链接
	@RequestMapping("/deleteFriendLink")
	public Msg deleteFriendLink(@RequestParam("linkId") Short linkId) throws Exception {
		return friendLinkService.delete(linkId);
	}
	
	//批量删除友情链接
	@RequestMapping("/batchDeleteFriendLink")
	public Msg batchDeleteFriendLink(@RequestParam("idList") List<Short> idList) throws Exception {
		return friendLinkService.batchDeleteFriendLink(idList);
	}
}
