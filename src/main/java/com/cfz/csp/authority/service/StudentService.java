package com.cfz.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfz.csp.authority.po.Student;
import com.cfz.csp.authority.po.StudentExample;

public interface StudentService {
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
    
    List<Student> select(int page,int limit);
    
    /**
     * 微信登录业务接口:
     * @param code
     * @param encryptedData
     * @param iv
     * @return
     */
    public String loginByWeixin(String code);
    
    /**通过username查找用户信息;*/
    public Student findByName(String name);
}
