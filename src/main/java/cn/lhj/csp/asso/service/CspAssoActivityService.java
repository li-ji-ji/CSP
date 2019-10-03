package cn.lhj.csp.asso.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.dto.AssoActivityFormDto;
import cn.lhj.csp.asso.po.CspAssoActivity;


@Service
public interface CspAssoActivityService {
	
	//查询所有活动条数
	public int countActivityAll()throws Exception;
	//查询所有活动
	public List<CspAssoActivity> getActivityAll()throws Exception;
	//查询所有活动（分页）
	public List<CspAssoActivity> getActivityAllLimit(Integer page,Integer count)throws Exception;
	//根据活动状态查询活动
	public List<CspAssoActivity> getActivityByStatus(Integer status)throws Exception;
	//根据活动状态查询活动（分页）
	public List<CspAssoActivity> getActivityByStatusLimit(Integer status,Integer page,Integer count)throws Exception;
	//根据活动ID查询活动
	public CspAssoActivity getActivityById(Integer id) throws Exception;
	//根据活动名称查询活动
	public List<CspAssoActivity> getActivityByName(String name)throws Exception;
	//根据活动编号查询活动
	public CspAssoActivity getActivityByActId(String actId)throws Exception;
	//根据社团编号查询活动
	public List<CspAssoActivity> getActivityByAId(String assoId)throws Exception;
	//根据社团编号查询活动（分页）
	public List<CspAssoActivity> getActivityByAIdLimit(String assoId,Integer page,Integer count)throws Exception;
	//根据活动负责人编号查询活动
	public List<CspAssoActivity> getActivityByOId(String oId)throws Exception;
	//根据时间以及报名状态查询未开始活动
	public List<CspAssoActivity> getActByStartTime(Date startTime) throws Exception;
	//根据时间以及报名状态查询查询未开始活动（分页）
	public List<CspAssoActivity> getActByStartTimeLimit(Date startTime,Integer page,Integer count) throws Exception;

	//根据时间以及报名状态查询未开始活动
	public List<CspAssoActivity> getActByStartTimeAndPartStatus(Date startTime,Integer partStatus) throws Exception;
	//根据时间以及报名状态查询查询未开始活动（分页）
	public List<CspAssoActivity> getActByStartTimeAndPartStatusLimit(Date startTime,Integer partStatus,Integer page,Integer count) throws Exception;
	//根据时间查询已结束活动
	public List<CspAssoActivity> getActByFinishTime(Date finishTime) throws Exception;
	//根据时间查询已结束活动（分页）
	public List<CspAssoActivity> getActByFinishTimeLimit(Date finishTime,Integer page,Integer count) throws Exception;
	//根据学生学号查询已参加进行中活动
	public List<CspAssoActivity> getActByStuIdStarted(String stuId)throws Exception;
	//根据学生学号查询已报名未开始活动
	public List<CspAssoActivity> getActByStuIdSigned(String stuId)throws Exception;
	//根据学生学号查询已报名已结束活动
	public List<CspAssoActivity> getActByStuIdFinished(String stuId)throws Exception;
	//添加活动
	public int insertActicity(CspAssoActivity act)throws Exception;
	//根据ID删除单个活动
	public int deleteActivityOneById(Integer id)throws Exception;
	//根据ID删除多个活动
	public int deleteActivityListById(List<Integer> idList)throws Exception;
	//根据活动编号删除活动
	public int deleteActivityByActId(String actId)throws Exception;
	//更新活动
	public int updateActivityOne(CspAssoActivity act)throws Exception;
	//更新活动状态为开启
	public int updateActivityStatusOpen(Integer id)throws Exception;
	//更新活动状态为结束
	public int updateActivityStatusClose(Integer id)throws Exception;
	
	//查询活动表单相关信息（社团成员，社团列表 ）
	public AssoActivityFormDto getAssoActFormDto(Integer actId)throws Exception;
}
