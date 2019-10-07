package cn.lhj.csp.task.api;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lhj.csp.task.service.TaskSystem;
import cn.yzj.csp.task.po.LayUIJSON;
import cn.yzj.csp.task.po.TaskDTO;
import cn.yzj.csp.task.po.TaskWithBLOBs;


@RestController
//@Api("csp-yzj-task:接口说明文档")
@CrossOrigin
public class TaskApi {

	@Autowired
	private TaskSystem taskSystem;
//	@ApiIgnore
//	@RequestMapping("/index")
//    public Task getTaskt() {
//	  Task task=mapper.selectByPrimaryKey(1);
//		return task;	
//    }
//	@Autowired
//	private WxPay wxpay;
	
//	@ApiOperation(value = "接受任务对象(task),发布任务",notes = "通过tsk对象返回是否成功")
	@RequestMapping("taskAdmin/PublishingTasks")//接受任务对象(task),发布任务 
	public boolean PublishingTasks(@RequestBody TaskWithBLOBs task) {
		return taskSystem.PublishingTasks(task);
	}
	/** 
	* @api {get} /displayTask/:id Request User information 
	* @apiName GetUser 
	* @apiGroup User 
	* 
	* @apiParam {String} id Users unique ID. 
	* 
	* @apiSuccess {String} firstname Firstname of the User. 
	* @apiSuccess {String} lastname Lastname of the User. 
	*/
//	@ApiOperation(value = "显示任务列表返回一个tasklist",notes = "通过任务状态(参数 status 0准备状态,1发布状态,2执行状态,3取消状态,4完成状态)")
	@RequestMapping("/displayTask")//显示任务列表,通过任务状态(status)
	public List<TaskWithBLOBs> displayTask(@RequestParam("taskStatus")int taskStatus) throws Exception{
		List<TaskWithBLOBs> tasks= taskSystem.displayTask(taskStatus);
		return tasks;
	}
	
//	@ApiOperation(value = "layui 前端接口",notes = "查询所有任务  无参数")
	@RequestMapping("/taskAdmin/index")//显示任务列表,通过任务状态(status)
	public LayUIJSON<Object> displayTaskWithLayui(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit) throws Exception{
		PageHelper.startPage(page, limit);
		List<TaskWithBLOBs> tasks= taskSystem.findTaskAll();
		PageInfo<TaskWithBLOBs> pageInfo=new PageInfo<TaskWithBLOBs>(tasks);
		long count=pageInfo.getTotal();
		LayUIJSON<Object> uijson=new LayUIJSON<>();
		uijson.setCount((long)count);
		ArrayList<Object> data=new ArrayList<>();
		for (TaskWithBLOBs object : tasks) {
			TaskDTO taskDTO=new TaskDTO();
			taskDTO.setTaskId(object.getTaskId());
			taskDTO.setOrderId(object.getOrderId());
			taskDTO.setTaskTitle(object.getTaskTitle());
			taskDTO.setTaskType(taskSystem.getTaskTypeNameById(object.getTaskType()));
			taskDTO.setTaskPublisher("张三");
			taskDTO.setTaskReceiver("李四");
			String taskStatus;
			switch (object.getTaskStatus()) {
			case 0:
				taskStatus="就绪状态";
				break;
			case 1:
				taskStatus="新发布状态";
				break;
			case 2:
				taskStatus="被接单状态";
				break;
			case 3:
				taskStatus="已完成状态";
				break;
			case 4:
				taskStatus="已结算状态";
				break;
			default:
				taskStatus="就绪状态";
				break;
			}
			taskDTO.setTaskStatus(taskStatus);
			taskDTO.setPublishTime(object.getPublishTime());
			taskDTO.setTaskReward((double)object.getTaskReward()/100);
			taskDTO.setTaskContext(object.getTaskContext());
			taskDTO.setTaskRemarks(object.getTaskRemarks());
			data.add(taskDTO);
		}
		uijson.setDataWithTasks(data);
		return uijson;
	}
	
//	@ApiOperation(value = "修改任务信息",notes = "通过tsk对象返回是否成功 Boolean")
	@RequestMapping("updateTask")//修改任务信息
	public boolean updateTask(TaskWithBLOBs task) throws Exception {
		return taskSystem.updateTask(task);
	}
//	@ApiOperation(value = "取消任务(准备状态下)",notes = "通过接收 要修改 task对象 返回是否成功 Boolean")
	@RequestMapping("cancelTask")//取消任务(准备状态下)
	public String cancelTask(@RequestParam("orderNo")String orderNo,@RequestParam("refundFee")int refundFee) throws Exception {

		return taskSystem.cancelTask(orderNo, refundFee);
		
	}
	/*
	 *接受任务
	 *发布状态1->执行状态2 
	 */
//	@ApiOperation(value = "接受任务对象,改变任务状态 发布状态1->执行状态2 ",notes = "通过接收 要修改 task对象 返回是否成功 Boolean")
	@RequestMapping("/acceptTask")
	public boolean acceptTask(@RequestParam("taskid")int taskid,@RequestParam("receiverid")int receiverid) throws Exception {
		return taskSystem.acceptTask(taskid,receiverid);
	}
	/*
	 * 
	 * 任务完成
	 * 执行状态2->完成状态4
	 */
//	@ApiOperation(value = "接受任务对象,改变任务状态 执行状态2->完成状态3 ",notes = "通过接收 要修改 task对象 返回是否成功 Boolean")
	@RequestMapping("finishTask")//取消任务(准备状态下)
	public boolean finishTask(TaskWithBLOBs task) throws Exception {
		return taskSystem.finishTask(task);
		
	}
	/*
	 * 
	 * 通过任务发布者查询任务列表
	 */
//	@ApiOperation(value = "显示任务列表返回一个tasklist",notes = "通过发布者id taskByPublisher")
	@RequestMapping("/taskByPublisher")
	public List<TaskWithBLOBs> taskByPublisher(@RequestParam("taskByPublisher")int taskByPublisher) throws Exception {
		
		return taskSystem.taskByPublisher(taskByPublisher);
	}
	
