package cn.lhj.csp.assomanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.po.CspAssoSchool;
import cn.lhj.csp.assomanagement.service.CspAssoSchoolService;

@RestController
@CrossOrigin
public class CspAssoSchoolAPI {

	@Autowired
	private CspAssoSchoolService cspAssoSchoolService;
	
	//查询所有学校
	@RequestMapping("/getAssoSchoolAll")
	public List<CspAssoSchool> getAssoSchoolAll() throws Exception{
		return cspAssoSchoolService.getAssoSchoolAll();
	}
	
	//根据ID查询学校
	@RequestMapping("/getAssoSchoolById")
	public CspAssoSchool getAssoSchoolById(@RequestParam("id")Integer id) throws Exception{
		return cspAssoSchoolService.getAssoSchoolById(id);
	}

	//根据学校编号查询学校
	@RequestMapping("/getAssoSchoolBySNo")
	public CspAssoSchool getAssoSchoolBySNo(@RequestParam("sno")String sno) throws Exception{
		return cspAssoSchoolService.getAssoSchoolBySNo(sno);
	}

	//根据省份编号查询学校
	@RequestMapping("/getAssoSchoolByProId")
	public List<CspAssoSchool> getAssoSchoolByProId(@RequestParam("proId")Integer proId) throws Exception{
		return cspAssoSchoolService.getAssoSchoolByProId(proId);
	}

	//根据城市编号查询学校
	@RequestMapping("/getAssoSchoolByCityId")
	public List<CspAssoSchool> getAssoSchoolByCityId(@RequestParam("cityId")Integer cityId) throws Exception{
		return cspAssoSchoolService.getAssoSchoolByCityId(cityId);
	}

	//根据学校名称查询学校
	@RequestMapping("/getAssoSchoolByName")
	public List<CspAssoSchool> getAssoSchoolByName(@RequestParam("name")String name) throws Exception{
		return cspAssoSchoolService.getAssoSchoolByName(name);
	}

	//增加一个学校
	@RequestMapping("/insertAssoSchoolOne")
	public int insertAssoSchoolOne(@RequestBody CspAssoSchool school) throws Exception{
		return cspAssoSchoolService.insertOne(school);
	}

	//根据ID删除一个学校
	@RequestMapping("/deleteAssoSchoolOneById")
	public int deleteAssoSchoolOneById(@RequestParam("id")Integer id) throws Exception{
		return cspAssoSchoolService.deleteOneById(id);
	}

	//根据ID批量删除学校
	@RequestMapping("/deleteAssoSchoolListById")
	public int deleteAssoSchoolListById(@RequestParam("idList")List<Integer> idList) throws Exception{
		return cspAssoSchoolService.deleteListById(idList);
	}

	//根据学校编号删除一个学校
	@RequestMapping("/deleteAssoSchoolOneByNo")
	public int deleteAssoSchoolOneByNo(@RequestParam("no")String no) throws Exception{
		return cspAssoSchoolService.deleteOneByNo(no);
	}

	//根据学校编号批量删除学校
	@RequestMapping("/deleteAssoSchoolListByNo")
	public int deleteAssoSchoolListByNo(@RequestParam("noList")List<String> noList) throws Exception{
		return cspAssoSchoolService.deleteListByNo(noList);
	}
	
	//更新单个学校信息
	@RequestMapping("/updateAssoSchoolOne")
	public int updateAssoSchoolOne(@RequestBody CspAssoSchool school) throws Exception{
		System.out.println(school.getSchoolName());
		return cspAssoSchoolService.updateOne(school);
	}
}
