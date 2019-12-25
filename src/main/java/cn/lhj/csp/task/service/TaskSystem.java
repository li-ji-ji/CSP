package cn.lhj.csp.task.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.yzj.csp.task.mapper.CspOrderMapper;
import cn.yzj.csp.task.mapper.CspWalletMapper;
import cn.yzj.csp.task.mapper.TaskMapper;
import cn.yzj.csp.task.mapper.TasktypeMapper;
import cn.yzj.csp.task.po.CspOrder;
import cn.yzj.csp.task.po.CspWallet;
import cn.yzj.csp.task.po.PayPram;
import cn.yzj.csp.task.po.RefundDTO;
import cn.yzj.csp.task.po.TaskExample;
import cn.yzj.csp.task.po.TaskWithBLOBs;
import cn.yzj.csp.task.po.Tasktype;
import cn.yzj.csp.task.po.WithdrawalDTO;
import cn.yzj.csp.task.service.Interface.TaskSystemInterface;
import cn.yzj.csp.task.util.WXPayMapUtil;
import cn.yzj.csp.task.util.WXPayUtil;
import cn.yzj.csp.task.util.WxConfig;
import cn.yzj.csp.task.util.WxPay;
import net.sf.json.JSONObject;

@Service
public class TaskSystem implements TaskSystemInterface {
	@Autowired
	private TaskMapper mapper;

	@Autowired
	private TasktypeMapper typeMapper;
	@Autowired
	private CspOrderMapper orderMapper;
	@Autowired
	private CspWalletMapper cspWalletMapper;

	/*
	 * 
	 * 发布任务
	 */
	@Transactional
	public boolean PublishingTasks(TaskWithBLOBs task) {
		/*
		 * 判断任务状态 0.取消状态 1.发布状态 2.被接单状态 3.已完成状态 4.已结算状态
		 */
		/*
		 * 将准备状态的任务转换成发布状态 0->1
		 */
		boolean isOk = false;

		/*
		 * 判断任务是否为准备状态 并将结果返回 boole类型
		 */
		if (task.getTaskStatus() == 0 || task.getTaskStatus() == null) {

			task.setTaskStatus(1);
			if(mapper.insertSelective(task)>0) {
				isOk=true;
			}
		}

		return isOk;
	}

	/*
	 * 显示任务列表 status 根据任务状态查询任务列表
	 */
	@Transactional
	public List<TaskWithBLOBs> displayTask(int status) throws Exception {
		List<TaskWithBLOBs> tasks = new ArrayList<TaskWithBLOBs>();
		TaskExample example = new TaskExample();
		example.createCriteria().andTaskStatusEqualTo(status);
		tasks = mapper.selectByExampleWithBLOBs(example);
		return tasks;
	}

	/**
	 * 修改任务信息
	 */

	@Override
	@Transactional
	public boolean updateTask(TaskWithBLOBs task) throws Exception {
		boolean isOk = false;
		int k = mapper.updateByPrimaryKeySelective(task);
		if (k > 0) {
			isOk = true;
		}
		return isOk;
	}
	/*
	 * 取消任务(准备状态) 发布状态1(已接单状态)->取消状态0
	 */

//	@Override
//	@Transactional
//	public boolean cancelTask(TaskWithBLOBs task) throws Exception {
//		boolean isOk = false;
//		if (task.getTaskStatus() == 1 || task.getTaskStatus() == 2) {
//			task.setTaskStatus(0);
//			if (mapper.updateByPrimaryKeySelective(task) > 0) {
//				isOk = true;
//			}
//		}
//		return isOk;
//
//	}
	/*
	 * 
	 * 接受任务 发布状态1->执行状态2
	 */

	@Override
	@Transactional
	public boolean acceptTask(int taskid, int receiverid) throws Exception {
		boolean isOk = false;
		TaskWithBLOBs task = mapper.selectByPrimaryKey(taskid);
		if (task.getTaskStatus() == 1) {
			task.setTaskStatus(2);
			task.setTaskReceiver(receiverid);
			if (mapper.updateByPrimaryKey(task) > 0) {
				CspOrder order = new CspOrder();
				order = orderMapper.selectByOrderNo(task.getOrderId());
				order.setUpdateTime(WXPayUtil.getNewTime());
				order.setReceiver(task.getTaskReceiver());
				orderMapper.updateByPrimaryKeySelective(order);
				isOk = true;
			}
		}
		return isOk;
	}
	/*
	 * 
	 * 任务完成 执行状态2->完成状态3
	 */

