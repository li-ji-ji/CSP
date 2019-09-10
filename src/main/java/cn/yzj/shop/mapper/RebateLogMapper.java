package cn.yzj.shop.mapper;

import cn.yzj.shop.po.RebateLog;
import cn.yzj.shop.po.RebateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebateLogMapper {
    int countByExample(RebateLogExample example);

    int deleteByExample(RebateLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RebateLog record);

    int insertSelective(RebateLog record);

    List<RebateLog> selectByExample(RebateLogExample example);

    RebateLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RebateLog record, @Param("example") RebateLogExample example);

    int updateByExample(@Param("record") RebateLog record, @Param("example") RebateLogExample example);

    int updateByPrimaryKeySelective(RebateLog record);

    int updateByPrimaryKey(RebateLog record);
}