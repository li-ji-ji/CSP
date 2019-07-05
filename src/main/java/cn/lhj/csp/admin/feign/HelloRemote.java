package cn.lhj.csp.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="csp-admin1")
public interface HelloRemote {
	@RequestMapping(value="/hello")
	public String Hello(@RequestParam(value="name")String name);
}
