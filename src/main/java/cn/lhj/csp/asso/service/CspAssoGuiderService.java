package cn.lhj.csp.asso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.po.CspAssoGuider;

@Service
public interface CspAssoGuiderService {
	
	//查询所有指导老师
	public List<CspAssoGuider> getAll() throws Exception;
	//根据ID查询指导老师
	public CspAssoGuider getById(Integer id)throws Exception;
	//根据工号查询指导老师 
	public CspAssoGuider getByTid(String tId) throws Exception;
	//根据姓名查询指导老师
	public List<CspAssoGuider> getByName(String tName)throws Exception;
	//添加指导老师
	public int insertOne(CspAssoGuider guider)throws Exception;
	//根据ID删除指导老师
	public int deleteOneById(Integer id)throws Exception;
	//根据工号删除指导老师
	public int deleteOneByTid(String tId)throws Exception;
	//批量删除指导老师
	public int deleteListById(List<Integer> idList)throws Exception;
	//修改指导老师信息
	public int updateOne(CspAssoGuider guider) throws Exception;
}