	@Override
	@Transactional
	public boolean finishTask(TaskWithBLOBs task) throws Exception {
		boolean isOk = false;
		if (task.getTaskStatus() == 2) {
			task.setTaskStatus(3);
			if (mapper.updateByPrimaryKeySelective(task) > 0) {
				CspOrder order = new CspOrder();
				order = orderMapper.selectByOrderNo(task.getOrderId());
				order.setUpdateTime(WXPayUtil.getNewTime());
				order.setStatus(2);
				orderMapper.updateByPrimaryKeySelective(order);
				isOk = true;
			}
		}
		return isOk;
	}

	/*
	 * 我发布的任务 通过任务发布者 taskPublisher查询任务列表
	 */
	@Override
	@Transactional
	public List<TaskWithBLOBs> taskByPublisher(int taskPublisher) throws Exception {
		List<TaskWithBLOBs> tasks = new ArrayList<TaskWithBLOBs>();
		TaskExample example = new TaskExample();
		example.setOrderByClause("task_id DESC");
		example.createCriteria().andTaskPublisherEqualTo(taskPublisher);
		tasks = mapper.selectByExampleWithBLOBs(example);
		return tasks;
	}

	/*
	 * 我接受的任务 通过任务接受者 taskReceiver查询任务列表
	 */
	@Override
	@Transactional
	public List<TaskWithBLOBs> taskReceiver(int taskReceiver) throws Exception {
		List<TaskWithBLOBs> tasks = new ArrayList<TaskWithBLOBs>();
		TaskExample example = new TaskExample();
		example.setOrderByClause("task_id DESC");
		example.createCriteria().andTaskReceiverEqualTo(taskReceiver);
		tasks = mapper.selectByExampleWithBLOBs(example);
		return tasks;
	}

	/*
	 * 查询所有激活状态的taskType
	 */
	@Override
	@Transactional
	public List<Tasktype> finTaskTypeByStatus(int typeStatus) throws Exception {
		List<Tasktype> tasktypes = new ArrayList<Tasktype>();
		tasktypes = typeMapper.finTaskTypeByStatus(typeStatus);
		return tasktypes;
	}

	/*
	 * 返回所有的taskType
	 */
	@Override
	@Transactional
	public List<Tasktype> findTaskTypeAll() throws Exception {
		List<Tasktype> tasktypes = new ArrayList<Tasktype>();
		tasktypes = typeMapper.findTsakTypeAll();
		return tasktypes;
	}

	/*
	 * 添加新的taskType
	 */
	@Override
	public boolean addTaskType(Tasktype tasktype) throws Exception {
		boolean isOk = false;
		int k = typeMapper.insertSelective(tasktype);
		if (k > 0) {
			isOk = true;
		}
		return isOk;
	}

	/*
	 * 删除taskType属性
	 */
	@Override
	public boolean deleteTaskTypeByid(ArrayList<Integer> TypeId) throws Exception {
		boolean isOk = false;
		int k;
		for (Integer integer : TypeId) {
			k = typeMapper.deleteByPrimaryKey(integer);
			if (k > 0) {
				isOk = true;
			}
		}
		return isOk;
	}

	/*
	 * 修改taskType
	 */
	@Override
	public boolean updateTaskTypeByid(Tasktype tasktype) throws Exception {
		boolean isOk = false;
		int k = typeMapper.updateByPrimaryKeySelective(tasktype);
		if (k > 0) {
			isOk = true;
		}
		return isOk;
	}

	@Override
	public int insertReturnId(TaskWithBLOBs task) throws Exception {
		int isId = 0;
		mapper.insertReturnId(task);
		isId = task.getTaskId();
		return isId;
	}

	@Override
	public List<TaskWithBLOBs> displayTaskAll(int status) throws Exception {
		// TODO 自动生成的方法存根
		List<TaskWithBLOBs> taskWithBLOBs = new ArrayList<TaskWithBLOBs>();
		TaskExample example = new TaskExample();
		example.setOrderByClause("task_id DESC");
		example.createCriteria().andTaskStatusNotEqualTo(status).andTaskStatusNotEqualTo(5);
		taskWithBLOBs = mapper.selectByExampleWithBLOBs(example);
		return taskWithBLOBs;
	}

