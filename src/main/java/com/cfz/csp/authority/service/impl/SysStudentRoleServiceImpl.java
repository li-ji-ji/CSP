package com.cfz.csp.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfz.csp.authority.mapper.SysStudentRoleMapper;
import com.cfz.csp.authority.po.SysStudentRole;
import com.cfz.csp.authority.po.SysStudentRoleExample;
import com.cfz.csp.authority.service.SysStudentRoleService;

@Service
public class SysStudentRoleServiceImpl implements SysStudentRoleService {

	@Autowired
	private SysStudentRoleMapper sysStudentRoleMapper;

	@Override
	public long countByExample(SysStudentRoleExample example) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysStudentRoleExample example) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysStudentRole record) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysStudentRole record) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.insertSelective(record);
	}

	@Override
	public List<SysStudentRole> selectByExample(SysStudentRoleExample example) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysStudentRole record, SysStudentRoleExample example) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysStudentRole record, SysStudentRoleExample example) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.updateByExample(record, example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysStudentRole selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysStudentRole record) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysStudentRole record) {
		// TODO Auto-generated method stub
		return sysStudentRoleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SysStudentRole> select(int page, int limit) {
		// TODOAuto-generated method stub
		page = (page - 1) * 10;
		return sysStudentRoleMapper.select(page, limit);
	}

}
