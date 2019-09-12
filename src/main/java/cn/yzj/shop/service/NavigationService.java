package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.Msg;

/**
 * 
 * @author jhj
 * @description 导航
 *
 */
public interface NavigationService extends ShopService {
	//批量删除导航
	public Msg batchDeleteNavigation(List<Integer> idList)throws Exception;
}
