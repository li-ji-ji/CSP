package cn.yzj.shop.systemclass;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.alibaba.fastjson.JSON;

import cn.yzj.shop.mapper.ConfigMapper;
import cn.yzj.shop.po.ConfigExample;
import cn.yzj.shop.po.EmailTemplate;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.ConfigService;
import cn.yzj.shop.util.EmailUtil;

/*
 *yzj
 *2019
 *2019年9月15日
 *统一异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler {
	@Autowired
	private EmailUtil emailUitl;
	@Autowired
	private ConfigMapper configMapper;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Msg notValidExceptionHandler(MethodArgumentNotValidException e) {
		Msg msg = new Msg();
		List<ObjectError> fieldError = e.getBindingResult().getAllErrors();
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (ObjectError objectError : fieldError) {
			i++;
			if (i == 1) {
				sb.append("[").append(objectError.getDefaultMessage()).append("]");
			} else {
				sb.append(",[").append(objectError.getDefaultMessage()).append("]");
			}
		}
		msg.setJsonData(sb.toString());
		return msg;
	}

	/**
	 * 
	 * yzj 2019 2019年9月17日 参数校验错误异常处理方法
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Msg handleBindException(BindException ex) {
		// 校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
		List<ObjectError> fieldError = ex.getBindingResult().getAllErrors();
		Msg msg = new Msg();
		msg.setCode(Code.CHEK_EXCEPTION.getCode());
		msg.setMsg(Code.CHEK_EXCEPTION.getMsg());
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (ObjectError objectError : fieldError) {
			i++;
			if (i == 1) {
				sb.append("[").append(objectError.getDefaultMessage()).append("]");
			} else {
				sb.append(",[").append(objectError.getDefaultMessage()).append("]");
			}
		}
		msg.setJsonData(sb.toString());
		return msg;
	}

	/**
	 * 
	 * yzj 2019 2019年9月17日 exception异常抛出处理方法
	 * 
	 * @param e
	 * @return
	 */
	public static ExecutorService threaPool = Executors.newFixedThreadPool(30);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Msg exceptionHandler(Exception e) {
		DeferredResult<Msg> deferredResult = new DeferredResult<Msg>(30 * 1000L);
		Msg msg = new Msg();
		msg.setCode(Code.EXCEPTION.getCode());
		msg.setMsg(Code.EXCEPTION.getMsg());
		msg.setJsonData(e.getMessage());
		System.out.println(Thread.currentThread().getName() + "启动新线程");
		threaPool.execute(new Runnable() {
			@Override
			public void run() {
				/*
				 * yzj 2019 2019年9月19日
				 */
				// 自动生成的方法存根
				System.out.println(Thread.currentThread().getName() + "执行");
				EmailTemplate emailTemplate = new EmailTemplate();
				ConfigExample example=new ConfigExample();
				example.createCriteria().andIncTypeEqualTo("system_email").andNameEqualTo("admin_email");
				emailTemplate.setReceiver(configMapper.selectByExample(example).get(0).getValue());
				emailTemplate.setTitle(Code.EXCEPTION.getMsg());
				emailTemplate.setContent(JSON.toJSONString(msg));
				emailUitl.simpleMaill(emailTemplate);
				deferredResult.setResult(msg);
			}
		});
		return msg;
	}
}
