package com.cfz.csp.authority.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cfz.csp.authority.po.Student;
import com.cfz.csp.authority.po.StudentExample;

public interface StudentMapper {
	long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    Student selectStudentRolePermissionByName(String name);
    
    @Select("SELECT * FROM student limit #{page},#{limit}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "sn",  column = "sn"),
		@Result(property = "dormitoryAdd", column = "dormitorya_dd"),
		@Result(property = "famillyAdd", column = "familly_add")
	})
	List<Student> select(int page,int limit);
}