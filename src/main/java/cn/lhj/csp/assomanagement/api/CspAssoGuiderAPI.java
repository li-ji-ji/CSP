package cn.lhj.csp.assomanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.po.CspAssoGuider;
import cn.lhj.csp.assomanagement.service.CspAssoGuiderService;

@RestController
@CrossOrigin
public class CspAssoGuiderAPI {

	@Autowired
	private CspAssoGuiderService cspAssoGuiderService;

	//查询所有指导老师
	@RequestMapping("/getGuiderAll")
	public List<CspAssoGuider> getGuiderAll() throws Exception{
		return cspAssoGuiderService.getAll();
	}

	//根据ID查询指导老师
	@RequestMapping("/getGuiderById")
	public CspAssoGuider getGuiderById(@RequestParam("id")Integer id) throws Exception{
		return cspAssoGuiderService.getById(id);
	}
	
	//根据工号查询指导老师
	@RequestMapping("/getGuiderByTid")
	public CspAssoGuider getGuiderByTid(@RequestParam("tId")String tId) throws Exception{
		return cspAssoGuiderService.getByTid(tId);
	}

	//根据姓名查询指导老师
	@RequestMapping("/getGuiderByName")
	public List<CspAssoGuider> getGuiderByName(@RequestParam("tName")String tName) throws Exception{
		return cspAssoGuiderService.getByName(tName);
	}

	//增加指导老师
	@RequestMapping("/insertGuiderOne")
	public int insertGuiderOne(@RequestBody CspAssoGuider guider) throws Exception{
		return cspAssoGuiderService.insertOne(guider);
	}

	//根据ID删除指导老师
	@RequestMapping("/deleteGuiderOneById")
	public int deleteGuiderOneById(@RequestParam("id")Integer id) throws Exception{
		return cspAssoGuiderService.deleteOneById(id);
	}

	//根据工号删除指导老师
	@RequestMapping("/deleteGuiderOneByTid")
	public int deleteOneByTid(@RequestParam("tId")String tId) throws Exception{
		return cspAssoGuiderService.deleteOneByTid(tId);
	}
	
	//批量删除指导老师
	@RequestMapping("/deleteGuiderListById")
	public int deleteGuiderListById(@RequestParam("idList")List<Integer> idList) throws Exception{
		return cspAssoGuiderService.deleteListById(idList);
	}

	//更新指导老师信息
	@RequestMapping("/updateGuiderOne")
	public int updateGuiderOne(CspAssoGuider guider) throws Exception{
		return cspAssoGuiderService.updateOne(guider);
	}
}
