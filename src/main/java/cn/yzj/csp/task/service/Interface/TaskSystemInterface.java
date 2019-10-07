package cn.yzj.csp.task.service.Interface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yzj.csp.task.po.TaskWithBLOBs;
import cn.yzj.csp.task.po.Tasktype;

@Service
public interface TaskSystemInterface {
	/*
	 * 0.准备状态 1.发布状态 2.执行状态 3.取消状态 4.完成状态 发布任务 由准备状态0->发布状态1
	 */
	public boolean PublishingTasks(TaskWithBLOBs task) throws Exception;

	/*
	 * 显示任务列表
	 */
	public List<TaskWithBLOBs> displayTask(int status) throws Exception;

	/**
	 * 修改任务信息
	 * 
	 * @throws Exception
	 */
	public boolean updateTask(TaskWithBLOBs task) throws Exception;

	/*
	 * 取消任务(准备状态) 发布状态1->取消状态3
	 */
//	public boolean cancelTask(TaskWithBLOBs task) throws Exception;

	/*
	 * 接受任务 发布状态1->执行状态2
	 */
	public boolean acceptTask(int taskid, int receiverid) throws Exception;

	/*
	 * 
	 * 任务完成 执行状态2->完成状态4
	 */
	public boolean finishTask(TaskWithBLOBs task) throws Exception;

	/*
	 * 我发布的任务 通过任务发布者 taskPublisher查询任务列表
	 */
	public List<TaskWithBLOBs> taskByPublisher(int taskPublisher) throws Exception;

	/*
	 * 我接受的任务 通过任务接受者 taskReceiver查询任务列表
	 */
	public List<TaskWithBLOBs> taskReceiver(int taskReceiver) throws Exception;
	/*
	 * 通过id查询taskType
	 */
	public String getTaskTypeNameById(int tasktypeId) throws Exception;
	/*
	 * 查询所有指定状态的taskType
	 */
	public List<Tasktype> finTaskTypeByStatus(int typeStatus) throws Exception;

	/*
	 * 返回所有taskType
	 */
	public List<Tasktype> findTaskTypeAll() throws Exception;

	/*
	 * 添加新的taskType
	 */
	public boolean addTaskType(Tasktype tasktype) throws Exception;

	/*
	 * 删除taskType属性
	 */
	public boolean deleteTaskTypeByid(ArrayList<Integer> TypeId) throws Exception;

	/*
	 * 修改taskType
	 */
	public boolean updateTaskTypeByid(Tasktype tasktype) throws Exception;

	/*
	 * 插入task 返回id
	 */
	public int insertReturnId(TaskWithBLOBs task) throws Exception;

	/*
	 * 显示所有非准备状态的task
	 * 
	 */
	public List<TaskWithBLOBs> displayTaskAll(int stasus) throws Exception;

	/*
	 * 查询所有 状态的任务 不带参数
	 */
	public List<TaskWithBLOBs> findTaskAll() throws Exception;

	/*
	 * 删除任务 通过id
	 */
	public boolean deleteTaskById(ArrayList<Integer> taskId) throws Exception;
	/*
	 * 更新字段 task
	 */
	public boolean updateByTask(TaskWithBLOBs task) throws Exception;
	/*
	 * 统一下单接口
	 */
	public String placeOrder(String openid,String data,String ip, int total_fee)throws Exception;
	/**
	 * 支付成功回调接口
	 * 更新订单状态
	 * 完成下单业务
	 */
	public String notify_url(String data)throws Exception;
	/*
	 * 
	 * 取消订单接口
	 */
	public String cancelTask(String out_trade_no,int total_fee )throws Exception;
	
	/*
	 * 
	 * 提现
	 */
	public String withdrawal(int receiverId,String openid,String name,int amount,String ip)throws Exception;
	/*
	 * 确认完成任务(任务结算)
	 * 
	 */
	public boolean confirm(int taskId)throws Exception;
	/**
	 * 退款成功回调接口
	 */
	public String refund_url(String data)throws Exception;
	/**
	 * 
	 * 查询钱包是否存在,不存在则添加钱包
	 */
	public String getWallet(String openid,int id,String name)throws Exception;
	/**
	 *  支付再调起
	 */
	public String payAgain(String orderNo)throws Exception;
}
