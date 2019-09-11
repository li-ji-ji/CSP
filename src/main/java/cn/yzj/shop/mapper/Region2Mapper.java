package cn.yzj.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.yzj.shop.po.Region2;
import cn.yzj.shop.po.Region2Example;

public interface Region2Mapper {
    int countByExample(Region2Example example);

    int deleteByExample(Region2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Region2 record);

    int insertSelective(Region2 record);

    List<Region2> selectByExample(Region2Example example);

    Region2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Region2 record, @Param("example") Region2Example example);

    int updateByExample(@Param("record") Region2 record, @Param("example") Region2Example example);

    int updateByPrimaryKeySelective(Region2 record);

    int updateByPrimaryKey(Region2 record);
    
    @Select("SELECT * FROM region2 where parent_id=#{parentId}")
	@Results({
		@Result(property = "parentId",  column = "parent_id")
	})
    List<Region2> selectByParentId(Integer parentId);
}