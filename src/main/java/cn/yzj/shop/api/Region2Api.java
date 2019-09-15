package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Region;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.service.Region2Service;

@RestController
public class Region2Api {

	@Autowired
	private Region2Service region2Service;

	@RequestMapping("/api/region2/getAll")
	public Serializable getAll() throws Exception {
		return region2Service.find();
	}

	@RequestMapping("/api/region2/insert")
	public Msg insert(@RequestBody Region2 region2) throws Exception {
		return region2Service.add((Serializable) region2);
	}

	@RequestMapping("/api/region2/delete")
	public Msg delete(@RequestParam("id") Integer id) throws Exception {
		return region2Service.delete(id);
	}

	@RequestMapping("/api/region2/update")
	public Msg update(@RequestBody Region2 region2) throws Exception {
		return region2Service.updata((Serializable) region2);
	}

	@RequestMapping("/api/region2/findById")
	public Region2 findByPid(@RequestParam("id") Integer id) throws Exception {
		return (Region2)region2Service.find(id);
	}
	
	@RequestMapping("/api/region2/subregion")
	public List<Region2> subregion(@RequestParam("id")Integer id){
		List<Region2> region2s = region2Service.selectByPid(id);
		return region2s;
	}
}
