package cn.lhj.csp.fileinfo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.po.FolderInfoExample;

public interface FolderInfoMapper {
    int countByExample(FolderInfoExample example);

    int deleteByExample(FolderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FolderInfo record);

    int insertSelective(FolderInfo record);

    List<FolderInfo> selectByExample(FolderInfoExample example);

    FolderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FolderInfo record, @Param("example") FolderInfoExample example);

    int updateByExample(@Param("record") FolderInfo record, @Param("example") FolderInfoExample example);

    int updateByPrimaryKeySelective(FolderInfo record);

    int updateByPrimaryKey(FolderInfo record);
}