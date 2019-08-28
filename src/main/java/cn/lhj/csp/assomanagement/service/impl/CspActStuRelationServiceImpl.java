package cn.lhj.csp.assomanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.lhj.csp.assomanagement.feign.StudentRemote;
import cn.lhj.csp.assomanagement.mapper.ActStuRelationMapper;
import cn.lhj.csp.assomanagement.po.CspActStuRelation;
import cn.lhj.csp.assomanagement.po.CspActStuRelationExample;
import cn.lhj.csp.assomanagement.po.CspAssoActivity;
import cn.lhj.csp.assomanagement.po.student.Student;
import cn.lhj.csp.assomanagement.service.CspActStuRelationService;
import cn.lhj.csp.assomanagement.service.CspAssoActivityService;
import cn.lhj.csp.assomanagement.service.CspAssoManagementService;
@Service
public class CspActStuRelationServiceImpl implements CspActStuRelationService {

	@Autowired
	private ActStuRelationMapper actStuMapper;
	@Autowired
	private CspAssoActivityService assoAct;
	@Autowired
	private CspAssoManagementService assoManage;
	@Autowired
	private StudentRemote stuRemote;
	
	//查询所有关系条数
	@Override
	public int countRelationAll() throws Exception {
		return actStuMapper.countByExample(null);
	}

	//根据活动编号查询关系条数
	@Override
	public int countRelationByActId(String actId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.countByExample(example);
	}

	//根据学生学号查询关系条数
	@Override
	public int countRelationByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.countByExample(example);
	}
	
	//查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationAll() throws Exception {
		return actStuMapper.selectByExample(null);
	}

	//查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationAllLimit(Integer page, Integer count) throws Exception {
		PageHelper.startPage(page,count);
		return actStuMapper.selectByExample(null);
	}

	//根据ID查询活动与学生关系
	@Override
	public CspActStuRelation getActStuRelationById(Integer id) throws Exception {
		return actStuMapper.selectByPrimaryKey(id);
	}

	//根据活动ID查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActId(String actId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.selectByExample(example);
	}

	//根据活动ID查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdLimit(String actId, Integer page, Integer count)
			throws Exception {
		PageHelper.startPage(page,count);
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.selectByExample(example);
	}
	
	//根据学生ID查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}

	//根据学生ID查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationByStuIdLimit(String stuId, Integer page, Integer count)
			throws Exception {
		PageHelper.startPage(page,count);
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}
	
	//根据学生学号和活动编号查询所有关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdAndStuId(String actId, String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}
	//根据学生学号和活动编号和状态查询关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdAndStuIdAndStatus(String actId, String stuId, Integer Status)
			throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		criteria.andStuIdEqualTo(stuId);
		criteria.andStatusEqualTo(Status);
		return actStuMapper.selectByExample(example);
	}
	//根据学生学号查询已报名未开始记录
	@Override
	public List<CspActStuRelation> getActStuRelationSignedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityStartTime().after(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//根据学生学号查询已报名已开始未结束记录
	@Override
	public List<CspActStuRelation> getActStuRelationStartedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityStartTime().before(now)&&assoAct.getActivityByActId(relation.getActId()).getActivityFinishTime().after(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//根据学生学号查询已报名已结束记录
	@Override
	public List<CspActStuRelation> getActStuRelationFinishedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityFinishTime().before(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//添加单条活动与学生关系
	@Override
	public int addActStuRelationOne(CspActStuRelation relation) throws Exception {
		CspAssoActivity act=assoAct.getActivityByActId(relation.getActId());
		if(act.getActivityNum()>act.getActivityPartNum()) {
			act.setActivityPartNum(act.getActivityPartNum()+1);
			//System.out.println("参加人数："+act.getActivityPartNum());
			assoAct.updateActivityOne(act);
		}
		else {
			return 0;
		}
		relation.setActName(act.getActivityName());
		Student stu=stuRemote.getStudentBySn(relation.getStuId());
		relation.setStuName(stu.getName());
		List<CspActStuRelation> getRelation=getActStuRelationByActIdAndStuId(relation.getActId(),relation.getStuId());
		if(getRelation.size()==0) {
			Date now=new Date();
			relation.setSignTime(now);
			actStuMapper.insertSelective(relation);
			return 1;
		}
		else if(getRelation.get(0).getStatus()==0){
			getRelation.get(0).setStatus(1);
			Date now=new Date();
			getRelation.get(0).setSignTime(now);
			actStuMapper.updateByPrimaryKeySelective(getRelation.get(0));
			return 1;
		}
		return 0;
	}

	//根据ID删除单条活动与学生关系
	@Override
	public int delActStuRelationOneById(Integer id) throws Exception {
		try {
			actStuMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID批量删除活动与学生关系
	@Override
	public int delActStuRelationListById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				actStuMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//修改单条活动与学生关系
	@Override
	public int setActStuRelationOne(CspActStuRelation relation) throws Exception {
		try {
			actStuMapper.updateByPrimaryKeySelective(relation);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//修改单条活动与学生关系状态
	@Override
	public int setActStuRelationOneStatus(String actId, String stuId, Integer status) throws Exception {
		CspActStuRelation relation=getActStuRelationByActIdAndStuId(actId, stuId).get(0);
		relation.setStatus(status);
		return actStuMapper.updateByPrimaryKeySelective(relation);
	}

	//修改单条活动与学生关系状态为取消
	@Override
	public int setActStuRelationOneStatusCancel(String actId, String stuId) throws Exception {
		CspActStuRelation relation=getActStuRelationByActIdAndStuId(actId, stuId).get(0);
		relation.setStatus(0);
		CspAssoActivity act=assoAct.getActivityByActId(relation.getActId());
		if(actStuMapper.updateByPrimaryKeySelective(relation)==1) {
			if(act.getActivityPartNum()<=act.getActivityNum()&&act.getActivityPartNum()>0) {
				act.setActivityPartNum(act.getActivityPartNum()-1);
				return assoAct.updateActivityOne(act);
			}
		}
		return 0;
	}













}
