package cn.lhj.csp.fileinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.fileinfo.po.PersonFileinfo;
import cn.lhj.csp.fileinfo.po.PersonFileinfoExample;


public interface PersonFileinfoMapper {
	
    int countByExample(PersonFileinfoExample example);

    int deleteByExample(PersonFileinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonFileinfo record);

    int insertSelective(PersonFileinfo record);

    List<PersonFileinfo> selectByExample(PersonFileinfoExample example);

    PersonFileinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonFileinfo record, @Param("example") PersonFileinfoExample example);

    int updateByExample(@Param("record") PersonFileinfo record, @Param("example") PersonFileinfoExample example);

    int updateByPrimaryKeySelective(PersonFileinfo record);

    int updateByPrimaryKey(PersonFileinfo record);
    
    @Select("SELECT * FROM person_fileinfo WHERE print_order_id =#{orderId}")
    @Results({
		@Result(property = "studentId",  column = "student_id"),
		@Result(property = "printOrderId",  column = "print_order_id"),
		@Result(property = "fileImage",  column = "file_image"),
		@Result(property = "fileName",  column = "file_name"),
		@Result(property = "fileSize", column = "file_size")
	})
    List<PersonFileinfo> findByPrintOrderId(Integer orderId);
    
}