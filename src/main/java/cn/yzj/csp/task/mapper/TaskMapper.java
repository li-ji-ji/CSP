package cn.yzj.csp.task.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.yzj.csp.task.po.Task;
import cn.yzj.csp.task.po.TaskExample;
import cn.yzj.csp.task.po.TaskWithBLOBs;

public interface TaskMapper {
	int countByExample(TaskExample example);

	int deleteByExample(TaskExample example);

	int deleteByPrimaryKey(Integer taskId);

	int insert(TaskWithBLOBs record);

	int insertSelective(TaskWithBLOBs record);

	List<TaskWithBLOBs> selectByExampleWithBLOBs(TaskExample example);

	List<Task> selectByExample(TaskExample example);

	TaskWithBLOBs selectByPrimaryKey(Integer taskId);

	int updateByExampleSelective(@Param("record") TaskWithBLOBs record, @Param("example") TaskExample example);

	int updateByExampleWithBLOBs(@Param("record") TaskWithBLOBs record, @Param("example") TaskExample example);

	int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

	int updateByPrimaryKeySelective(TaskWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(TaskWithBLOBs record);

	int updateByPrimaryKey(Task record);

	int insertReturnId(TaskWithBLOBs record);
}