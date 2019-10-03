package cn.lhj.csp.asso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspAssoStuRelation;
import cn.lhj.csp.asso.po.CspAssoStuRelationExample;

public interface CspAssoStuRelationMapper {
    int countByExample(CspAssoStuRelationExample example);

    int deleteByExample(CspAssoStuRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoStuRelation record);

    int insertSelective(CspAssoStuRelation record);

    List<CspAssoStuRelation> selectByExample(CspAssoStuRelationExample example);

    CspAssoStuRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoStuRelation record, @Param("example") CspAssoStuRelationExample example);

    int updateByExample(@Param("record") CspAssoStuRelation record, @Param("example") CspAssoStuRelationExample example);

    int updateByPrimaryKeySelective(CspAssoStuRelation record);

    int updateByPrimaryKey(CspAssoStuRelation record);
}