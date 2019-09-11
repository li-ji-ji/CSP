package cn.yzj.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yzj.shop.po.Region2;
import cn.yzj.shop.service.Region2Service;

@Controller
@RequestMapping("/region2")
public class Region2Controller {
		
		@Autowired
		private Region2Service region2Service;
		
		@RequestMapping("/list")
		public String list(ModelMap map) {
			List<Region2> region2s = (List<Region2>)region2Service.find(0);
			map.addAttribute("region2s", region2s);
			return "region2/list";
		}
}
