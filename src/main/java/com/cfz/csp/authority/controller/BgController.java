package com.cfz.csp.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 测试的controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/bg/managemant")
public class BgController {
	@RequestMapping("/index")
	public String index() {
		return "bgmanagemant/bg";
	}
}
