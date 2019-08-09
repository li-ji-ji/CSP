package cn.lhj.csp.adminmenu.mapper;

import cn.lhj.csp.adminmenu.po.CspAdminMenu;
import cn.lhj.csp.adminmenu.po.CspAdminMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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