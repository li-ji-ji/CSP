package cn.yzj.shop.mapper;

import cn.yzj.shop.po.VirtualShop;
import cn.yzj.shop.po.VirtualShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VirtualShopMapper {
    int countByExample(VirtualShopExample example);

    int deleteByExample(VirtualShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VirtualShop record);

    int insertSelective(VirtualShop record);

    List<VirtualShop> selectByExampleWithBLOBs(VirtualShopExample example);

    List<VirtualShop> selectByExample(VirtualShopExample example);

    VirtualShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VirtualShop record, @Param("example") VirtualShopExample example);

    int updateByExampleWithBLOBs(@Param("record") VirtualShop record, @Param("example") VirtualShopExample example);

    int updateByExample(@Param("record") VirtualShop record, @Param("example") VirtualShopExample example);

    int updateByPrimaryKeySelective(VirtualShop record);

    int updateByPrimaryKeyWithBLOBs(VirtualShop record);

    int updateByPrimaryKey(VirtualShop record);
}