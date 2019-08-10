package com.cfz.csp.authority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.cfz.csp.authority.mapper")
@EnableDiscoveryClient
public class CampusEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusEurekaClientApplication.class, args);
	}
}
