package cn.lhj.csp.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.authority.mapper.SysRolePermissionMapper;
import cn.lhj.csp.authority.po.SysRolePermission;
import cn.lhj.csp.authority.po.SysRolePermissionExample;
import cn.lhj.csp.authority.service.SysRolePermissionService;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@Override
	public long countByExample(SysRolePermissionExample example) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRolePermissionExample example) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysRolePermission record) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRolePermission record) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.insertSelective(record);
	}

	@Override
	public List<SysRolePermission> selectByExample(SysRolePermissionExample example) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysRolePermission record, SysRolePermissionExample example) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRolePermission record, SysRolePermissionExample example) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.updateByExample(record, example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysRolePermission selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRolePermission record) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRolePermission record) {
		// TODO Auto-generated method stub
		return sysRolePermissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SysRolePermission> select(int page, int limit) {
		// TODO Auto-generated method stub
		page = (page - 1) * 10;
		return sysRolePermissionMapper.select(page, limit);
	}

}
