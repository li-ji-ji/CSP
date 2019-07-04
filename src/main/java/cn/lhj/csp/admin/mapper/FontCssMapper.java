package cn.lhj.csp.admin.mapper;

import cn.lhj.csp.admin.po.FontCss;
import cn.lhj.csp.admin.po.FontCssExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FontCssMapper {
    int countByExample(FontCssExample example);

    int deleteByExample(FontCssExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FontCss record);

    int insertSelective(FontCss record);

    List<FontCss> selectByExample(FontCssExample example);

    FontCss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FontCss record, @Param("example") FontCssExample example);

    int updateByExample(@Param("record") FontCss record, @Param("example") FontCssExample example);

    int updateByPrimaryKeySelective(FontCss record);

    int updateByPrimaryKey(FontCss record);
}