package cn.lhj.csp.asso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspAssoStudent;
import cn.lhj.csp.asso.po.CspAssoStudentExample;

public interface CspAssoStudentMapper {
    int countByExample(CspAssoStudentExample example);

    int deleteByExample(CspAssoStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoStudent record);

    int insertSelective(CspAssoStudent record);

    List<CspAssoStudent> selectByExample(CspAssoStudentExample example);

    CspAssoStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoStudent record, @Param("example") CspAssoStudentExample example);

    int updateByExample(@Param("record") CspAssoStudent record, @Param("example") CspAssoStudentExample example);

    int updateByPrimaryKeySelective(CspAssoStudent record);

    int updateByPrimaryKey(CspAssoStudent record);
}