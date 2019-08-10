package com.cfz.csp.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfz.csp.authority.mapper.SysRoleMapper;
import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.po.SysRoleExample;
import com.cfz.csp.authority.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public long countByExample(SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insertSelective(record);
	}

	@Override
	public List<SysRole> selectByExample(SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByExample(example);
	}

	@Override
	public SysRole selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysRole record, SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRole record, SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SysRole> select(int page, int limit) {
		// TODO Auto-generated method stub
		page = (page - 1) * 10;
		return sysRoleMapper.select(page, limit);
	}

}
