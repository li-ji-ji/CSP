package cn.lhj.csp.assomanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.po.CspAssoSchool;

@Service
public interface CspAssoSchoolService {
	
	//查询所有学校
	public List<CspAssoSchool> getAssoSchoolAll()throws Exception;
	//根据ID查询学校
	public CspAssoSchool getAssoSchoolById(Integer id)throws Exception;
	//根据学校编号查询学校
	public CspAssoSchool getAssoSchoolBySNo(String sno)throws Exception;
	//根据省份编号查询学校
	public List<CspAssoSchool> getAssoSchoolByProId(Integer proId)throws Exception;
	//根据城市编号查询学校
	public List<CspAssoSchool> getAssoSchoolByCityId(Integer cityId)throws Exception;
	//根据学校名称查询学校
	public List<CspAssoSchool> getAssoSchoolByName(String name)throws Exception;
	//增加一个学校
	public int insertOne(CspAssoSchool school)throws Exception;
	//根据ID删除一个学校
	public int deleteOneById(Integer id)throws Exception;
	//根据ID批量删除学校
	public int deleteListById(List<Integer> idList)throws Exception;
	//根据学校编号删除一个学校
	public int deleteOneByNo(String no)throws Exception;
	//根据学校编号批量删除学校
	public int deleteListByNo(List<String> noList)throws Exception;
	//更新单个学校信息
	public int updateOne(CspAssoSchool school)throws Exception;
	
}
