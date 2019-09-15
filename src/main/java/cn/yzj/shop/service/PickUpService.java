package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.PickUp;

public interface PickUpService extends ShopService{
		
		public List<PickUp> selectByName(String name);
}
