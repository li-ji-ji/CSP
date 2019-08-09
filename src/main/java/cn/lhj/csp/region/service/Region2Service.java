package cn.lhj.csp.region.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;

public interface Region2Service {
	int countByExample(Region2Example example);
	
	List<Region2> selectLevelOne();

	Region2 selectByPrimaryKey(Integer id);

	// 获取表region2所有数据
	List<Region2> selectAll();

	//根据名字查询其子地域
	List<Region2> selectSingleStage(String name);
	
	//根据Id查询其子地域
	List<Region2> selectSingleStageById(Integer id);
	
	List<Region2> queryAllDataFromTable(int page, int limit, String keyWord);
	 
    int queryAllCount(String keyWord);
    
    int updateByPrimaryKey(Region2 record);
    
    int queryAllCountById(Integer id);
    
    List<Region2> queryAllDataFromTableById(@Param("page") int page, @Param("limit") int limit, @Param("id") Integer id);

    List<Region2> selectSingleStageByIdPage(@Param("page") int page, @Param("limit") int limit);
	
    int queryAllCountByIdLevelOne();
    
    String findNameByParentId(Integer parentId);
    
    //添加子地区
    int insertSelective(Region2 record);
    
    int deleteByPrimaryKey(Integer id);
}
