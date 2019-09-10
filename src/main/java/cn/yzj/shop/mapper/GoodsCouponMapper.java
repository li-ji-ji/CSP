package cn.yzj.shop.mapper;

import cn.yzj.shop.po.GoodsCouponExample;
import cn.yzj.shop.po.GoodsCouponKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCouponMapper {
    int countByExample(GoodsCouponExample example);

    int deleteByExample(GoodsCouponExample example);

    int deleteByPrimaryKey(GoodsCouponKey key);

    int insert(GoodsCouponKey record);

    int insertSelective(GoodsCouponKey record);

    List<GoodsCouponKey> selectByExample(GoodsCouponExample example);

    int updateByExampleSelective(@Param("record") GoodsCouponKey record, @Param("example") GoodsCouponExample example);

    int updateByExample(@Param("record") GoodsCouponKey record, @Param("example") GoodsCouponExample example);
}