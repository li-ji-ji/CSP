package cn.yzj.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yzj.shop.po.PickUp;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.service.PickUpService;
import cn.yzj.shop.service.Region2Service;

@Controller
@RequestMapping("/pickUp")
public class PickUpController {

	@Autowired
	private PickUpService pickUpService;

	@Autowired
	private Region2Service region2Service;

	@RequestMapping("/list")
	public String list(ModelMap map, @RequestParam(defaultValue = "0", required = false) Integer id) throws Exception {
		if (id > 0) {
			pickUpService.delete(id);
		}
		List<PickUp> pickUps = (List<PickUp>) pickUpService.find();
		for (int i = 0; i < pickUps.size(); i++) {
			String provinceName = ((Region2) region2Service.find(pickUps.get(i).getProvinceId())).getName();
			String cityName = ((Region2) region2Service.find(pickUps.get(i).getCityId())).getName();
			String districtName = ((Region2) region2Service.find(pickUps.get(i).getDistrictId())).getName();
			pickUps.get(i).setProvinceName(provinceName);
			pickUps.get(i).setCityName(cityName);
			pickUps.get(i).setDistrictName(districtName);
		}
		map.addAttribute("pickUps", pickUps);
		return "pickup/list";
	}

	@RequestMapping("/toedit")
	public String toedit(ModelMap map, @RequestParam("id") Integer id) throws Exception {
		PickUp pickUp = (PickUp) pickUpService.find(id);
		String provinceName = ((Region2) region2Service.find(pickUp.getProvinceId())).getName();
		String cityName = ((Region2) region2Service.find(pickUp.getCityId())).getName();
		String districtName = ((Region2) region2Service.find(pickUp.getDistrictId())).getName();
		List<Region2> region2s = region2Service.selectByPid(0);
		map.addAttribute("pickUp", pickUp);
		map.addAttribute("provinceName", provinceName);
		map.addAttribute("cityName", cityName);
		map.addAttribute("districtName", districtName);
		map.addAttribute("region2s", region2s);
		return "pickup/update";
	}

	@RequestMapping("/toinsert")
	public String toinsert(ModelMap map) {
		List<Region2> region2s = region2Service.selectByPid(0);
		map.addAttribute("region2s", region2s);
		return "pickup/insert";
	}

	@RequestMapping("/selectByName")
	public String selectRegion(ModelMap map, @RequestParam("name") String name) throws Exception {
		List<PickUp> pickUps = new ArrayList<PickUp>();
		try {
			PickUp pickUp = (PickUp) pickUpService.find(Integer.parseInt(name));
			
			pickUps.add(pickUp);
		} catch (Exception e) { // TODO: handle exception
			pickUps = pickUpService.selectByName(name);
		}
		if (name.equals("")) {
			pickUps = (List<PickUp>) pickUpService.find();
		}
		for (int i = 0; i < pickUps.size(); i++) {
			String provinceName = ((Region2) region2Service.find(pickUps.get(i).getProvinceId())).getName();
			String cityName = ((Region2) region2Service.find(pickUps.get(i).getCityId())).getName();
			String districtName = ((Region2) region2Service.find(pickUps.get(i).getDistrictId())).getName();
			pickUps.get(i).setProvinceName(provinceName);
			pickUps.get(i).setCityName(cityName);
			pickUps.get(i).setDistrictName(districtName);
		}
		map.addAttribute("pickUps", pickUps);
		System.out.println(pickUps);
		return "pickup/list";
	}
}
