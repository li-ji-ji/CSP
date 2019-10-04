package cn.lhj.csp.fileinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.lhj.csp.fileinfo.po.ShopCart;
import cn.lhj.csp.fileinfo.po.ShopCartExample;

public interface ShopCartMapper {
    int countByExample(ShopCartExample example);

    int deleteByExample(ShopCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    List<ShopCart> selectByExample(ShopCartExample example);

    ShopCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCart record, @Param("example") ShopCartExample example);

    int updateByExample(@Param("record") ShopCart record, @Param("example") ShopCartExample example);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
    
    @Select("SELECT * FROM shop_cart WHERE order_no = #{orderNo}")
    @Results({
    	@Result(property = "orderNo",  column = "order_no"),
		@Result(property = "totalFee",  column = "total_fee"),
		@Result(property = "studentId",  column = "student_id"),
	})
    ShopCart selectByOrderNo(String orderNo);
}