	/*
	 * 查询所有不带参数
	 */
	@Override
	public List<TaskWithBLOBs> findTaskAll() throws Exception {
		List<TaskWithBLOBs> withBLOBs = new ArrayList<TaskWithBLOBs>();
		withBLOBs = mapper.selectByExampleWithBLOBs(null);
		return withBLOBs;
	}

	public String getPrepayId(String code, String ip, int total_fee) throws Exception {
		String Openid = null;
		WxPay pay = new WxPay();
		Openid = pay.getPrepayId(code, ip, total_fee);
		return Openid;

	}

	/*
	 * 删除task 通过id
	 */
	@Override
	public boolean deleteTaskById(ArrayList<Integer> taskId) throws Exception {
		boolean isOk = false;
		for (Integer integer : taskId) {
			int k = mapper.deleteByPrimaryKey(integer);
			if (k > 0) {
				isOk = true;
			}
		}
		return isOk;
	}

	/*
	 * 更新字段
	 */
	@Override
	public boolean updateByTask(TaskWithBLOBs task) throws Exception {
		boolean isOk = false;
		if (mapper.updateByPrimaryKeySelective(task) > 0) {
			isOk = true;
		}
		return isOk;
	}

	/*
	 * 通过主键查询taskType 名称
	 */
	@Override
	public String getTaskTypeNameById(int tasktypeId) throws Exception {
		String typeName = null;
		typeName = typeMapper.selectByPrimaryKey(tasktypeId).getTasktypeName();
		return typeName;
	}

