package cn.lhj.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.po.StudentExample;
import cn.lhj.csp.authority.po.UserBinding;

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

    boolean updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> select(int page,int limit);
    
    //批量插入
    int insertStudentInfoBatch(List<Student> students);
    
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
    
    public List<Student> selectStudentBatch(String ids)throws Exception;
    
    public Student userLogin(String code)throws Exception;
    
    public Student binding(UserBinding user)throws Exception;
}
