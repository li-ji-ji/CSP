package cn.yzj.shop.mapper;

import cn.yzj.shop.po.WxImg;
import cn.yzj.shop.po.WxImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxImgMapper {
    int countByExample(WxImgExample example);

    int deleteByExample(WxImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxImg record);

    int insertSelective(WxImg record);

    List<WxImg> selectByExampleWithBLOBs(WxImgExample example);

    List<WxImg> selectByExample(WxImgExample example);

    WxImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxImg record, @Param("example") WxImgExample example);

    int updateByExampleWithBLOBs(@Param("record") WxImg record, @Param("example") WxImgExample example);

    int updateByExample(@Param("record") WxImg record, @Param("example") WxImgExample example);

    int updateByPrimaryKeySelective(WxImg record);

    int updateByPrimaryKeyWithBLOBs(WxImg record);

    int updateByPrimaryKey(WxImg record);
}