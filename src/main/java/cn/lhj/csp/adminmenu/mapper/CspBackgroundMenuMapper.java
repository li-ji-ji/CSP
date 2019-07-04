package cn.lhj.csp.adminmenu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.adminmenu.po.CspBackgroundMenu;
import cn.lhj.csp.adminmenu.po.CspBackgroundMenuExample;

public interface CspBackgroundMenuMapper {
    int countByExample(CspBackgroundMenuExample example);

    int deleteByExample(CspBackgroundMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspBackgroundMenu record);

    int insertSelective(CspBackgroundMenu record);

    List<CspBackgroundMenu> selectByExample(CspBackgroundMenuExample example);

    CspBackgroundMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspBackgroundMenu record, @Param("example") CspBackgroundMenuExample example);

    int updateByExample(@Param("record") CspBackgroundMenu record, @Param("example") CspBackgroundMenuExample example);

    int updateByPrimaryKeySelective(CspBackgroundMenu record);

    int updateByPrimaryKey(CspBackgroundMenu record);
}