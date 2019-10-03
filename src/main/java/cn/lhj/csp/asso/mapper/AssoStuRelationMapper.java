package cn.lhj.csp.asso.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.asso.po.CspAssoStuRelation;


public interface AssoStuRelationMapper extends CspAssoStuRelationMapper{
	
	//根据社团编号和学生编号查询关系
	@Select("SELECT * FROM `csp_asso_stu_relation` where asso_id=#{assoId} and stu_id=#{stuId}")
	CspAssoStuRelation selectByASId(String assoId,String stuId)throws Exception;
	
	//根据社团编号查询关系条数
	@Select("SELECT COUNT(*) FROM `csp_asso_stu_relation` where asso_id=#{assoId}")
	int countByAId(String assoId)throws Exception;
	
	//根据学生编号查询关系条数
	@Select("SELECT COUNT(*) FROM `csp_asso_stu_relation` where stu_id=#{stuId}")
	int countBySId(String stuId)throws Exception;
	
	//根据社团编号和学生编号查询关系
	@Delete("delete FROM `csp_asso_stu_relation` where asso_id=#{assoId} and stu_id=#{stuId}")
	int deleteByASId(String assoId,String stuId)throws Exception;
}
