package cn.lhj.csp.assomanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.lhj.csp.assomanagement.dto.AssoActivityFormDto;
import cn.lhj.csp.assomanagement.mapper.AssoActivityMapper;
import cn.lhj.csp.assomanagement.mapper.CspAssoManagementMapper;
import cn.lhj.csp.assomanagement.po.CspActStuRelation;
import cn.lhj.csp.assomanagement.po.CspAssoActivity;
import cn.lhj.csp.assomanagement.po.CspAssoActivityExample;
import cn.lhj.csp.assomanagement.po.CspAssoManagement;
import cn.lhj.csp.assomanagement.service.CspActStuRelationService;
import cn.lhj.csp.assomanagement.service.CspAssoActivityService;
import cn.lhj.csp.assomanagement.service.CspAssoManagementService;
import cn.lhj.csp.assomanagement.service.CspAssoStudentService;
import cn.lhj.csp.assomanagement.utils.RandomAssoId;

@Service
public class CspAssoActivityServiceImpl implements CspAssoActivityService {

	@Autowired
	private AssoActivityMapper assoActivityMapper;
	@Autowired
	private CspAssoManagementService assoService;
	@Autowired
	private CspAssoStudentService assoStuService;
	@Autowired
	private CspActStuRelationService actStuRelation;
	
	
	//查询所有活动条数
	@Override
	public int countActivityAll()throws Exception{
		return assoActivityMapper.countByExample(null);
	}
	//查询所有活动
	@Override
	public List<CspAssoActivity> getActivityAll() throws Exception {
		return assoActivityMapper.selectByExample(null);
	}
	//查询所有活动（分页）
	@Override
	public List<CspAssoActivity> getActivityAllLimit(Integer page,Integer count) throws Exception {
		PageHelper.startPage(page,count);
		return assoActivityMapper.selectByExample(null);
	}
	//根据活动状态查询活动
	@Override
	public List<CspAssoActivity> getActivityByStatus(Integer status) throws Exception {
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStatusEqualTo(status);
		return assoActivityMapper.selectByExample(example);
	}
	//根据活动状态查询活动（分页）
	@Override
	public List<CspAssoActivity> getActivityByStatusLimit(Integer status,Integer page,Integer count) throws Exception {
		PageHelper.startPage(page,count);
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStatusEqualTo(status);
		return assoActivityMapper.selectByExample(example);
	}
	//根据活动ID查询活动
	@Override
	public CspAssoActivity getActivityById(Integer id) throws Exception {
		return assoActivityMapper.selectByPrimaryKey(id);
	}

	//根据活动名称查询活动
	@Override
	public List<CspAssoActivity> getActivityByName(String name) throws Exception {
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityNameEqualTo(name);
		return assoActivityMapper.selectByExample(example);
	}

	//根据活动编号查询活动
	@Override
	public CspAssoActivity getActivityByActId(String actId) throws Exception {
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(actId);
		if(assoActivityMapper.selectByExample(example).size()==0) {
			return null;
		}
		else {
			return assoActivityMapper.selectByExample(example).get(0);
		}
	}

