package com.cfz.csp.authority.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cfz.csp.authority.po.SysRolePermission;
import com.cfz.csp.authority.po.SysRolePermissionExample;

public interface SysRolePermissionMapper {
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
    
    @Select("SELECT * FROM sys_role_permission limit #{page},#{limit}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "roleId", column = "role_id"),
		@Result(property = "permissionId", column = "permission_id")
	})
	List<SysRolePermission> select(int page,int limit);
}