package cn.lhj.csp.config.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.config.po.ConfigCategory;
import cn.lhj.csp.config.po.ConfigCategoryExample;

public interface ConfigCategoryMapper {
    int countByExample(ConfigCategoryExample example);

    int deleteByExample(ConfigCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigCategory record);

    int insertSelective(ConfigCategory record);

    List<ConfigCategory> selectByExample(ConfigCategoryExample example);

    ConfigCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigCategory record, @Param("example") ConfigCategoryExample example);

    int updateByExample(@Param("record") ConfigCategory record, @Param("example") ConfigCategoryExample example);

    int updateByPrimaryKeySelective(ConfigCategory record);

    int updateByPrimaryKey(ConfigCategory record);
}