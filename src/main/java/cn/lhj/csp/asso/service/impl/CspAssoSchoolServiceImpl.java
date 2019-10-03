package cn.lhj.csp.asso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.mapper.AssoSchoolMapper;
import cn.lhj.csp.asso.po.CspAssoSchool;
import cn.lhj.csp.asso.po.CspAssoSchoolExample;
import cn.lhj.csp.asso.service.CspAssoSchoolService;


@Service
public class CspAssoSchoolServiceImpl implements CspAssoSchoolService {

	@Autowired
	private AssoSchoolMapper assoSchoolMapper;
	
	//查询所有学校
	@Override
	public List<CspAssoSchool> getAssoSchoolAll() throws Exception {
		return assoSchoolMapper.selectByExample(null);
	}

	//根据ID查询学校
	@Override
	public CspAssoSchool getAssoSchoolById(Integer id) throws Exception {
		return assoSchoolMapper.selectByPrimaryKey(id);
	}

	//根据学校编号查询学校
	@Override
	public CspAssoSchool getAssoSchoolBySNo(String sno) throws Exception {
		CspAssoSchoolExample example=new CspAssoSchoolExample();
		CspAssoSchoolExample.Criteria criteria=example.createCriteria();
		criteria.andSchoolNoEqualTo(sno);
		return assoSchoolMapper.selectByExample(example).get(0);
	}

	//根据省份编号查询学校
	@Override
	public List<CspAssoSchool> getAssoSchoolByProId(Integer proId) throws Exception {
		CspAssoSchoolExample example=new CspAssoSchoolExample();
		CspAssoSchoolExample.Criteria criteria=example.createCriteria();
		criteria.andSchoolAddressProvinceIdEqualTo(proId);
		return assoSchoolMapper.selectByExample(example);
	}

	//根据城市编号查询学校
	@Override
	public List<CspAssoSchool> getAssoSchoolByCityId(Integer cityId) throws Exception {
		CspAssoSchoolExample example=new CspAssoSchoolExample();
		CspAssoSchoolExample.Criteria criteria=example.createCriteria();
		criteria.andSchoolAddressCityIdEqualTo(cityId);
		return assoSchoolMapper.selectByExample(example);
	}

	//根据学校名称查询学校
	@Override
	public List<CspAssoSchool> getAssoSchoolByName(String name) throws Exception {
		CspAssoSchoolExample example=new CspAssoSchoolExample();
		CspAssoSchoolExample.Criteria criteria=example.createCriteria();
		criteria.andSchoolNameEqualTo(name);
		return assoSchoolMapper.selectByExample(example);
	}

	//增加一个学校
	@Override
	public int insertOne(CspAssoSchool school) throws Exception {
		System.out.println(school.getSchoolName());
		return assoSchoolMapper.insertSelective(school);
	}

	//根据ID删除一个学校
	@Override
	public int deleteOneById(Integer id) throws Exception {
		try {
			assoSchoolMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID批量删除学校
	@Override
	public int deleteListById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				assoSchoolMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据学校编号删除一个学校
	@Override
	public int deleteOneByNo(String no) throws Exception {
		try {
			CspAssoSchoolExample example=new CspAssoSchoolExample();
			CspAssoSchoolExample.Criteria criteria=example.createCriteria();
			criteria.andSchoolNoEqualTo(no);
			assoSchoolMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据学校编号批量删除学校
	@Override
	public int deleteListByNo(List<String> noList) throws Exception {
		try {
			for(String no:noList) {
				CspAssoSchoolExample example=new CspAssoSchoolExample();
				CspAssoSchoolExample.Criteria criteria=example.createCriteria();
				criteria.andSchoolNoEqualTo(no);
				assoSchoolMapper.deleteByExample(example);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//更新单个学校信息
	@Override
	public int updateOne(CspAssoSchool school) throws Exception {
		System.out.println(school.toString());
		try {
			assoSchoolMapper.updateByPrimaryKeySelective(school);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
