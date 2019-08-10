package com.cfz.csp.authority.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cfz.csp.authority.service.StudentService;

@RestController
@RequestMapping("/static")
public class HelloController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return "hello "+ name +",this is first messge";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println(studentService.findByName("admin"));
		return "test";
	}
}
