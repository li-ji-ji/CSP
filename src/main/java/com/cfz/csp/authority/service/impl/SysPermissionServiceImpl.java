package com.cfz.csp.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfz.csp.authority.mapper.SysPermissionMapper;
import com.cfz.csp.authority.po.SysPermission;
import com.cfz.csp.authority.po.SysPermissionExample;
import com.cfz.csp.authority.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Override
	public long countByExample(SysPermissionExample example) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysPermissionExample example) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysPermission record) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(SysPermission record) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.insertSelective(record);
	}

	@Override
	public List<SysPermission> selectByExample(SysPermissionExample example) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.selectByExample(example);
	}

	@Override
	public SysPermission selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysPermission record, SysPermissionExample example) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysPermission record, SysPermissionExample example) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysPermission record) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysPermission record) {
		// TODO Auto-generated method stub
		return sysPermissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SysPermission> select(int page, int limit) {
		// TODO Auto-generated method stub
		page = (page - 1) * 10;
		return sysPermissionMapper.select(page, limit);
	}

}
