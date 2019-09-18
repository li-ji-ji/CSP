package cn.yzj.shop.systemclass;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.yzj.shop.po.EmailTemplate;
import cn.yzj.shop.po.Msg;
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
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Msg exceptionHandler(Exception e) {
		Msg msg = new Msg();
		msg.setCode(Code.EXCEPTION.getCode());
		msg.setMsg(Code.EXCEPTION.getMsg());
		msg.setJsonData(e.getMessage());
		EmailTemplate emailTemplate=new EmailTemplate();
		emailTemplate.setReceiver("1498856800@qq.com");
		emailTemplate.setTitle(Code.EXCEPTION.getMsg());
		emailTemplate.setContent(JSON.toJSONString(msg));
		emailUitl.simpleMaill(emailTemplate);
		return msg;
	}
}
