package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.EmailTemplate;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.implement.SystemsModuleImp;
import cn.yzj.shop.util.EmailUtil;
/*
 * 
 *yzj
 *2019
 *2019年9月12日
 */
@RestController
@RequestMapping("/api")
public class AdminApi {
	@Autowired
	private SystemsModuleImp systemsModule;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired EmailUtil emailUtil;
	/**
	 * 数据表分页查询
	 */
	@RequestMapping("/getSystemModuleByPid")
	public Object getSystemModuleAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "pid", defaultValue = "0") short pid) throws Exception {
		return systemsModule.dataPage(limit, page, pid);
	}

	/**
	 * 添加菜单
	 * 
	 * @param systemModule
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSystemModule")
	public Msg addSystemModule(SystemModule module) throws Exception {
		return systemsModule.add(module);
	}
	/**
	 *   获取下拉树模型有url
	* @return
	* @throws Exception
	*/
	@RequestMapping("/getSelectTree")
	public List<SelectTreeDTO> getSelectTree() throws Exception {
		return systemsModule.getSelectTree();
	}
	/**
	 *   获取下拉树模型没有url
	* @return
	* @throws Exception
	*/
	@RequestMapping("/getSelectTreeNo")
	public List<SelectTreeDTO> getSelectTreeNo() throws Exception {
		return systemsModule.getSelectTreeNo();
	}
	/**
	 * 删除菜单
	 * param String
	 * return msg
	 * @throws Exception 
	 */
	@RequestMapping("/deleteMenu")
	public Msg deleteMenu(@RequestParam("ids")String ids) throws Exception {
		return systemsModule.delete(ids);
	}
	@RequestMapping("/updataMenu")
	public Msg updataMenu(SystemModule systemModules) throws Exception {
		return systemsModule.updata(systemModules);
	}
	@RequestMapping("/test")
	public String test() throws Exception{
		int i=1/0;
		return null;
	}
    @RequestMapping("/getUser")
    public Serializable getUser() throws Exception {
        return systemsModule.find();
    }
	
}
