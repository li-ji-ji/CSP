package cn.lhj.csp.fileinfo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.po.PrinterExample;

public interface PrinterMapper {
    int countByExample(PrinterExample example);

    int deleteByExample(PrinterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Printer record);

    int insertSelective(Printer record);

    List<Printer> selectByExample(PrinterExample example);

    Printer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByExample(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByPrimaryKeySelective(Printer record);

    int updateByPrimaryKey(Printer record);
}