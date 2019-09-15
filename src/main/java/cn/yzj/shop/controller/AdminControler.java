package cn.yzj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.SystemsModule;
import cn.yzj.shop.util.WXPayUtil;
/*
 * 
 *yzj
 *2019
 *2019年9月15日
 */
@Controller
@RequestMapping("/admin")
public class AdminControler {
	
	@Autowired
	private SystemsModule systemsModule;
	
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("index");
		modelAndView.addObject("model",systemsModule.getSelectTree());
		return modelAndView;
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome(ModelAndView modelAndView)throws Exception{
		modelAndView.setViewName("welcome");
		modelAndView.addObject("time",WXPayUtil.getNewTime());
		return modelAndView;
	}

}
