package cn.lhj.csp.asso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspActStuRelation;
import cn.lhj.csp.asso.po.CspActStuRelationExample;

public interface CspActStuRelationMapper {
    int countByExample(CspActStuRelationExample example);

    int deleteByExample(CspActStuRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspActStuRelation record);

    int insertSelective(CspActStuRelation record);

    List<CspActStuRelation> selectByExample(CspActStuRelationExample example);

    CspActStuRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspActStuRelation record, @Param("example") CspActStuRelationExample example);

    int updateByExample(@Param("record") CspActStuRelation record, @Param("example") CspActStuRelationExample example);

    int updateByPrimaryKeySelective(CspActStuRelation record);

    int updateByPrimaryKey(CspActStuRelation record);
}