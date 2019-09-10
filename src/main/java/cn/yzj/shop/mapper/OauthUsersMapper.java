package cn.yzj.shop.mapper;

import cn.yzj.shop.po.OauthUsers;
import cn.yzj.shop.po.OauthUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthUsersMapper {
    int countByExample(OauthUsersExample example);

    int deleteByExample(OauthUsersExample example);

    int deleteByPrimaryKey(Integer tuId);

    int insert(OauthUsers record);

    int insertSelective(OauthUsers record);

    List<OauthUsers> selectByExample(OauthUsersExample example);

    OauthUsers selectByPrimaryKey(Integer tuId);

    int updateByExampleSelective(@Param("record") OauthUsers record, @Param("example") OauthUsersExample example);

    int updateByExample(@Param("record") OauthUsers record, @Param("example") OauthUsersExample example);

    int updateByPrimaryKeySelective(OauthUsers record);

    int updateByPrimaryKey(OauthUsers record);
}