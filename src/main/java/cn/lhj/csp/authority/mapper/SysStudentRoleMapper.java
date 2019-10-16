package cn.lhj.csp.authority.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.authority.po.SysStudentRole;
import cn.lhj.csp.authority.po.SysStudentRoleExample;

public interface SysStudentRoleMapper {
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
    
    @Select("SELECT * FROM sys_student_role limit #{page},#{limit}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "sn", column = "sn"),
		@Result(property = "roleId", column = "role_id")
	})
	List<SysStudentRole> select(int page,int limit);
}