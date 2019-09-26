package cn.yzj.shop.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yzj.shop.mapper.GoodsMapper;
import cn.yzj.shop.mapper.SuppliersMapper;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.service.Region2Service;
import cn.yzj.shop.systemclass.Code;
import cn.yzj.shop.util.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private SuppliersMapper suppMapper;
	@Autowired
	private Region2Service region2Service;
	@Test
	public void contextLoads() throws Exception {
		System.out.println(region2Service.find(1));
	}

}
