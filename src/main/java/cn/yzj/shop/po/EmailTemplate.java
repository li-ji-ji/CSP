package cn.yzj.shop.po;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 *yzj
 *2019
 *2019年9月18日
 */
@Component
public class EmailTemplate {
	/**
	 * 发送方邮箱
	 */
	@Value("${spring.mail.username}")
	private String from;
	/**
	 * 接收方邮箱
	 */
	@Email(message = "邮箱格式错误")
	private String receiver;
	/**
	 * 邮件标题
	 */
	@NotBlank(message = "邮件标题不能为空")
	private String title;
	/**
	 * 邮件内容
	 */
	@NotBlank(message = "邮件内容不能为空")
	private String content;

	public void setFrom(String from) {
		this.from = from;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom() {
		return from;
	}
}
