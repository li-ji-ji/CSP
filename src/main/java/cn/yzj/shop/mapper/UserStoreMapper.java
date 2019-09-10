package cn.yzj.shop.mapper;

import cn.yzj.shop.po.UserStore;
import cn.yzj.shop.po.UserStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStoreMapper {
    int countByExample(UserStoreExample example);

    int deleteByExample(UserStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserStore record);

    int insertSelective(UserStore record);

    List<UserStore> selectByExample(UserStoreExample example);

    UserStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserStore record, @Param("example") UserStoreExample example);

    int updateByExample(@Param("record") UserStore record, @Param("example") UserStoreExample example);

    int updateByPrimaryKeySelective(UserStore record);

    int updateByPrimaryKey(UserStore record);
}