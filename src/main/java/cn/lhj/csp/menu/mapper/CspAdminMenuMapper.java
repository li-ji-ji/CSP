package cn.lhj.csp.menu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.lhj.csp.menu.po.CspAdminMenu;
import cn.lhj.csp.menu.po.CspAdminMenuExample;

public interface CspAdminMenuMapper {
    int countByExample(CspAdminMenuExample example);

    int deleteByExample(CspAdminMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAdminMenu record);

    int insertSelective(CspAdminMenu record);

    List<CspAdminMenu> selectByExample(CspAdminMenuExample example);

    CspAdminMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAdminMenu record, @Param("example") CspAdminMenuExample example);

    int updateByExample(@Param("record") CspAdminMenu record, @Param("example") CspAdminMenuExample example);

    int updateByPrimaryKeySelective(CspAdminMenu record);

    int updateByPrimaryKey(CspAdminMenu record);
}