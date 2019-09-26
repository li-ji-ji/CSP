package cn.yzj.shop.po;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
 *yzj
 *2019
 *2019年9月26日
 */
public class LoginDTO implements Serializable{

	/*
	 *yzj
	 *2019
	 *2019年9月26日
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "用户名不能为空")
	private String userName;
	@Size(max = 12,min = 6,message = "密码必须在6~12个字符之间")
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
