package cn.lhj.csp.task.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.task.po.LayUIJSON;
import cn.lhj.csp.task.po.TaskWithBLOBs;
import cn.lhj.csp.task.po.Tasktype;

@FeignClient(name="csp-task")
public interface TaskFeign {
	
	@RequestMapping(value = "/displayTaskWithLayui")//分页查询接口返回所有
	public LayUIJSON<Object> displayTaskWithLayui(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit);
	
	@RequestMapping("/PublishingTasks")//添加接口 
	public int PublishingTasks(TaskWithBLOBs task);
	
	@RequestMapping("/deleteTaskById")//删除接口
	public boolean deleteTaskById(@RequestParam("taskId")String taskId);
	
	@RequestMapping("/updataTask")//修改接口
	public boolean updataTask(TaskWithBLOBs task);
	
	@RequestMapping("findExpressByPid")//查询快递信息接口
	public LayUIJSON<Object> findExpressByPid(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit,@RequestParam("pId")String pId);
	
	
	@RequestMapping("findTaskTypeAll")//查询raskType接口
	public LayUIJSON<Object> findTaskTypeAll(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit);
	
	@RequestMapping("/addTaskType")//添加任务类型接口
	public boolean addTaskType(Tasktype tasktype);
	
	@RequestMapping("deleteTaskTypeByid")
	public boolean deleteTaskTypeByid(@RequestParam("TypeId")String TypeId);
	
	@RequestMapping("updateTaskTypeByid")
	public boolean updateTaskTypeByid(Tasktype tasktype);
}
