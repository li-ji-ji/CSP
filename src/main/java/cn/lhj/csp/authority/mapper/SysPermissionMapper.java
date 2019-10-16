package cn.lhj.csp.authority.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysPermissionExample;

public interface SysPermissionMapper {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    
    @Select("SELECT * FROM sys_permission limit #{page},#{limit}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "available", column = "available"),
		@Result(property = "name", column = "name"),
		@Result(property = "parentId", column = "parent_id"),
		@Result(property = "parentIds", column = "parent_ids"),
		@Result(property = "permission", column = "permission"),
		@Result(property = "resourceType", column = "resource_type"),
		@Result(property = "url", column = "url")
	})
	List<SysPermission> select(int page,int limit);
}