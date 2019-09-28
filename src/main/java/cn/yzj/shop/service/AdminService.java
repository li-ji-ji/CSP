package cn.yzj.shop.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yzj.shop.po.LoginDTO;
import cn.yzj.shop.po.Msg;

/*
 *yzj
 *2019
 *2019年9月20日
 */
public interface AdminService extends ShopService<Serializable, Serializable> {
	public Msg adminLogin(LoginDTO loginDTO,HttpServletResponse response)throws Exception;//用户登入
	
	public Msg logout(HttpServletRequest request)throws Exception;//用户退出
	
	
	
}
