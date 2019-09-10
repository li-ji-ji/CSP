package cn.yzj.shop.mapper;

import cn.yzj.shop.po.AccountLog;
import cn.yzj.shop.po.AccountLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountLogMapper {
    int countByExample(AccountLogExample example);

    int deleteByExample(AccountLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(AccountLog record);

    int insertSelective(AccountLog record);

    List<AccountLog> selectByExample(AccountLogExample example);

    AccountLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") AccountLog record, @Param("example") AccountLogExample example);

    int updateByExample(@Param("record") AccountLog record, @Param("example") AccountLogExample example);

    int updateByPrimaryKeySelective(AccountLog record);

    int updateByPrimaryKey(AccountLog record);
}