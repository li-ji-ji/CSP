package cn.lhj.csp.config.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class TestRedisRestController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	// 添加
	@GetMapping(value = "/redisAdd")
	public void saveRedis() {
		stringRedisTemplate.opsForValue().set("a", "test1");
	}

	// 获取
	@GetMapping(value = "/redisGet")
	public String getRedis() {
		String config = stringRedisTemplate.opsForValue().get("tengxunConfig");
		JSONArray json = JSONArray.fromObject(config);
		if (json.size() > 0) {
			for (int i = 0; i < json.size(); i++) {
				JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				System.out.println(job.get("configKey") + "="+job.get("configValue")); // 得到 每个对象中的属性值
			}
		}
		return stringRedisTemplate.opsForValue().get("tengxunConfig");
	}
}