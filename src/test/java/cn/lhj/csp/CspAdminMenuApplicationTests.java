package cn.lhj.csp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.service.ConfigService;
import cn.lhj.csp.config.service.impl.RedisTemplateServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CspAdminMenuApplicationTests {

	@Autowired
	private ConfigService configService;
	@Autowired
	private RedisTemplateServiceImpl redisTemplateServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		
	}

}
