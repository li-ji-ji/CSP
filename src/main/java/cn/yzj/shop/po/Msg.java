package cn.yzj.shop.po;

import cn.yzj.shop.systemclass.Code;

public class Msg {
	private static Code code=Code.FAIL;
	private static String msg;
	private static String jsonData;
	public static Code getCode() {
		return code;
	}
	public void setCode(Code code) {
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
