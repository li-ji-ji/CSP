package com.cfz.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfz.csp.authority.po.SysRolePermission;
import com.cfz.csp.authority.po.SysRolePermissionExample;

public interface SysRolePermissionService {
	long countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    SysRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
    
    List<SysRolePermission> select(int page,int limit);
}
