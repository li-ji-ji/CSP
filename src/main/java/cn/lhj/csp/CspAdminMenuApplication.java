package cn.lhj.csp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan(basePackages = {"cn.lhj.csp.adminmenu.mapper","cn.lhj.csp.config.mapper","cn.lhj.csp.region.mapper"})
public class CspAdminMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(CspAdminMenuApplication.class, args);
	}

}
