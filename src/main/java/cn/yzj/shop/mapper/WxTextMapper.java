package cn.yzj.shop.mapper;

import cn.yzj.shop.po.WxText;
import cn.yzj.shop.po.WxTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxTextMapper {
    int countByExample(WxTextExample example);

    int deleteByExample(WxTextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxText record);

    int insertSelective(WxText record);

    List<WxText> selectByExampleWithBLOBs(WxTextExample example);

    List<WxText> selectByExample(WxTextExample example);

    WxText selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxText record, @Param("example") WxTextExample example);

    int updateByExampleWithBLOBs(@Param("record") WxText record, @Param("example") WxTextExample example);

    int updateByExample(@Param("record") WxText record, @Param("example") WxTextExample example);

    int updateByPrimaryKeySelective(WxText record);

    int updateByPrimaryKeyWithBLOBs(WxText record);

    int updateByPrimaryKey(WxText record);
}