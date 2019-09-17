package cn.yzj.shop.systemclass;

import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	/**
	 * 
	 *yzj
	 *2019
	 *2019年9月17日
	 *参数校验错误异常处理方法
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Msg notValidExceptionHandler(MethodArgumentNotValidException e) {
		Msg msg=new Msg();
		FieldError fieldError = e.getBindingResult().getFieldError();
		msg.setCode(Code.EXCEPTION.getCode());
		msg.setMsg(Code.EXCEPTION.getMsg());
		msg.setJsonData(fieldError.getDefaultMessage());
		System.out.println("1111111111111111111");
		return msg;
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseBody
    public Msg handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
        Msg msg=new Msg();
        msg.setCode(Code.EXCEPTION.getCode());
		msg.setMsg(Code.EXCEPTION.getMsg());
		msg.setJsonData(fieldError.getDefaultMessage());
		System.out.println(fieldError.getDefaultMessage());
		return msg;
    }
	
	/**
	 * 
	 *yzj
	 *2019
	 *2019年9月17日
	 *exception异常抛出处理方法
	 * @param e
	 * @return
	 */
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
