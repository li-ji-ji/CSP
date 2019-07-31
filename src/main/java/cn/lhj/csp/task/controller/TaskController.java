package cn.lhj.csp.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

	@RequestMapping("/taskAdmin")
	public ModelAndView taskAdmin(ModelAndView modelAndView) {
		
		modelAndView.setViewName("ftl/task/taskAdmin");
		return modelAndView;
	}
	@RequestMapping("/taskTypeAdmin")
	public ModelAndView taskTypeAdmin(ModelAndView modelAndView) {
		
		modelAndView.setViewName("ftl/task/taskType");
		return modelAndView;
	}
}
