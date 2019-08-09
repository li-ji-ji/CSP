package cn.lhj.csp.assomanagement.mapper;

import cn.lhj.csp.assomanagement.po.CspAssoSchoolUnit;
import cn.lhj.csp.assomanagement.po.CspAssoSchoolUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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