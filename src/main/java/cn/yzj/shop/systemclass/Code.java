package cn.yzj.shop.systemclass;

public enum Code {
	SUCCESS("成功",1),
	EXCEPTION("服务器异常",2),
	CHEK_EXCEPTION("参数校验异常",3),
	FAIL("失败",0);
	private final String msg ;
    private final int code;
	private Code(String msg, int code) {
		this.msg = msg;
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public int getCode() {
		return code;
	}
	
}
