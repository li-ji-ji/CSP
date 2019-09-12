package cn.yzj.shop.mapper;

import cn.yzj.shop.po.ArticleCat;
import cn.yzj.shop.po.ArticleCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCatMapper {
    int countByExample(ArticleCatExample example);

    int deleteByExample(ArticleCatExample example);

    int deleteByPrimaryKey(Integer catId);

    int insert(ArticleCat record);

    int insertSelective(ArticleCat record);

    List<ArticleCat> selectByExample(ArticleCatExample example);

    ArticleCat selectByPrimaryKey(Integer catId);

    int updateByExampleSelective(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    int updateByExample(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    int updateByPrimaryKeySelective(ArticleCat record);

    int updateByPrimaryKey(ArticleCat record);
}