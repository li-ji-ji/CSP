package cn.lhj.csp.assomanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.po.CspAssoStudent;

@Service
public interface CspAssoStudentService {
	
	//获取所有学生信息列表
	public List<CspAssoStudent> getAll()throws Exception;
	//根据ID获取单个学生信息
	public CspAssoStudent getById(Integer id)throws Exception;
	//根据学生学号获取单个学生信息
	public CspAssoStudent getBySId(String sid)throws Exception;
	//根据学生姓名获取学生信息列表
	public List<CspAssoStudent> getListByName(String name)throws Exception;
	//根据学生年段获取学生信息列表
	public List<CspAssoStudent> getListByGrade(Integer grade)throws Exception;
	//根据学生班级获取学生信息列表
	public List<CspAssoStudent> getListByMajor(String  major)throws Exception;
	//根据学生性别获取学生信息列表
	public List<CspAssoStudent> getListBySex(int sex)throws Exception;
	//根据学生当前参与活动ID获取学生信息列表
	public List<CspAssoStudent> getListByActId(String actId)throws Exception;
	//根据学生当前参与活动名称获取学生信息列表
	public List<CspAssoStudent> getListByActName(String actName)throws Exception;
	//添加学生信息
	public int insertOne(CspAssoStudent student)throws Exception;
	//根据ID删除单条学生信息
	public int deleteOneById(Integer id)throws Exception;
	//根据ID删除多条学生信息
	public int deleteListById(List<Integer> idList)throws Exception;
	//根据学号删除单条学生信息
	public int deleteOneBySId(String sid)throws Exception;
	//根据学号删除多条学生信息
	public int deleteListBySId(List<String> sidList)throws Exception;
	//修改单条学生信息
	public int updateOne(CspAssoStudent student)throws Exception;
}
