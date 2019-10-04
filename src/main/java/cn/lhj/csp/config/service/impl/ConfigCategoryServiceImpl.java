package cn.lhj.csp.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.config.mapper.ConfigCategoryMapper;
import cn.lhj.csp.config.po.ConfigCategory;
import cn.lhj.csp.config.service.ConfigCategoryService;


@Service
public class ConfigCategoryServiceImpl implements ConfigCategoryService{

	@Autowired
	private ConfigCategoryMapper configCategoryMapper;
	
	@Override
	public List<ConfigCategory> getAll() {
		// TODO Auto-generated method stub
		return configCategoryMapper.selectByExample(null);
	}

	@Override
	public int insert(ConfigCategory configCategory) {
		// TODO Auto-generated method stub
		return configCategoryMapper.insertSelective(configCategory);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		configCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(ConfigCategory configCategory) {
		// TODO Auto-generated method stub
		configCategoryMapper.updateByPrimaryKeySelective(configCategory);
	}

	@Override
	public ConfigCategory findById(Integer id) {
		// TODO Auto-generated method stub
		return configCategoryMapper.selectByPrimaryKey(id);
	}

}
