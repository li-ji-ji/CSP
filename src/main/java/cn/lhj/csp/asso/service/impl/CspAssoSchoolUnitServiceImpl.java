package cn.lhj.csp.asso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.mapper.SchoolUnitMapper;
import cn.lhj.csp.asso.po.CspAssoSchoolUnit;
import cn.lhj.csp.asso.po.CspAssoSchoolUnitExample;
import cn.lhj.csp.asso.service.CspAssoSchoolUnitService;


@Service
public class CspAssoSchoolUnitServiceImpl implements CspAssoSchoolUnitService {

	@Autowired
	private SchoolUnitMapper schoolUnitMapper;
	
	//查询所有学校单位
	@Override
	public List<CspAssoSchoolUnit> getUnitAll() throws Exception {
		return schoolUnitMapper.selectByExample(null);
	}

	//根据ID查询学校单位
	@Override
	public CspAssoSchoolUnit getUnitById(Integer id) throws Exception {
		return schoolUnitMapper.selectByPrimaryKey(id);
	}

	//根据单位编号查询学校单位
	@Override
	public CspAssoSchoolUnit getUnitByNo(String no) throws Exception {
		CspAssoSchoolUnitExample example=new CspAssoSchoolUnitExample();
		CspAssoSchoolUnitExample.Criteria criteria=example.createCriteria();
		criteria.andUnitNoEqualTo(no);
		return schoolUnitMapper.selectByExample(example).get(0);
	}

	//根据上级单位查询学校单位
	@Override
	public List<CspAssoSchoolUnit> getUnitByPNo(String pno) throws Exception {
		CspAssoSchoolUnitExample example=new CspAssoSchoolUnitExample();
		CspAssoSchoolUnitExample.Criteria criteria=example.createCriteria();
		criteria.andPUnitNoEqualTo(pno);
		return schoolUnitMapper.selectByExample(example);
	}
	
	//增加学校单位
	@Override
	public int insertUnitOne(CspAssoSchoolUnit unit) throws Exception {
		try {
			schoolUnitMapper.insertSelective(unit);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除单个学校单位
	@Override
	public int deleteUnitOne(Integer id) throws Exception {
		try {
			schoolUnitMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID批量删除学校单位
	@Override
	public int deleteUnitList(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				schoolUnitMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据单位编号删除单个学校单位
	@Override
	public int deleteUnitOneByNo(String no) throws Exception {
		try {
			CspAssoSchoolUnitExample example=new CspAssoSchoolUnitExample();
			CspAssoSchoolUnitExample.Criteria criteria=example.createCriteria();
			criteria.andUnitNoEqualTo(no);
			schoolUnitMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//更新单个学校单位数据
	@Override
	public int updateUnitOne(CspAssoSchoolUnit unit) throws Exception {
		try {
			schoolUnitMapper.updateByPrimaryKeySelective(unit);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
