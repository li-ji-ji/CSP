package cn.yzj.shop.mapper;

import cn.yzj.shop.po.UserLevel;
import cn.yzj.shop.po.UserLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelMapper {
    int countByExample(UserLevelExample example);

    int deleteByExample(UserLevelExample example);

    int deleteByPrimaryKey(Short levelId);

    int insert(UserLevel record);

    int insertSelective(UserLevel record);

    List<UserLevel> selectByExample(UserLevelExample example);

    UserLevel selectByPrimaryKey(Short levelId);

    int updateByExampleSelective(@Param("record") UserLevel record, @Param("example") UserLevelExample example);

    int updateByExample(@Param("record") UserLevel record, @Param("example") UserLevelExample example);

    int updateByPrimaryKeySelective(UserLevel record);

    int updateByPrimaryKey(UserLevel record);
}