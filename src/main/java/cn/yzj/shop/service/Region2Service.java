package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.Region2;

/**
 * 地区
 * @author syf
 *
 */
public interface Region2Service extends ShopService{
		
		public List<Region2> selectByPid(Integer pid);
}
