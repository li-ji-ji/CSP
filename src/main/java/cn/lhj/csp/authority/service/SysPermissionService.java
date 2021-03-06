package cn.lhj.csp.authority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysPermissionExample;

public interface SysPermissionService {
	long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    
    List<SysPermission> select(int page,int limit);
}
