package cn.lhj.csp.adminmenu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.adminmenu.feign.HelloRemote;
import cn.lhj.csp.adminmenu.po.CspBackgroundMenu;
import cn.lhj.csp.adminmenu.service.CspBackgroundMenuService;

@RestController
//@RequestMapping("/csp/api/adminmenu")
//@CrossOrigin
public class CspBackgroundMenuAPI {

	@Autowired
	private CspBackgroundMenuService cspBackgroundMenuService;
	@Autowired
	private HelloRemote helloRemote;
	
	
	//获取所有后台菜单以JSON格式返回
	@RequestMapping("/getAll")
	public String getAll()throws Exception{
		//cspBackgroundMenuService.getAll()
		System.out.println("进入服务1");
		return "s";
	}
	@RequestMapping(value="/hello")
    public String index(@PathVariable("name") String name){
		System.out.println("进入服务");
        return helloRemote.Hello(name);
    }
}
