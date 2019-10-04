package cn.lhj.csp.fileinfo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.fileinfo.po.PrintShop;
import cn.lhj.csp.fileinfo.po.PrintShopExample;

public interface PrintShopMapper {
    int countByExample(PrintShopExample example);

    int deleteByExample(PrintShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrintShop record);

    int insertSelective(PrintShop record);

    List<PrintShop> selectByExample(PrintShopExample example);

    PrintShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrintShop record, @Param("example") PrintShopExample example);

    int updateByExample(@Param("record") PrintShop record, @Param("example") PrintShopExample example);

    int updateByPrimaryKeySelective(PrintShop record);

    int updateByPrimaryKey(PrintShop record);
}