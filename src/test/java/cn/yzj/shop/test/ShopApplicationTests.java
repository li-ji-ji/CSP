package cn.yzj.shop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yzj.shop.mapper.GoodsMapper;
import cn.yzj.shop.mapper.SuppliersMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private SuppliersMapper suppMapper;

	@Test
	public void contextLoads() {
		System.out.println(goodsMapper.selectByPrimaryKey(1).getGoodsName());
		Short short1=1;
		System.out.println(suppMapper.selectByPrimaryKey(short1).getSuppliersName());
	}

}