	/*
	 * 统一下单接口
	 * 参数:
	 * openid(用户唯一标识)
	 * data(订单信息)
	 * ip(请求方ip)
	 * total_fee(金额)
	 * 返回签名后的支付参数
	 */
	@Override
	@Transactional
	public String placeOrder(String openid, String data, String ip, int total_fee) throws Exception {
		WxConfig wxConfig = new WxConfig();
		String key = wxConfig.getKey();
		JSONObject object = JSONObject.fromObject(data);
		
		String isOK = "{code:FAIl}";
		RestTemplate restTemplate = new RestTemplate();
		PayPram payPram = new PayPram();
		payPram.setAppid(wxConfig.getAppid());
		payPram.setMch_id(wxConfig.getMch_id());
		payPram.setNonce_str(WXPayUtil.generateNonceStr());
		payPram.setSpbill_create_ip(ip);
		payPram.setTotal_fee(total_fee);
		payPram.setOut_trade_no(WXPayUtil.generateNonceStr());
		payPram.setOpenid(openid);
		// 设置请求参数
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("appid", payPram.getAppid());
		paraMap.put("mch_id", payPram.getMch_id());
		paraMap.put("nonce_str", payPram.getNonce_str());
		paraMap.put("trade_type", payPram.getTrade_type());
		paraMap.put("notify_url", payPram.getNotify_url());
		paraMap.put("spbill_create_ip", payPram.getSpbill_create_ip());
		paraMap.put("total_fee", String.valueOf(payPram.getTotal_fee()));
		paraMap.put("out_trade_no", payPram.getOut_trade_no());
		paraMap.put("body", payPram.getBody());
		paraMap.put("openid", payPram.getOpenid());

		// 请求统一下单接口获取prepayId等数据
		String getxml = WXPayUtil.generateSignedXml(paraMap, key);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		getxml = restTemplate.postForObject("https://api.mch.weixin.qq.com/pay/unifiedorder", getxml, String.class);
		Map<String, String> getMap = WXPayUtil.xmlToMap(getxml);
		// 解析数据并签名返回Json字符串
		if (getMap.get("return_code").equals("SUCCESS") && getMap.get("result_code").equals("SUCCESS")) {
			TaskWithBLOBs taskWithBLOBs = new TaskWithBLOBs();
			if (object.getInt("taskType") == 2) {
				taskWithBLOBs.setImages(object.getString("images"));
			} else {
				
			}
			taskWithBLOBs.setPublishTime(WXPayUtil.getNewTime());
			taskWithBLOBs.setPublisherName(object.getString("publisherName"));
			taskWithBLOBs.setPublisherNumber(object.getString("publisherNumber"));
			taskWithBLOBs.setTaskRemarks(object.getString("taskRemarks"));
			taskWithBLOBs.setTaskContext(object.getString("taskContext"));
			taskWithBLOBs.setTaskPublisher(object.getInt("taskPublisher"));
			taskWithBLOBs.setTaskReward(object.getInt("taskReward"));
			taskWithBLOBs.setTaskStatus(object.getInt("taskStatus"));
			taskWithBLOBs.setTaskTitle(object.getString("taskTitle"));
			taskWithBLOBs.setTaskType(object.getInt("taskType"));
			taskWithBLOBs.setOrderId(paraMap.get("out_trade_no"));
			taskWithBLOBs.setPrepayId(getMap.get("prepay_id"));
			mapper.insertSelective(taskWithBLOBs);
			CspOrder order = new CspOrder();
			order.setOrderNo(paraMap.get("out_trade_no"));
			order.setTotalFee(object.getInt("taskReward"));
			order.setCreateTime(WXPayUtil.getNewTime());
			order.setUpdateTime(order.getCreateTime());
			order.setPayer(object.getInt("taskPublisher"));
			order.setCommission(order.getTotalFee()/5);
			order.setSettlementFee(order.getTotalFee()-order.getCommission());
			orderMapper.insertSelective(order);
			Map<String, String> apiMap = new HashMap<String, String>();
			apiMap.put("package", "prepay_id=" + getMap.get("prepay_id"));
			apiMap.put("appId", payPram.getAppid());
			apiMap.put("timeStamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
			apiMap.put("nonceStr", WXPayUtil.generateNonceStr());
			apiMap.put("signType", "MD5");
			apiMap.put("paySign", WXPayUtil.generateSignature(apiMap, key));
			apiMap.put("code", "SUCCESS");
			new JSONObject();
			return JSONObject.fromObject(apiMap).toString();
		} else {
			isOK = getMap.get("err_code_des");
		}
		return isOK;
	}

	/**
	 * 支付成功回调接口 更新订单状态 完成下单业务
	 * 
	 * @throws Exception
	 * 参数:
	 * data(通知内容)
	 * 返回String 通知处理完成
	 */
	@Transactional
	public String notify_url(String data) throws Exception {
		WxConfig config = new WxConfig();
		String key = config.getKey();
		String isok = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		Map<String, String> map = new HashMap<String, String>();
		map = WXPayUtil.xmlToMap(data);
		System.out.println(map.get("result_code"));
		if (WXPayUtil.isSignatureValid(data, key)) {

			if (map.get("result_code").equals("SUCCESS") && map.get("return_code").equals("SUCCESS")) {
				TaskExample example = new TaskExample();
				example.createCriteria().andOrderIdEqualTo(map.get("out_trade_no"));
				List<TaskWithBLOBs> taskWithBLOBs = new ArrayList<TaskWithBLOBs>();
				taskWithBLOBs = mapper.selectByExampleWithBLOBs(example);
				if (taskWithBLOBs.size() > 0) {

					if (taskWithBLOBs.get(0).getTaskReward().toString().equals(map.get("total_fee"))) {
						if (taskWithBLOBs.get(0).getTaskStatus() == 0) {
							CspOrder order = new CspOrder();
							order = orderMapper.selectByOrderNo(map.get("out_trade_no"));
							order.setUpdateTime(WXPayUtil.getNewTime());
							order.setStatus(1);
							orderMapper.updateByPrimaryKeySelective(order);
							taskWithBLOBs.get(0).setTaskStatus(1);
							mapper.updateByPrimaryKeySelective(taskWithBLOBs.get(0));
							isok = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
						}
					}
				}
			}
		} else {
			isok = map.get("err_code_des");
		}
		return isok;
	}

	/*
	 * 
	 * 退款接口
	 * 参数:
	 * out_trade_no(商户支付订单唯一标识)
	 * total_fee(退款金额)
	 * 返回String (joson格式的退款结果信息 )
	 */
	@Transactional
	public String cancelTask(String out_trade_no, int total_fee) throws Exception {
		String isOK = "{code:FAIl}";
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		RestTemplate restTemplate = new RestTemplate();
		WxConfig wxConfig = new WxConfig();
		String key = wxConfig.getKey();
		RefundDTO refundDTO = new RefundDTO();
		refundDTO.setAppid(wxConfig.getAppid());
		refundDTO.setMch_id(wxConfig.getMch_id());
		refundDTO.setNonce_str(WXPayUtil.generateNonceStr());
		refundDTO.setOut_refund_no(WXPayUtil.generateNonceStr());
		refundDTO.setOut_trade_no(out_trade_no);
		refundDTO.setRefund_fee(total_fee);
		refundDTO.setTotal_fee(total_fee);
		Map<String, String> map = WXPayMapUtil.entityToMap(refundDTO);
		String xmlStr = WXPayUtil.generateSignedXml(map, key);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		xmlStr = WXPayUtil.TransferRestTemplate(url, xmlStr);//使用证书的SSL请求方法
		map = WXPayUtil.xmlToMap(xmlStr);
		System.out.println(map.get("return_code"));
		if (map.get("return_code").equals("SUCCESS") && map.get("result_code").equals("SUCCESS")) {
			TaskExample example = new TaskExample();
			example.createCriteria().andOrderIdEqualTo(map.get("out_trade_no"));
			TaskWithBLOBs taskWithBLOBs = mapper.selectByExampleWithBLOBs(example).get(0);
			if (taskWithBLOBs.getTaskStatus() == 1 || taskWithBLOBs.getTaskStatus() == 2) {
				CspOrder order = new CspOrder();
				order = orderMapper.selectByOrderNo(taskWithBLOBs.getOrderId());
				order.setUpdateTime(WXPayUtil.getNewTime());
				order.setStatus(4);
				orderMapper.updateByPrimaryKeySelective(order);
				taskWithBLOBs.setTaskStatus(5);
				mapper.updateByPrimaryKeySelective(taskWithBLOBs);
			}
			isOK = "{code:SUCCESS}";
		} else {
			isOK = map.get("err_code_des");
		}
		return isOK;
	}

	/*
	 * 
	 * 提现
	 * receiverId(提现者id)
	 * openid(用户唯一标识)
	 * name(提现者真实姓名)
	 * amount(提现金额)
	 * ip(提现者ip地址)
	 */
	@Transactional
	public String withdrawal(int receiverId, String openid, String name, int amount, String ip) throws Exception {
		String isOk = "{code:FAIl}";
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
		WxConfig wxConfig = new WxConfig();
		WithdrawalDTO withdrawalDTO = new WithdrawalDTO();
		withdrawalDTO.setMch_appid(wxConfig.getAppid());
		withdrawalDTO.setMchidL(wxConfig.getMch_id());
		withdrawalDTO.setNonce_str(WXPayUtil.generateNonceStr());
		withdrawalDTO.setPartner_trade_no(WXPayUtil.generateNonceStr());
		withdrawalDTO.setOpenid(openid);
		withdrawalDTO.setCheck_name(name);
		withdrawalDTO.setAmount(amount);
		withdrawalDTO.setSpbill_create_ip(ip);
		Map<String, String> map = new HashMap<String, String>();
		map = WXPayMapUtil.entityToMap(withdrawalDTO);
		String xmlStr = WXPayUtil.generateSignedXml(map, wxConfig.getKey());
		xmlStr = WXPayUtil.TransferRestTemplate(url, xmlStr);//使用证书的SSL请求方法
		map = WXPayUtil.xmlToMap(xmlStr);
		if (map.get("return_code").equals("SUCCESS") && map.get("result_code").equals("SUCCESS")) {
			CspOrder order = new CspOrder();
			order.setOrderNo(map.get("partner_trade_no"));
			order.setTransactionId(map.get("payment_no"));
			order.setTotalFee(withdrawalDTO.getAmount());
			order.setStatus(3);
			order.setCreateTime(map.get("payment_time"));
			order.setUpdateTime(map.get("payment_time"));
			order.setPayer(0);
			order.setReceiver(receiverId);
			orderMapper.insertSelective(order);
			isOk = "{code:SUCCESS}";
		} else {
			isOk = map.get("err_code_des");
		}
		return isOk;
	}

	/**
	 * 
	 * 确认完成
	 */
	@Transactional
	public boolean confirm(int taskId) throws Exception {
		boolean isOk = false;
		TaskWithBLOBs taskWithBLOBs = new TaskWithBLOBs();
		taskWithBLOBs = mapper.selectByPrimaryKey(taskId);
		if (taskWithBLOBs.getTaskStatus() == 3) {
			taskWithBLOBs.setTaskStatus(4);
			if (mapper.updateByPrimaryKeySelective(taskWithBLOBs) > 0) {
				CspOrder order = new CspOrder();
				order = orderMapper.selectByOrderNo(taskWithBLOBs.getOrderId());
				order.setUpdateTime(WXPayUtil.getNewTime());
				order.setStatus(3);
				orderMapper.updateByPrimaryKeySelective(order);
				CspWallet wallet=cspWalletMapper.selectByPrimaryKeyLock(taskWithBLOBs.getTaskReceiver());
				wallet.setTotal(wallet.getTotal()+order.getSettlementFee());
				wallet.setDeposits(WXPayUtil.base64Str(wallet.getSalt(),WXPayUtil.getDeposits(wallet.getDeposits(),wallet.getSalt())+order.getSettlementFee()));
				if(cspWalletMapper.updateByPrimaryKeySelective(wallet)>0) {
					isOk = true;
				}
			}

		}
		return isOk;
	}

	/**
	 * 退款成功回调接口
	 */
	@Transactional
	public String refund_url(String data) throws Exception {
		String isok = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		Decoder decoder=Base64.getDecoder();
		byte[] bt=decoder.decode(data);
		String code=bt.toString();
		return isok;
	}
	/**
	 * 
	 * 查询钱包是否存在,不存在则添加钱包
	 * @throws Exception 
	 */
	@Transactional
	public String getWallet(String openid,int id,String name) throws Exception {
		String isOk="fail";
		CspWallet wallet=null;
		wallet=cspWalletMapper.selectByOpenid(openid);
		if(wallet!=null) {
		    Map<String, String> map=new HashMap<String, String>();
		    map.put("total",wallet.getTotal().toString());
		    map.put("deposits",String.valueOf(WXPayUtil.getDeposits(wallet.getDeposits(),wallet.getSalt())));
		   isOk=com.alibaba.fastjson.JSON.toJSONString(map);
		}else {
			wallet=new CspWallet();
			wallet.setOpenid(openid);
			wallet.setStudentId(id);
			wallet.setName(name);
			wallet.setSalt(WXPayUtil.generateNonceStr());
			cspWalletMapper.insertSelectiveReturnId(wallet);
			wallet=cspWalletMapper.selectByPrimaryKey(wallet.getId());
			Map<String, String> map=new HashMap<String, String>();
		    map.put("total",wallet.getTotal().toString());
		    map.put("deposits",String.valueOf(WXPayUtil.getDeposits(wallet.getDeposits(),wallet.getSalt())));
		   isOk=com.alibaba.fastjson.JSON.toJSONString(map);
		}
		return isOk;
	}

	@Transactional
	public String payAgain(String orderNo) throws Exception {
		String isOk="fail";
		WxConfig config=new WxConfig();
		List<TaskWithBLOBs> taskWithBLOBs=new ArrayList<TaskWithBLOBs>();
		TaskExample example=new TaskExample();
		example.createCriteria().andOrderIdEqualTo(orderNo);
		taskWithBLOBs=mapper.selectByExampleWithBLOBs(example);
		if(taskWithBLOBs.size()>0) {
			Date date=new Date();
			System.out.println(WXPayUtil.printDifference(WXPayUtil.formatDate(taskWithBLOBs.get(0).getPublishTime()),date));
			if(WXPayUtil.printDifference(WXPayUtil.formatDate(taskWithBLOBs.get(0).getPublishTime()),date)<120){
				Map<String, String> apiMap = new HashMap<String, String>();
				apiMap.put("package", "prepay_id=" + taskWithBLOBs.get(0).getPrepayId());
				apiMap.put("appId",config.getAppid());
				apiMap.put("timeStamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
				apiMap.put("nonceStr", WXPayUtil.generateNonceStr());
				apiMap.put("signType", "MD5");
				apiMap.put("paySign", WXPayUtil.generateSignature(apiMap, config.getKey()));
				apiMap.put("code", "SUCCESS");
				new JSONObject();
				isOk= JSONObject.fromObject(apiMap).toString();
			}else {
				isOk="订单超时,请重新下单";
			}
		}
		return isOk;
	}
}