	/*
	 * 
	 * 通过任务接受者查询任务列表
	 */
//	@ApiOperation(value = "显示任务列表返回一个tasklist",notes = "通过接受者id taskByReceiver")
	@RequestMapping("taskByReceiver")
	public List<TaskWithBLOBs> taskByReceiver(@RequestParam("taskByReceiver")int taskByReceiver) throws Exception {
		
		return taskSystem.taskReceiver(taskByReceiver);
	}
	
	@RequestMapping("/insertReturnId")
	public int  insertReturnId(TaskWithBLOBs task) throws Exception {
		
		return taskSystem.insertReturnId(task);
		
	}
	/*
	 * 通过状态,查询不属于status
	 */
	@RequestMapping("/displayTaskAll")
	public List<TaskWithBLOBs> displayTaskAll(@RequestParam("status")int status) throws Exception{
		return taskSystem.displayTaskAll(status);
	}

	@RequestMapping("/placeOrder")
	public String placeOrder(HttpServletRequest request,@RequestParam("openid")String openid,@RequestParam("data")String data,@RequestParam("reward")int reward,HttpServletResponse response)throws Exception{
		String ip="127.0.0.1";
		if (request.getHeader("x-forwarded-for") == null) {  
			ip=request.getRemoteAddr();
	    } else {
	    	ip=request.getHeader("x-forwarded-for");
		}
		System.out.println(ip);
		ip=ip+", 47.106.220.247";
		ip=ip.substring(0,ip.indexOf(","));
		System.out.println(ip);
	    return taskSystem.placeOrder(openid,data,ip,reward);  
	}

	/*
	 * 微信支付的回调处理接口
	 */
	@RequestMapping("/notify_url")
	public String notify_url(HttpServletRequest request) throws Exception {
		BufferedReader reader = request.getReader();
		String line = "";
		StringBuffer inputString = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			inputString.append(line);
		}
		request.getReader().close();
		System.out.println(inputString.toString());
		return taskSystem.notify_url(inputString.toString());
	}
	/**
	 * 
	 * 订单再支付接口
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payAgain")
	public String payAgain(@RequestParam("orderNo")String orderNo)throws Exception{
		return taskSystem.payAgain(orderNo);
	}
	/**
	 * 退款成功回调接口
	 */
	public String refund_url(HttpServletRequest request)throws Exception{
		BufferedReader reader = request.getReader();
		String line = "";
		StringBuffer inputString = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			inputString.append(line);
		}
		request.getReader().close();
		System.out.println(inputString.toString());
		return taskSystem.refund_url(inputString.toString());
	}
	/**
	 * 任务结算
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/confirm")
	public boolean confirm(@RequestParam("taskId")int taskId) throws Exception {
		return taskSystem.confirm(taskId);
	}
	/**
	 * 
	 * 查询钱包是否存在,不存在则添加钱包
	 * @throws Exception 
	 */
	@RequestMapping("/getWallet")
	public String getWallet(@RequestParam("openid")String openid,@RequestParam("id") int id,@RequestParam("name")String name) throws Exception {
		return taskSystem.getWallet(openid,id,name);
	}
	/*
	 * 删除接口
	 */
	@RequestMapping("/taskAdmin/delete")
	public boolean deleteTaskById(@RequestParam("taskId")String taskId) throws Exception {
		JSONArray array=JSONArray.parseArray(taskId);
		ArrayList<Integer> taskid=new ArrayList<Integer>();
		for (Object item : array) {
			taskid.add((Integer) item);
		}
		return taskSystem.deleteTaskById(taskid);
	}
	/*
	 * 更新字段
	 */
	@RequestMapping("/taskAdmin/updata")
	public boolean updataTask(@RequestBody TaskWithBLOBs task) throws Exception {
		return taskSystem.updateByTask(task);
	}
	@RequestMapping("/hello")
	public String hello(@RequestParam("name")String name) {
		return "hello"+name;
	}
	
}
