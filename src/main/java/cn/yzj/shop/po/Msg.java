package cn.yzj.shop.po;

import java.io.Serializable;

import cn.yzj.shop.systemclass.Code;
/*
 * 
 *yzj
 *2019
 *2019年9月12日
 */
public class Msg{
	private static int code=Code.FAIL.getCode();
	private static String msg=Code.FAIL.getMsg();
	private static String jsonData;
	public  int getCode() {
		return code;
	}
	public void setCode(int code) {
		Msg.code = code;
	}
	public  String getMsg() {
		return msg;
	}
	public  void setMsg(String msg) {
		Msg.msg = msg;
	}
	public  String getJsonData() {
		return jsonData;
	}
	public  void setJsonData(String jsonData) {
		Msg.jsonData = jsonData;
	}
	
}
