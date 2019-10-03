package cn.lhj.csp.asso.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspAssoSchoolUnit;
import cn.lhj.csp.asso.po.CspAssoSchoolUnitExample;

public interface CspAssoSchoolUnitMapper {
    int countByExample(CspAssoSchoolUnitExample example);

    int deleteByExample(CspAssoSchoolUnitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoSchoolUnit record);

    int insertSelective(CspAssoSchoolUnit record);

    List<CspAssoSchoolUnit> selectByExample(CspAssoSchoolUnitExample example);

    CspAssoSchoolUnit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoSchoolUnit record, @Param("example") CspAssoSchoolUnitExample example);

    int updateByExample(@Param("record") CspAssoSchoolUnit record, @Param("example") CspAssoSchoolUnitExample example);

    int updateByPrimaryKeySelective(CspAssoSchoolUnit record);

    int updateByPrimaryKey(CspAssoSchoolUnit record);
}