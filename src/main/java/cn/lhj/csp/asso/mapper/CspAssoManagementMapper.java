package cn.lhj.csp.asso.mapper;


import cn.lhj.csp.asso.po.CspAssoManagement;
import cn.lhj.csp.asso.po.CspAssoManagementExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CspAssoManagementMapper {
    int countByExample(CspAssoManagementExample example);

    int deleteByExample(CspAssoManagementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoManagement record);

    int insertSelective(CspAssoManagement record);

    List<CspAssoManagement> selectByExample(CspAssoManagementExample example);

    CspAssoManagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoManagement record, @Param("example") CspAssoManagementExample example);

    int updateByExample(@Param("record") CspAssoManagement record, @Param("example") CspAssoManagementExample example);

    int updateByPrimaryKeySelective(CspAssoManagement record);

    int updateByPrimaryKey(CspAssoManagement record);
}