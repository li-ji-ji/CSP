package cn.yzj.shop.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.service.Region2Service;

@Controller
@RequestMapping("/region2")
public class Region2Controller {

	@Autowired
	private Region2Service region2Service;

	@RequestMapping("/list")
	public String list(ModelMap map, @RequestParam(required = false, defaultValue = "0") Integer id) {
		if (id > 0) {
			region2Service.delete(id);
		}
		List<Region2> region2s =  region2Service.selectByPid(0);
		map.addAttribute("region2s", region2s);
		return "region2/list";
	}

	@RequestMapping("/toinsert")
	public String toinsert() {
		return "region2/insert";
	}

	@RequestMapping("/toedit")
	public String toedit(ModelMap map, @RequestParam("id") Integer id) {
		List<Region2> region2 = (List<Region2>) region2Service.find(id);
		map.addAttribute("region2", region2);
		return "region2/update";
	}
	
	@RequestMapping("/subregion")
	public String subregion(ModelMap map,@RequestParam("id") Integer id) {
		List<Region2> region2s = region2Service.selectByPid(id);
		map.addAttribute("region2s", region2s);
		return "region2/list";
	}

}
