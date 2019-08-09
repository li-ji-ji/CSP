package cn.lhj.csp.assomanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.dto.AssoActivityFormDto;
import cn.lhj.csp.assomanagement.po.CspAssoActivity;

@Service
public interface CspAssoActivityService {
	
	//查询所有活动
	public List<CspAssoActivity> getActivityAll()throws Exception;
	//根据活动状态查询活动
	public List<CspAssoActivity> getActivityNotStart(Integer status)throws Exception;
	//根据活动ID查询活动
	public CspAssoActivity getActivityById(Integer id) throws Exception;
	//根据活动名称查询活动
	public List<CspAssoActivity> getActivityByName(String name)throws Exception;
	//根据活动编号查询活动
	public CspAssoActivity getActivityByActId(String actId)throws Exception;
	//根据社团编号查询活动
	public List<CspAssoActivity> getActivityByAId(String assoId)throws Exception;
	//根据活动负责人编号查询活动
	public List<CspAssoActivity> getActivityByOId(String oId)throws Exception;
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
