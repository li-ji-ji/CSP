package com.cfz.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfz.csp.authority.po.SysStudentRole;
import com.cfz.csp.authority.po.SysStudentRoleExample;

public interface SysStudentRoleService {
	long countByExample(SysStudentRoleExample example);

    int deleteByExample(SysStudentRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysStudentRole record);

    int insertSelective(SysStudentRole record);

    List<SysStudentRole> selectByExample(SysStudentRoleExample example);

    SysStudentRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysStudentRole record, @Param("example") SysStudentRoleExample example);

    int updateByExample(@Param("record") SysStudentRole record, @Param("example") SysStudentRoleExample example);

    int updateByPrimaryKeySelective(SysStudentRole record);

    int updateByPrimaryKey(SysStudentRole record);
    
    public List<SysStudentRole> select(int page, int limit);
}
