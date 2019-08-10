package com.cfz.csp.authority.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.po.SysRoleExample;

public interface SysRoleMapper {
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
    
    @Select("SELECT * FROM sys_role limit #{page},#{limit}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "available", column = "available"),
		@Result(property = "description", column = "description"),
		@Result(property = "role", column = "role")
	})
	List<SysRole> select(int page,int limit);
}