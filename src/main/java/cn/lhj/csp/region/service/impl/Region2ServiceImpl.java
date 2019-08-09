package cn.lhj.csp.region.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.region.mapper.Region2Mapper;
import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;
import cn.lhj.csp.region.service.Region2Service;

@Service
public class Region2ServiceImpl implements Region2Service {

	@Autowired
	private Region2Mapper region2Mapper;
	
	@Override
	public List<Region2> selectLevelOne() {
		Region2Example example=new Region2Example();
		Region2Example.Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(0);
		List<Region2> singleStages=region2Mapper.selectByExample(example);
		return singleStages;
	}


	@Override
	public Region2 selectByPrimaryKey(Integer id) {
		
		return region2Mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Region2> selectAll() {
		return region2Mapper.selectAll();
	}

	@Override
	public List<Region2> selectSingleStage(String name) {
		
		return region2Mapper.selectSingleStage(name);
	}


	@Override
	public List<Region2> selectSingleStageById(Integer id) {
		List<Region2> secondlevels=region2Mapper.selectSingleStageById(id);
		return secondlevels;
	}


	@Override
	public List<Region2> queryAllDataFromTable(int page, int limit, String keyWord) {
		page=(page-1)*limit;
        return region2Mapper.queryAllDataFromTable(page,limit,keyWord);
	}


	@Override
	public int queryAllCount(String keyWord) {
		return region2Mapper.queryAllCount(keyWord);
	}


	@Override
	public int updateByPrimaryKey(Region2 record) {
		
		return region2Mapper.updateByPrimaryKey(record);
	}


	@Override
	public int queryAllCountById(Integer id) {
		return region2Mapper.queryAllCountById(id);
	}


	@Override
	public List<Region2> queryAllDataFromTableById(int page, int limit, Integer id) {
		page=(page-1)*limit;
		return region2Mapper.queryAllDataFromTableById(page,limit,id);
	}


	@Override
	public List<Region2> selectSingleStageByIdPage(int page, int limit) {
		page=(page-1)*limit;
		return region2Mapper.selectSingleStageByIdPage(page, limit);
	}


	@Override
	public int queryAllCountByIdLevelOne() {
		return region2Mapper.queryAllCountByIdLevelOne();
	}


	@Override
	public String findNameByParentId(Integer parentId) {
		
			return region2Mapper.selectByPrimaryKey(parentId).getName();

		
	}


	@Override
	public int countByExample(Region2Example example) {
		
		return region2Mapper.countByExample(example);
	}


	@Override
	public int insertSelective(Region2 record) {
		
		return region2Mapper.insertSelective(record);
	}


	@Override
	public int deleteByPrimaryKey(Integer id) {
		return region2Mapper.deleteByPrimaryKey(id);
	}


	

	
	

}
