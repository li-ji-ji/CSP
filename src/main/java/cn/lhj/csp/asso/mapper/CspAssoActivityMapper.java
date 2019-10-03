package cn.lhj.csp.asso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.asso.po.CspAssoActivity;
import cn.lhj.csp.asso.po.CspAssoActivityExample;

public interface CspAssoActivityMapper {
    int countByExample(CspAssoActivityExample example);

    int deleteByExample(CspAssoActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoActivity record);

    int insertSelective(CspAssoActivity record);

    List<CspAssoActivity> selectByExample(CspAssoActivityExample example);

    CspAssoActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoActivity record, @Param("example") CspAssoActivityExample example);

    int updateByExample(@Param("record") CspAssoActivity record, @Param("example") CspAssoActivityExample example);

    int updateByPrimaryKeySelective(CspAssoActivity record);

    int updateByPrimaryKey(CspAssoActivity record);
}