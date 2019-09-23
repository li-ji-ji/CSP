package cn.yzj.shop.util;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *yzj
 *2019
 *2019年9月20日
 */
@Component
public class EncryptionUtil {
	@Autowired
	private  StringEncryptor encryptor;
	/**
	 * 加密工具
	 *yzj
	 *2019
	 *2019年9月20日
	 * @param data 真实数据
	 * @return 密文
	 */
	public  String encry(String data) {
		return encryptor.encrypt(data);
	}
	/**
	 * 解密工具
	 *yzj
	 *2019
	 *2019年9月20日
	 * @param data 密文
	 * @return 真实数据
	 */
	public  String dncry(String data) {
		return encryptor.decrypt(data);
	}
	

}
