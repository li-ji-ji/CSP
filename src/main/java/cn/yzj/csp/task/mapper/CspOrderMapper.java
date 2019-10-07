package cn.yzj.csp.task.mapper;

import cn.yzj.csp.task.po.CspOrder;

public interface CspOrderMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CspOrder record);

	int insertSelective(CspOrder record);

	CspOrder selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CspOrder record);

	int updateByPrimaryKey(CspOrder record);

	CspOrder selectByOrderNo(String orderNo);

	int updateByOrderNoSelective(CspOrder record);
}