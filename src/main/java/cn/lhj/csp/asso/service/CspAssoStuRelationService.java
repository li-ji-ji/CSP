package cn.lhj.csp.asso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.po.CspAssoStuRelation;


@Service
public interface CspAssoStuRelationService {

	//查询所有学生与社团关系
	public List<CspAssoStuRelation> getASRelationAll()throws Exception;
	//根据社团编号查询关系
	public List<CspAssoStuRelation> getASRelationByAId(String assoId)throws Exception;
	//根据学生编号查询关系
	public List<CspAssoStuRelation> getASRelationBySId(String stuId)throws Exception;
	//根据关系ID查询关系
	public CspAssoStuRelation getASRelationById(Integer id)throws Exception;
	//根据社团编号与学生编号查询关系
	public CspAssoStuRelation getRelationByASId(String assoId,String stuId)throws Exception;
	//根据社团编号查询关系条数
	public int countRelationByAId(String assoId)throws Exception;
	//根据学生学号查询关系条数
	public int countRelationBySId(String stuId)throws Exception;
	//增加单个关系
	public int insertRelationOne(CspAssoStuRelation relation)throws Exception;
	//删除单个关系
	public int deleteRelationOneById(Integer id)throws Exception;
	//批量删除关系
	public int deleteListRelationById(List<Integer> idList)throws Exception;
	//根据社团编号批量删除关系
	public int deleteRelationByAId(String assoId)throws Exception;
	//根据学生编号批量删除关系
	public int deleteRelationBySId(String stuId)throws Exception;
	//根据社团编号与学生编号删除关系
	public int deleteRelationByASId(String assoId,String stuId)throws Exception;
}
