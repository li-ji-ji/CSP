package cn.lhj.csp.task.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lhj.csp.task.service.TaskSystem;
import cn.yzj.csp.task.po.LayUIJSON;
import cn.yzj.csp.task.po.Tasktype;

@RestController
public class TaskTypeApi {
	@Autowired
	private TaskSystem taskSystem;
	/*
	 * 通过任务类型状态查询任务类型列表
	 */
//	@ApiOperation(value = "通过任务类型状态查询任务类型列表",notes = "通过类任务型状态 type_stutas属性查询 返回一个 list")
	@RequestMapping("finTaskTypeByStatus")
	public List<Tasktype> finTaskTypeByStatus(@RequestParam("typeStatus")int typeStatus) throws Exception{
		return taskSystem.finTaskTypeByStatus(typeStatus);
	}
	 /*
     * 返回所有taskType
     */
//	@ApiOperation(value = "通过任务类型状态查询任务类型列表",notes = "返回所有taskType")
	@RequestMapping("/taskAdmin/TypeAdmin")
	public LayUIJSON<Object> findTaskTypeAll(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit) throws Exception{
		PageHelper.startPage(page, limit);
		 List<Tasktype> taskTypes=taskSystem.findTaskTypeAll();
		PageInfo<Tasktype> pageInfo=new PageInfo<Tasktype>(taskTypes);
		long count=pageInfo.getTotal();
		LayUIJSON<Object> uijson=new LayUIJSON<>();
		uijson.setCount((long)count);
		uijson.setDataWithTasks(taskTypes);
		return uijson;
	}
	/*
	 * 添加新的taskType
	 */
//	@ApiOperation(value = "添加新的任务类型",notes = "添加新的taskType 通过taskType对象")
	@RequestMapping("/taskAdmin/addTaskType")
	public boolean addTaskType(Tasktype tasktype) throws Exception {
		return taskSystem.addTaskType(tasktype);
	}
	 /*
     * 删除taskType属性
     */
//	@ApiOperation(value = "删除指定的任务类型",notes = "添加新的taskType 通过id属性")
	@RequestMapping("/taskAdmin/deleteTaskTypeByid")
	public boolean deleteTaskTypeByid(@RequestParam("TypeId")String TypeId) throws Exception {
		JSONArray array=JSONArray.parseArray(TypeId);
		ArrayList<Integer> TypeIds=new ArrayList<Integer>();
		for (Object item : array) {
			TypeIds.add((Integer) item);
		}
		return taskSystem.deleteTaskTypeByid(TypeIds);
	}
	 /*
     * 修改taskType
     */
//	@ApiOperation(value = "修改指定的任务类型",notes = "更新taskType属性 通过taskType对象")
	@RequestMapping("/taskAdmin/updateTaskTypeByid")
	public boolean updateTaskTypeByid(Tasktype tasktype) throws Exception {
		return taskSystem.updateTaskTypeByid(tasktype);
	}

}
