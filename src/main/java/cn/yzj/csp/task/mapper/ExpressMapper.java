package cn.yzj.csp.task.mapper;

import java.util.List;

import cn.yzj.csp.task.po.Express;

public interface ExpressMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Express record);

	int insertSelective(Express record);

	Express selectByPrimaryKey(Integer id);

	List<Express> selectBySuperiortaskId(List<Integer> ids);

	int updateByPrimaryKeySelective(Express record);

	int updateByPrimaryKey(Express record);

	int insertExpressList(List<Express> expresses);
	
	List<Express> findExpressAll() throws Exception;
}