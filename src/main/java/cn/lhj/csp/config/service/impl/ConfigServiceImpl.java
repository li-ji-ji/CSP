package cn.lhj.csp.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.config.mapper.ConfigMapper;
import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigExample;
import cn.lhj.csp.config.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigMapper configMapper;

	@Override
	public List<Config> selectAll() {
		// TODO Auto-generated method stub
		return configMapper.selectByExample(null);
	}

	@Override
	public void insert(Config config) {
		// TODO Auto-generated method stub
		configMapper.insertSelective(config);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		configMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void updateEnableById(Integer id, String enable) {
		// TODO Auto-generated method stub
		configMapper.updateEnableById(id, enable);
	}
	
	@Override
	public void update(Config config) {
		// TODO Auto-generated method stub
		configMapper.updateByPrimaryKeySelective(config);
	}

	@Override
	public Config findById(int id) {
		// TODO Auto-generated method stub
		return configMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Config> select(int page, int limit) {
		// TODOAuto-generated method stub
		page = (page - 1) * 10;
		return configMapper.select(page, limit);
	}

	@Override
	public List<Config> selectByType(String type) {
		// TODO Auto-generated method stub
		ConfigExample example = new ConfigExample();
		ConfigExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		return configMapper.selectByExample(example);
	}

}
