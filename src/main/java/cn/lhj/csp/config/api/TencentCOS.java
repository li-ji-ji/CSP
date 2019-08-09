package cn.lhj.csp.config.api;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.service.impl.ConfigServiceImpl;

public class TencentCOS {

		//secretId
		private static final String secretId = "AKIDZKzTuCfemkU9d2eW4RdhYcNxeEuXtuc8";
		// secretKey
		private static final String secretKey = "Xs2aP7e3KTUmvLZgbLuIF6nNpALLA5pQ";
		// 此处填写的存储桶名称
		private static final String bucketName = "csp-1257312123";

		// 1 初始化用户身份信息(secretId, secretKey，可在腾讯云后台中的API密钥管理中查看！
		private static COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);

		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224，根据自己创建的存储桶选择地区
		private static ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));


		/**
		 * 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口 大文件上传请参照 API 文档高级 API 上传
		 * 
		 * @param localFile
		 */
		
		public static String uploadfile(File localFile) throws CosClientException, CosServiceException {

			// 生成cos客户端
			COSClient cosclient = new COSClient(cred, clientConfig);
			String fileName = null;
			try {
			    fileName = localFile.getName();
				String substring = fileName.substring(fileName.lastIndexOf("."));
				Random random = new Random();
				// 指定要上传到 COS 上的路径
				fileName = random.nextInt(10000) + System.currentTimeMillis() + substring;
				//fileName = "images/"+random.nextInt(10000) + System.currentTimeMillis() + substring;
				PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName , localFile);
				PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 关闭客户端(关闭后台线程)
				cosclient.shutdown();
			}
			return fileName;
		}
		
		
		/**
	     * 
	     * @Title: downFile
	     * @Description: 下载文件
	     * @return
	     */
	    public static void downFile() {
	    	// 生成cos客户端
	    	COSClient cosclient = new COSClient(cred, clientConfig);
	    	//要下载的文件路径和名称
	        String key = "down/demo1.jpg";
	     	// 指定文件的存储路径
	        File downFile = new File("src/test/resources/mydown.txt");
	        // 指定要下载的文件所在的 bucket 和对象键
	        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
	        ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, downFile);
	    }
		

		/**
		 * 删除文件
		 * 
		 * @param key
		 */
		public static void deletefile(String key) throws CosClientException, CosServiceException {
			// 生成cos客户端
			COSClient cosclient = new COSClient(cred, clientConfig);
			// 指定要删除的 bucket 和路径
			cosclient.deleteObject(bucketName, key);
			// 关闭客户端(关闭后台线程)
			cosclient.shutdown();
		}
}
