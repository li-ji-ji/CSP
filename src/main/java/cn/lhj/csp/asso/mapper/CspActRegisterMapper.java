package cn.lhj.csp.asso.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspActRegister;
import cn.lhj.csp.asso.po.CspActRegisterExample;

public interface CspActRegisterMapper {
    int countByExample(CspActRegisterExample example);

    int deleteByExample(CspActRegisterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspActRegister record);

    int insertSelective(CspActRegister record);

    List<CspActRegister> selectByExample(CspActRegisterExample example);

    CspActRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspActRegister record, @Param("example") CspActRegisterExample example);

    int updateByExample(@Param("record") CspActRegister record, @Param("example") CspActRegisterExample example);

    int updateByPrimaryKeySelective(CspActRegister record);

    int updateByPrimaryKey(CspActRegister record);
}