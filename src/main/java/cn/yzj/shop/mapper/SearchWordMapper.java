package cn.yzj.shop.mapper;

import cn.yzj.shop.po.SearchWord;
import cn.yzj.shop.po.SearchWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchWordMapper {
    int countByExample(SearchWordExample example);

    int deleteByExample(SearchWordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchWord record);

    int insertSelective(SearchWord record);

    List<SearchWord> selectByExample(SearchWordExample example);

    SearchWord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchWord record, @Param("example") SearchWordExample example);

    int updateByExample(@Param("record") SearchWord record, @Param("example") SearchWordExample example);

    int updateByPrimaryKeySelective(SearchWord record);

    int updateByPrimaryKey(SearchWord record);
}