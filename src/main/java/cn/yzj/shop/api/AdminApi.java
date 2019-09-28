package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.AdminWithBLOBs;
import cn.yzj.shop.po.LoginDTO;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.AdminService;
import cn.yzj.shop.util.WXPayUtil;

/*
 *yzj
 *2019
 *2019年9月20日
 */
@RestController
@RequestMapping("/api")
public class AdminApi {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/getAdminList")
	public Serializable getAdminList(@RequestParam(value ="limit",defaultValue ="20")int limit,@RequestParam(value ="page",defaultValue ="1")int page) throws Exception {
		return adminService.dataPage(limit, page);
	}
	@RequestMapping("/addAdmin")
	public Msg addAdmin(AdminWithBLOBs admin) throws Exception {
		return adminService.add((Serializable) admin);
		
	}
	@RequestMapping("/deleteAdmin")
	public Msg deleteAdmin(@RequestParam("ids")String ids) throws Exception {
		return adminService.delete(ids);	
	}
	@RequestMapping("/updataAdmin")
	public Msg updataAdmin(@Validated AdminWithBLOBs admin) throws Exception {
		return adminService.updata(admin);	
	}
	@RequestMapping("/verification")
	public Msg verification(@Validated LoginDTO loginDTO,HttpServletResponse response) throws Exception{
		Msg msg=adminService.adminLogin(loginDTO,response);
		return msg; 
	}
	@RequestMapping("/logout")
	public Msg logout(HttpServletRequest request)throws Exception{
		Msg msg=adminService.logout(request);
		return msg;
	}
}
