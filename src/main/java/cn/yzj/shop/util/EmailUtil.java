package cn.yzj.shop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import cn.yzj.shop.po.EmailTemplate;

/*
 *yzj
 *2019
 *2019年9月18日
 */
@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private EmailTemplate emailt;
	/**
	 * 
	 *yzj
	 *2019
	 *2019年9月18日
	 *邮箱文本工具
	 * @param emailTemplate
	 */
	public  void simpleMaill(@Validated EmailTemplate emailTemplate) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		emailTemplate.setFrom(emailt.getFrom());
		mailMessage.setFrom(emailTemplate.getFrom());
		mailMessage.setTo(emailTemplate.getReceiver());
		mailMessage.setSubject(emailTemplate.getTitle());
		mailMessage.setText(emailTemplate.getContent());
		mailSender.send(mailMessage);
	}
}
