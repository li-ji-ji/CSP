package cn.lhj.csp.assomanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.assomanagement.mapper.AssoGuiderMapper;
import cn.lhj.csp.assomanagement.po.CspAssoGuider;
import cn.lhj.csp.assomanagement.po.CspAssoGuiderExample;
import cn.lhj.csp.assomanagement.service.CspAssoGuiderService;

@Service
public class CspAssoGuiderServiceImpl implements CspAssoGuiderService {

	@Autowired
	private AssoGuiderMapper assoGuiderMapper;
	
	//查询所有指导老师
	@Override
	public List<CspAssoGuider> getAll() throws Exception {
		// TODO Auto-generated method stub
		return assoGuiderMapper.selectByExample(null);
	}

	//根据ID查询指导老师
	@Override
	public CspAssoGuider getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return assoGuiderMapper.selectByPrimaryKey(id);
	}

	//根据工号查询指导老师
	@Override
	public CspAssoGuider getByTid(String tId) throws Exception {
		// TODO Auto-generated method stub
		CspAssoGuiderExample example=new CspAssoGuiderExample();
		CspAssoGuiderExample.Criteria criteria=example.createCriteria();
		criteria.andTIdEqualTo(tId);
		return assoGuiderMapper.selectByExample(example).get(0);
	}

	//根据姓名查询指导老师
	@Override
	public List<CspAssoGuider> getByName(String tName) throws Exception {
		CspAssoGuiderExample example=new CspAssoGuiderExample();
		CspAssoGuiderExample.Criteria criteria=example.createCriteria();
		criteria.andTIdEqualTo(tName);
		return assoGuiderMapper.selectByExample(example);
	}

	//增加指导老师
	@Override
	public int insertOne(CspAssoGuider guider) throws Exception {
		try {
			assoGuiderMapper.insertSelective(guider);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除指导老师
	@Override
	public int deleteOneById(Integer id) throws Exception {
		try {
			assoGuiderMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据工号删除指导老师
	@Override
	public int deleteOneByTid(String tId) throws Exception {
		CspAssoGuiderExample example=new CspAssoGuiderExample();
		CspAssoGuiderExample.Criteria criteria=example.createCriteria();
		criteria.andTIdEqualTo(tId);
		try {
			assoGuiderMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//批量删除指导老师
	@Override
	public int deleteListById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList){
				assoGuiderMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//更新指导老师信息
	@Override
	public int updateOne(CspAssoGuider guider) throws Exception {
		try {
			assoGuiderMapper.updateByPrimaryKeySelective(guider);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
