package cn.lhj.csp.region.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;

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
    
    List<Region2> selectAll();
    
    List<Region2> selectSingleStage(String name);
    
    List<Region2> selectSingleStageById(Integer id);
    
    List<Region2> selectSingleStageByIdPage(@Param("page") int page, @Param("limit") int limit);
    
    List<Region2> queryAllDataFromTable(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
    
    int queryAllCount(String keyWord);
    
    List<Region2> queryAllDataFromTableById(@Param("page") int page, @Param("limit") int limit, @Param("id") Integer id);
    
    int queryAllCountById(@Param("id") Integer id);
    
    int queryAllCountByIdLevelOne();


}