package cn.lhj.csp.asso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.po.CspAssoSchoolUnit;





@Service
public interface CspAssoSchoolUnitService {
	
	//查询所有学校单位
	public List<CspAssoSchoolUnit> getUnitAll() throws Exception;
	//根据ID查询学校单位
	public CspAssoSchoolUnit getUnitById(Integer id)throws Exception;
	//根据单位编号查询学校单位
	public CspAssoSchoolUnit getUnitByNo(String no)throws Exception;
	//根据上级单位查询学校单位
	public List<CspAssoSchoolUnit> getUnitByPNo(String pno)throws Exception;
	//增加学校单位
	public int insertUnitOne(CspAssoSchoolUnit unit)throws Exception;
	//根据ID删除单个学校单位
	public int deleteUnitOne(Integer id)throws Exception;
	//根据ID批量删除学校单位
	public int deleteUnitList(List<Integer> idList)throws Exception;
	//根据单位编号删除单个学校单位
	public int deleteUnitOneByNo(String no)throws Exception;
	//更新单个学校单位数据
	public int updateUnitOne(CspAssoSchoolUnit unit)throws Exception;
	
}
