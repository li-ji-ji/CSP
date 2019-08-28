package cn.lhj.csp.assomanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.po.CspActStuRelation;

@Service
public interface CspActStuRelationService {
	
	//查询所有关系条数
	public int countRelationAll()throws Exception;
	//根据活动编号查询关系条数
	public int countRelationByActId(String actId)throws Exception;
	//根据学生学号查询关系条数
	public int countRelationByStuId(String stuId)throws Exception;
	//查询所有活动与学生关系
	public List<CspActStuRelation> getActStuRelationAll()throws Exception;
	//查询所有活动与学生关系（分页）
	public List<CspActStuRelation> getActStuRelationAllLimit(Integer page,Integer count)throws Exception;
	//根据ID查询活动与学生关系
	public CspActStuRelation getActStuRelationById(Integer id)throws Exception;
	//根据活动ID查询所有活动与学生关系
	public List<CspActStuRelation> getActStuRelationByActId(String actId)throws Exception;
	//根据活动ID查询所有活动与学生关系（分页）
	public List<CspActStuRelation> getActStuRelationByActIdLimit(String actId,Integer page,Integer count)throws Exception;
	//根据学生ID查询所有活动与学生关系
	public List<CspActStuRelation> getActStuRelationByStuId(String stuId)throws Exception;
	//根据学生ID查询所有活动与学生关系（分页）
	public List<CspActStuRelation> getActStuRelationByStuIdLimit(String stuId,Integer page,Integer count)throws Exception;
	//根据学生学号和活动编号查询所有关系
	public List<CspActStuRelation> getActStuRelationByActIdAndStuId(String actId,String stuId)throws Exception;
	//根据学生学号和活动编号和状态查询关系
	public List<CspActStuRelation> getActStuRelationByActIdAndStuIdAndStatus(String actId,String stuId,Integer Status)throws Exception;
	//根据学生学号查询已报名未开始记录
	public List<CspActStuRelation> getActStuRelationSignedByStuId(String stuId)throws Exception;
	//根据学生学号查询已报名已开始未结束记录
	public List<CspActStuRelation> getActStuRelationStartedByStuId(String stuId)throws Exception;
	//根据学生学号查询已报名已结束记录
	public List<CspActStuRelation> getActStuRelationFinishedByStuId(String stuId)throws Exception;
	//添加单条活动与学生关系
	public int addActStuRelationOne(CspActStuRelation relation) throws Exception;
	//根据ID删除单条活动与学生关系
	public int delActStuRelationOneById(Integer id)throws Exception;
	//根据ID批量删除活动与学生关系
	public int delActStuRelationListById(List<Integer> idList)throws Exception;
	//修改单条活动与学生关系
	public int setActStuRelationOne(CspActStuRelation relation) throws Exception;
	//修改单条活动与学生关系状态
	public int setActStuRelationOneStatus(String actId,String stuId,Integer status)throws Exception;
	//修改单条活动与学生关系状态为取消
	public int setActStuRelationOneStatusCancel(String actId,String stuId)throws Exception;
}
