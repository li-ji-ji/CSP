package cn.lhj.csp.asso.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.asso.po.CspAssoStudent;
import cn.lhj.csp.asso.service.CspAssoStudentService;


@RestController
@CrossOrigin
@RequestMapping("/AssoStudent")
public class CspAssoStudentAPI {

	@Autowired
	private CspAssoStudentService cspAssoStudentService;
	
	//获取所有学生列表
	@RequestMapping("/getStuAll")
	public List<CspAssoStudent> getStuAll() throws Exception{
		return cspAssoStudentService.getAll();
	}
	
	//根据ID查询单个学生信息
	@RequestMapping("/getStuById")
	public CspAssoStudent getStuById(@RequestParam("id")Integer id)throws Exception{
		return cspAssoStudentService.getById(id);
	}
	
	//根据学生学号查询单个学生信息
	@RequestMapping("/getStuBySId")
	public CspAssoStudent getStuBySId(@RequestParam("sid")String sid)throws Exception{
		return cspAssoStudentService.getBySId(sid);
	}
	
	//根据学生姓名查询学生列表
	@RequestMapping("/getStuListByName")
	public List<CspAssoStudent> getStuListByName(@RequestParam("name")String name)throws Exception{
		return cspAssoStudentService.getListByName(name);
	}

	//根据学生年段查询学生列表
	@RequestMapping("/getStuListByGrade")
	public List<CspAssoStudent> getStuListByGrade(@RequestParam("grade")Integer grade) throws Exception{
		return cspAssoStudentService.getListByGrade(grade);
	}
	
	//根据学生专业班级查询学生列表
	@RequestMapping("/getStuListByMajor")
	public List<CspAssoStudent> getStuListByMajor(@RequestParam("major")String major) throws Exception{
		return cspAssoStudentService.getListByMajor(major);
	}

	//根据学生性别查询学生列表
	@RequestMapping("/getStuListBySex")
	public List<CspAssoStudent> getStuListBySex(@RequestParam("sex")int sex) throws Exception{
		return cspAssoStudentService.getListBySex(sex);
	}

	//根据学生当前参与活动ID获取学生列表
	@RequestMapping("/getStuListByActId")
	public List<CspAssoStudent> getStuListByActId(@RequestParam("actId")String actId) throws Exception{
		return cspAssoStudentService.getListByActId(actId);
	}
	
	//根据学生当前参与活动名称获取学生列表
	@RequestMapping("/getStuListByActName")
	public List<CspAssoStudent> getStuListByActName(@RequestParam("actName")String actName) throws Exception{
		return cspAssoStudentService.getListByActName(actName);
	}

	//插入一条新的学生信息
	@RequestMapping("/insertStuOne")
	public int insertStuOne(@RequestBody CspAssoStudent student) throws Exception{
		return cspAssoStudentService.insertOne(student);
	}

	//根据ID删除一条学生信息
	@RequestMapping("/deleteStuOneById")
	public int deleteStuOneById(@RequestParam("id")Integer id) throws Exception{
		return cspAssoStudentService.deleteOneById(id);
	}
	
	//根据ID删除多条学生信息
	@RequestMapping("/deleteStuListById")
	public int deleteStuListById(@RequestParam("idList")List<Integer> idList) throws Exception{
		return cspAssoStudentService.deleteListById(idList);
	}

	//根据学生学号删除单条学生信息
	@RequestMapping("/deleteStuOneBySId")
	public int deleteStuOneBySId(@RequestParam("sid")String sid) throws Exception{
		return cspAssoStudentService.deleteOneBySId(sid);
	}

	//根据学生学号删除多条学生信息
	@RequestMapping("/deleteStuListBySId")
	public int deleteStuListBySId(@RequestParam("sidList")List<String> sidList) throws Exception{
		return cspAssoStudentService.deleteListBySId(sidList);
	}

	//更新单条学生信息
	@RequestMapping("/updateStuOne")
	public int updateStuOne(@RequestBody CspAssoStudent student) throws Exception{
		return cspAssoStudentService.updateOne(student);
	}
}
