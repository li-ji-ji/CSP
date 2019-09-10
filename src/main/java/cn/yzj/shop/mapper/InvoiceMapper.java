package cn.yzj.shop.mapper;

import cn.yzj.shop.po.Invoice;
import cn.yzj.shop.po.InvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceMapper {
    int countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    int deleteByPrimaryKey(Integer invoiceId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    Invoice selectByPrimaryKey(Integer invoiceId);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}