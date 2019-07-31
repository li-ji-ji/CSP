package cn.lhj.csp.task.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.task.feign.TaskFeign;
import cn.lhj.csp.task.po.LayUIJSON;
import cn.lhj.csp.task.po.TaskWithBLOBs;
import cn.lhj.csp.task.po.Tasktype;


@RestController
@RequestMapping("/taskAdmin")
@CrossOrigin
public class TaskApi {
	@Autowired
	TaskFeign taskFeign;
	
	@RequestMapping("/index")
	public LayUIJSON<Object> index(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit){
		return taskFeign.displayTaskWithLayui(page, limit);
	}
	
	@RequestMapping("/addTask")
	public int PublishingTasks(TaskWithBLOBs task) {
		int num=taskFeign.PublishingTasks(task);
		return num;
	}
	@RequestMapping("/delete")
	public boolean deleteTaskById(@RequestParam("taskId")String taskId) {
		return taskFeign.deleteTaskById(taskId);
	}
	@RequestMapping("/updata")
	public boolean updataTask(TaskWithBLOBs task) {
		return taskFeign.updataTask(task);
	}
	@RequestMapping("/findExpressByPid")//查询快递信息接口
	public LayUIJSON<Object> findExpressByPid(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit,@RequestParam("pId")String pId){
		return taskFeign.findExpressByPid(page, limit, pId);
	}
	@RequestMapping("/TypeAdmin")//查询raskType接口
	public LayUIJSON<Object> findTaskTypeAll(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit){
		return taskFeign.findTaskTypeAll(page, limit);
	}
	@RequestMapping("/addTaskType")//添加任务类型接口
	public boolean addTaskType(Tasktype tasktype) {
		return taskFeign.addTaskType(tasktype);
	}
	@RequestMapping("deleteTaskTypeByid")
	public boolean deleteTaskTypeByid(@RequestParam("TypeId")String TypeId){
		return taskFeign.deleteTaskTypeByid(TypeId);
	}
	@RequestMapping("updateTaskTypeByid")
	public boolean updateTaskTypeByid(Tasktype tasktype) {
		return taskFeign.updateTaskTypeByid(tasktype);	
	}
	
}
