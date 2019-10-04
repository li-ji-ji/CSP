package cn.lhj.csp.fileinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.fileinfo.po.PrintOrder;
import cn.lhj.csp.fileinfo.po.PrintOrderExample;


public interface PrintOrderMapper {
    int countByExample(PrintOrderExample example);

    int deleteByExample(PrintOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrintOrder record);

    int insertSelective(PrintOrder record);

    List<PrintOrder> selectByExample(PrintOrderExample example);

    PrintOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrintOrder record, @Param("example") PrintOrderExample example);

    int updateByExample(@Param("record") PrintOrder record, @Param("example") PrintOrderExample example);

    int updateByPrimaryKeySelective(PrintOrder record);

    int updateByPrimaryKey(PrintOrder record);
    
    @Select("SELECT * FROM print_order WHERE order_no = #{orderNo}")
    @Results({
		@Result(property = "orderNo",  column = "order_no"),
		@Result(property = "studentId",  column = "student_id"),
		@Result(property = "nickName",  column = "nick_name"),
		@Result(property = "orderImage",  column = "order_image"),
		@Result(property = "fileName",  column = "file_name"),
		@Result(property = "printMode",  column = "print_mode"),
		@Result(property = "printCopy",  column = "print_copy"),
		@Result(property = "deliveryMode",  column = "delivery_mode"),
		@Result(property = "orderTime",  column = "order_time"),
		@Result(property = "isUrgent",  column = "is_urgent"),
		@Result(property = "storeAddress",  column = "store_address"),
		@Result(property = "deliveryAddress",  column = "delivery_address"),
		@Result(property = "filePath",  column = "file_path")
	})
    PrintOrder selectByOrderNo(String orderNo);
    
    @Select("SELECT * FROM print_order WHERE order_no = #{orderNo}")
    @Results({
		@Result(property = "orderNo",  column = "order_no"),
		@Result(property = "studentId",  column = "student_id"),
		@Result(property = "nickName",  column = "nick_name"),
		@Result(property = "orderImage",  column = "order_image"),
		@Result(property = "fileName",  column = "file_name"),
		@Result(property = "printMode",  column = "print_mode"),
		@Result(property = "printCopy",  column = "print_copy"),
		@Result(property = "deliveryMode",  column = "delivery_mode"),
		@Result(property = "orderTime",  column = "order_time"),
		@Result(property = "isUrgent",  column = "is_urgent"),
		@Result(property = "storeAddress",  column = "store_address"),
		@Result(property = "deliveryAddress",  column = "delivery_address"),
		@Result(property = "filePath",  column = "file_path")
	})
    List<PrintOrder> selectListByOrderNo(String orderNo);
}