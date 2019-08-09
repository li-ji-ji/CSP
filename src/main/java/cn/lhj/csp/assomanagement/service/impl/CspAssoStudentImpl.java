package cn.lhj.csp.assomanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.mapper.AssoStudentMapper;
import cn.lhj.csp.assomanagement.po.CspAssoStudent;
import cn.lhj.csp.assomanagement.po.CspAssoStudentExample;
import cn.lhj.csp.assomanagement.service.CspAssoStudentService;

@Service
public class CspAssoStudentImpl implements CspAssoStudentService {

	@Autowired
	private AssoStudentMapper assoStudentMapper;
	

	
	//查询所有学生列表 
	@Override
	public List<CspAssoStudent> getAll() throws Exception {
		// TODO Auto-generated method stub
		return assoStudentMapper.selectByExample(null);
	}
	
	//根据ID查询单个学生信息
	@Override
	public CspAssoStudent getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return assoStudentMapper.selectByPrimaryKey(id);
	}
	
	//根据学生学号查询单个学生信息
	@Override
	public CspAssoStudent getBySId(String sid) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSIdEqualTo(sid);
		return assoStudentMapper.selectByExample(example).get(0);
	}

	//根据学生姓名查询学生列表
	@Override
	public List<CspAssoStudent> getListByName(String name) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSNameEqualTo(name);
		return assoStudentMapper.selectByExample(example);
	}

	//根据学生年段查询学生列表
	@Override
	public List<CspAssoStudent> getListByGrade(Integer grade) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSGradeEqualTo(grade);
		return assoStudentMapper.selectByExample(example);
	}

	//根据学生专业班级查询学生列表
	@Override
	public List<CspAssoStudent> getListByMajor(String major) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSMajorEqualTo(major);
		return assoStudentMapper.selectByExample(example);
	}

	//根据学生性别查询学生列表
	@Override
	public List<CspAssoStudent> getListBySex(int sex) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSSexEqualTo(sex);
		return assoStudentMapper.selectByExample(example);
	}

	//根据学生当前参与活动ID获取学生列表
	@Override
	public List<CspAssoStudent> getListByActId(String actId) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSActIdEqualTo(actId);
		return assoStudentMapper.selectByExample(example);
	}

	//根据学生当前参与活动名称获取学生列表
	@Override
	public List<CspAssoStudent> getListByActName(String actName) throws Exception {
		// TODO Auto-generated method stub
		CspAssoStudentExample example=new CspAssoStudentExample();
		CspAssoStudentExample.Criteria criteria=example.createCriteria();
		criteria.andSActNameEqualTo(actName);
		return assoStudentMapper.selectByExample(example);
	}

	//插入一条新的学生信息
	@Override
	public int insertOne(CspAssoStudent student) throws Exception {
		// TODO Auto-generated method stub
		try {
			assoStudentMapper.insertSelective(student);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除一条学生信息
	@Override
	public int deleteOneById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			assoStudentMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除多条学生信息
	@Override
	public int deleteListById(List<Integer> idList) throws Exception {
		// TODO Auto-generated method stub
		try {
			for(Integer id:idList) {
				assoStudentMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	//根据学生学号删除单条学生信息
	@Override
	public int deleteOneBySId(String sid) throws Exception {
		// TODO Auto-generated method stub\
		try {
			CspAssoStudentExample example=new CspAssoStudentExample();
			CspAssoStudentExample.Criteria criteria=example.createCriteria();
			criteria.andSIdEqualTo(sid);
			assoStudentMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	//根据学生学号删除多条学生信息
	@Override
	public int deleteListBySId(List<String> sidList) throws Exception {
		// TODO Auto-generated method stub
		try {
			for(String sid:sidList) {
				CspAssoStudentExample example=new CspAssoStudentExample();
				CspAssoStudentExample.Criteria criteria=example.createCriteria();
				criteria.andSIdEqualTo(sid);
				assoStudentMapper.deleteByExample(example);
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	//更新单条学生信息
	@Override
	public int updateOne(CspAssoStudent student) throws Exception {
		// TODO Auto-generated method stub
		try {
			assoStudentMapper.updateByPrimaryKeySelective(student);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

}
