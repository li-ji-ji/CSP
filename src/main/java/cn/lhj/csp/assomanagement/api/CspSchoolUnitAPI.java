package cn.lhj.csp.assomanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.po.CspAssoSchoolUnit;
import cn.lhj.csp.assomanagement.service.CspAssoSchoolUnitService;

@RestController
@CrossOrigin
public class CspSchoolUnitAPI {

	@Autowired
	private CspAssoSchoolUnitService cspSchoolUnitService;
	
	//查询所有学校单位
	@RequestMapping("/getUnitAll")
	public List<CspAssoSchoolUnit> getUnitAll()throws Exception{
		return cspSchoolUnitService.getUnitAll();
	}
	
	//根据ID查询学校单位
	@RequestMapping("/getUnitById")
	public CspAssoSchoolUnit getUnitById(@RequestParam("id")Integer id) throws Exception{
		return cspSchoolUnitService.getUnitById(id);
	}

	//根据单位编号查询学校单位
	@RequestMapping("/getUnitByNo")
	public CspAssoSchoolUnit getUnitByNo(@RequestParam("no")String no) throws Exception{
		return cspSchoolUnitService.getUnitByNo(no);
	}

	//根据上级单位查询学校单位
	@RequestMapping("/getUnitByPNo")
	public List<CspAssoSchoolUnit> getUnitByPNo(@RequestParam("pno")String pno) throws Exception{
		return cspSchoolUnitService.getUnitByPNo(pno);
	}
	
	//删除单个学校部门
	@RequestMapping("/deleteUnitOne")
	public int deleteUnitOne(@RequestParam("id") Integer id)throws Exception{
		return cspSchoolUnitService.deleteUnitOne(id);
	}
	
	//添加单个学校部门
	@RequestMapping("/insertUnitOne")
	public int insertUnitOne(@RequestBody CspAssoSchoolUnit unit)throws Exception{
		System.out.println(unit.getpUnitNo());
		return cspSchoolUnitService.insertUnitOne(unit);
	}
}
