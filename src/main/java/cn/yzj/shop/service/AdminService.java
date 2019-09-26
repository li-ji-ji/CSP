package cn.yzj.shop.service;

import java.io.Serializable;

import cn.yzj.shop.po.AdminDTO;
import cn.yzj.shop.po.LoginDTO;
import cn.yzj.shop.po.Msg;

/*
 *yzj
 *2019
 *2019年9月20日
 */
public interface AdminService extends ShopService<Serializable, Serializable> {
	public Msg adminLogin(LoginDTO loginDTO)throws Exception;
	
}
