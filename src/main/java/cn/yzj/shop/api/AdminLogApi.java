package cn.yzj.shop.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.AdminLogService;

/*
 *yzj
 *2019
 *2019年9月21日
 */
@RestController
@RequestMapping("/api")
public class AdminLogApi {
	@Autowired
	private AdminLogService adminLogService;
	
	@RequestMapping("/getAdminLogs")
	public Serializable getAdminLogs(@RequestParam(value ="limit",defaultValue ="20")int limit,@RequestParam(value ="page",defaultValue ="1")int page) throws Exception {
		return adminLogService.dataPage(limit, page);
	}
	@RequestMapping("/deleteAdminlogs")
	public Msg deleteAdminlogs(@RequestParam("ids")String ids) throws Exception {
		return adminLogService.delete(ids);
	}
	/*
	 *yzj
	 *2019
	 *2019年9月21日
	 */
}
