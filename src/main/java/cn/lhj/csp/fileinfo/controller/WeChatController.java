package cn.lhj.csp.fileinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wechat")
public class WeChatController {

	@RequestMapping("/upload")
	public String upload() {
		return "ftl/wxupload/upload";
	}
	
	@RequestMapping("/printupload")
	public String printupload() {
		return "ftl/wxupload/printupload";
	}

}
