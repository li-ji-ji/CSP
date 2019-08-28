package cn.lhj.csp.assomanagement.mapper;

import cn.lhj.csp.assomanagement.po.CspActRegister;
import cn.lhj.csp.assomanagement.po.CspActRegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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