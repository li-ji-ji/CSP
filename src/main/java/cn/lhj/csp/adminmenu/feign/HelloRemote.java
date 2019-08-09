package cn.lhj.csp.adminmenu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="csp-admin")
public interface HelloRemote {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String Hello(@RequestParam(value="name")String name);
}
