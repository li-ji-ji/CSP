package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.Msg;

/**
 * 
 * @author jhj
 * @description 友情链接
 *
 */
public interface FriendLinkService extends ShopService {
	//批量删除友情链接
	public Msg batchDeleteFriendLink(List<Short> idList)throws Exception;
}
