package cn.yzj.shop.po;

import java.io.Serializable;

public class LayUIJSON implements Serializable{
		 
	    private int code=0;
	    private String msg="";
	    private Long count; //总条数
	    private Object data; //装前台当前页的数据
		public LayUIJSON(Long count, Object data) {
			super();
			this.count = count;
			this.data =  data;
		}
		public LayUIJSON(String msg, Long count, Object data) {
			super();
			this.msg = msg;
			this.count = count;
			this.data = data;
		}
		public LayUIJSON() {
			super();
		}
		public LayUIJSON(int code, String msg, Long count, Object data) {
			super();
			this.code = code;
			this.msg = msg;
			this.count = count;
			this.data = data;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Long getCount() {
			return count;
		}
		public void setCount(Long count) {
			this.count = count;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public void setDataWithTasks(Object tasks) {
			this.data = tasks;
			
		}
		
	 
	}
