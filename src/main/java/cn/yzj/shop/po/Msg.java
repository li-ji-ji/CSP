package cn.yzj.shop.po;

import cn.yzj.shop.systemclass.Code;

public class Msg {
	private static int code=Code.FAIL.getCode();
	private static String msg=Code.FAIL.getMsg();
	private static String jsonData;
	public static int getCode() {
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
