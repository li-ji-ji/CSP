package cn.lhj.csp.config.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigExample;


public interface ConfigMapper {
	
    int countByExample(ConfigExample example);

    int deleteByExample(ConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);
    
    List<Config> selectByExample(ConfigExample example);

    Config selectByPrimaryKey(Integer id);
    
    @Update("update config set enable =#{enable} where id =#{id}")
    int updateEnableById(Integer id,String enable);

    int updateByExampleSelective(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
    
    @Select("SELECT * FROM config limit #{page},#{limit}")
	@Results({
		@Result(property = "configKey",  column = "config_key"),
		@Result(property = "configValue", column = "config_value"),
		@Result(property = "dataType", column = "data_type")
	})
	List<Config> select(int page,int limit);
    
    @Select("SELECT * FROM config where type=#{type} limit 1")
    @Results({
		@Result(property = "configKey",  column = "config_key"),
		@Result(property = "configValue", column = "config_value"),
		@Result(property = "dataType", column = "data_type")
	})
    Config findOneByType(String type);
    
    @Select("SELECT distinct type FROM config where 1= 1")
    @Results({
		@Result(property = "configKey",  column = "config_key"),
		@Result(property = "configValue", column = "config_value"),
		@Result(property = "dataType", column = "data_type")
	})
    List<String> getTypes();
    
    @Select("SELECT * FROM config where config_key = #{configKey}")
    @Results({
		@Result(property = "configKey",  column = "config_key"),
		@Result(property = "configValue", column = "config_value"),
		@Result(property = "dataType", column = "data_type")
	})
    public Config findByConfigKey(String configKey);
    
}