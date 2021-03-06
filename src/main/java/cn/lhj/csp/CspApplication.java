package cn.lhj.csp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient //启用服务注册与发现
//@EnableFeignClients //启用feign进行远程调用
@MapperScan(basePackages = {"cn.lhj.csp.admin.mapper","cn.lhj.csp.**.mapper","cn.yzj.csp.task.mapper","cn.lhj.csp.authority.mapper"})
public class CspApplication {

	public static void main(String[] args) {
		SpringApplication.run(CspApplication.class, args);
	}

}
