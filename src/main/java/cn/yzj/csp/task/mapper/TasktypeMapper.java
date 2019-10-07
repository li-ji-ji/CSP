package cn.yzj.csp.task.mapper;

import java.util.List;

import cn.yzj.csp.task.po.Tasktype;

public interface TasktypeMapper {
	int deleteByPrimaryKey(Integer tasktypeId);

	int insert(Tasktype record);

	int insertSelective(Tasktype record);

	Tasktype selectByPrimaryKey(Integer tasktypeId);

	int updateByPrimaryKeySelective(Tasktype record);

	int updateByPrimaryKey(Tasktype record);

	List<Tasktype> findTsakTypeAll();
	
	List<Tasktype> finTaskTypeByStatus(int typeStatus);
}