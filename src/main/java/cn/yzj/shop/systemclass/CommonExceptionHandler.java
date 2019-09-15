package cn.yzj.shop.systemclass;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yzj.shop.po.Msg;

/*
 *yzj
 *2019
 *2019年9月15日
 *统一异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler{
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Msg exceptionHandler(Exception e) {
		Msg msg=new Msg();
		msg.setCode(Code.EXCEPTION.getCode());
		msg.setMsg(Code.EXCEPTION.getMsg());
		msg.setJsonData(e.getMessage());
		return msg;
	}
	
}