	//根据社团编号查询活动
	@Override
	public List<CspAssoActivity> getActivityByAId(String assoId) throws Exception {
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityAssoIdEqualTo(assoId);
		System.out.println(assoActivityMapper.selectByExample(example).toString());
		return assoActivityMapper.selectByExample(example);
	}
	//根据社团编号查询活动（分页）
	@Override
	public List<CspAssoActivity> getActivityByAIdLimit(String assoId,Integer page,Integer count) throws Exception {
		PageHelper.startPage(page,count);
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityAssoIdEqualTo(assoId);
		System.out.println(assoActivityMapper.selectByExample(example).toString());
		return assoActivityMapper.selectByExample(example);
	}
	//根据活动负责人编号查询活动
	@Override
	public List<CspAssoActivity> getActivityByOId(String oId) throws Exception {
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityOrganizerIdEqualTo(oId);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间以及报名状态查询未开始活动
	@Override
	public List<CspAssoActivity> getActByStartTime(Date startTime) throws Exception{
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStartTimeGreaterThan(startTime);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间查询未开始活动（分页）
	@Override
	public List<CspAssoActivity> getActByStartTimeLimit(Date startTime,Integer page,Integer count) throws Exception{
		PageHelper.startPage(page,count);
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStartTimeGreaterThan(startTime);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间以及报名状态查询未开始活动
	@Override
	public List<CspAssoActivity> getActByStartTimeAndPartStatus(Date startTime,Integer partStatus) throws Exception{
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStartTimeGreaterThan(startTime);
		criteria.andActivityPartStatusEqualTo(partStatus);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间以及报名状态查询未开始活动（分页）
	@Override
	public List<CspAssoActivity> getActByStartTimeAndPartStatusLimit(Date startTime,Integer partStatus,Integer page,Integer count) throws Exception{
		PageHelper.startPage(page,count);
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityStartTimeGreaterThan(startTime);
		criteria.andActivityPartStatusEqualTo(partStatus);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间查询已结束活动
	@Override
	public List<CspAssoActivity> getActByFinishTime(Date finishTime) throws Exception{
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityFinishTimeLessThan(finishTime);
		return assoActivityMapper.selectByExample(example);
	}
	//根据时间查询已结束活动（分页）
	@Override
	public List<CspAssoActivity> getActByFinishTimeLimit(Date finishTime,Integer page,Integer count) throws Exception{
		PageHelper.startPage(page,count);
		CspAssoActivityExample example=new CspAssoActivityExample();
		CspAssoActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityFinishTimeLessThan(finishTime);
		return assoActivityMapper.selectByExample(example);
	}
	//根据学生学号查询已报名进行中活动
	@Override
	public List<CspAssoActivity> getActByStuIdStarted(String stuId)throws Exception{
		List<CspActStuRelation> relations=actStuRelation.getActStuRelationByStuId(stuId);
		List<CspAssoActivity> actList=new ArrayList();
		Date now=new Date();
		for(CspActStuRelation relation:relations) {
			CspAssoActivity act=getActivityByActId(relation.getActId());
//			System.out.println("--------------------------------------------------");
//			System.out.println(act.getActivityStartTime());
//			System.out.println(act.getActivityFinishTime());
//			System.out.println(now);
//			System.out.println("--------------------------------------------------");
			if(act.getActivityStartTime().before(now)&&act.getActivityFinishTime().after(now)) {
				actList.add(act);
			}
		}
		return actList;
	}
	//根据学生学号查询已报名未开始活动
	@Override
	public List<CspAssoActivity> getActByStuIdSigned(String stuId) throws Exception {
		List<CspActStuRelation> relations=actStuRelation.getActStuRelationByStuId(stuId);
		List<CspAssoActivity> actList=new ArrayList();
		Date now=new Date();
		for(CspActStuRelation relation:relations) {
			CspAssoActivity act=getActivityByActId(relation.getActId());
			if(act.getActivityStartTime().after(now)) {
				actList.add(act);
			}
		}
		return actList;
	}

	//根据学生学号查询已报名已结束活动
	@Override
	public List<CspAssoActivity> getActByStuIdFinished(String stuId) throws Exception {
		List<CspActStuRelation> relations=actStuRelation.getActStuRelationByStuId(stuId);
		List<CspAssoActivity> actList=new ArrayList();
		Date now=new Date();
		for(CspActStuRelation relation:relations) {
			CspAssoActivity act=getActivityByActId(relation.getActId());
			if(act.getActivityFinishTime().before(now)) {
				actList.add(act);
			}
		}
		return actList;
	}
	//添加活动
	@Override
	public int insertActicity(CspAssoActivity act) throws Exception {
		Date now=new Date();
		RandomAssoId randomAssoId=new RandomAssoId(); //根据日期生成随机ID
		String actId=randomAssoId.getRandomAssoId(now);
		while(getActivityByActId(actId)!=null){
			//判断随机ID是否重复
			actId=randomAssoId.getRandomAssoId(now); 
		}
		act.setActivityId(actId);
		act.setActivityOrganizerName(assoStuService.getBySId(act.getActivityOrganizerId()).getsName());
		act.setActivityAssoName(assoService.getAssoByAssoId(act.getActivityAssoId()).getAssoName());
		try {
			assoActivityMapper.insertSelective(act);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除单个活动
	@Override
	public int deleteActivityOneById(Integer id) throws Exception {
		try {
			assoActivityMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除多个活动
	@Override
	public int deleteActivityListById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				assoActivityMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据活动编号删除活动
	@Override
	public int deleteActivityByActId(String actId) throws Exception {
		try {
			CspAssoActivityExample example=new CspAssoActivityExample();
			CspAssoActivityExample.Criteria criteria=example.createCriteria();
			criteria.andActivityIdEqualTo(actId);
			assoActivityMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//更新活动
	@Override
	public int updateActivityOne(CspAssoActivity act) throws Exception {
		try {
			act.setActivityAssoName(assoService.getAssoByAssoId(act.getActivityAssoId()).getAssoName());
			act.setActivityOrganizerName(assoStuService.getBySId(act.getActivityOrganizerId()).getsName());
			assoActivityMapper.updateByPrimaryKeySelective(act);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//更新活动状态为开启
	@Override
	public int updateActivityStatusOpen(Integer id)throws Exception{
		CspAssoActivity act=new CspAssoActivity();
		act.setId(id);
		act.setActivityStatus(1);
		try {
			assoActivityMapper.updateByPrimaryKeySelective(act);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	//更新活动状态为结束
	@Override
	public int updateActivityStatusClose(Integer id)throws Exception{
		CspAssoActivity act=new CspAssoActivity();
		act.setId(id);
		act.setActivityStatus(2);
		try {
			assoActivityMapper.updateByPrimaryKeySelective(act);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据活动ID查询活动表单相关信息（社团成员，社团列表 ）
	@Override
	public AssoActivityFormDto getAssoActFormDto(Integer actId)throws Exception{
		AssoActivityFormDto actFormData=new AssoActivityFormDto();
		CspAssoActivity act=assoActivityMapper.selectByPrimaryKey(actId);
		actFormData.setAssoList(assoService.getAll());
		actFormData.setAssoStuList(assoStuService.getAll());
		actFormData.setActivityPartNum(assoStuService.getListByActId(act.getActivityAssoId()).size());
		BeanUtils.copyProperties(act,actFormData);
		System.out.println(actFormData.toString());
		return actFormData;
	}
	
}
