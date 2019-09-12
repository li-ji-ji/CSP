package cn.yzj.shop.mapper;

import cn.yzj.shop.po.Navigation;
import cn.yzj.shop.po.NavigationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavigationMapper {
    int countByExample(NavigationExample example);

    int deleteByExample(NavigationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Navigation record);

    int insertSelective(Navigation record);

    List<Navigation> selectByExample(NavigationExample example);

    Navigation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByExample(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByPrimaryKeySelective(Navigation record);

    int updateByPrimaryKey(Navigation record);
}