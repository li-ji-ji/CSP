package com.cfz.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.po.SysRoleExample;

public interface SysRoleService {
	long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    List<SysRole> select(int page,int limit);
}
