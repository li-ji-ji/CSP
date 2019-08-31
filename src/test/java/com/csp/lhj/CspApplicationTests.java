package com.csp.lhj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CspApplicationTests {
	
	@Autowired
	private FileInfoApiInterface fileInfoApi;
	
	@Test
	public void contextLoads() {
		System.out.println(fileInfoApi.selectByOrderNoPrintOrder("HZcno7GQqgNqhm55i5PlTGFMiUDnqG02"));
	}

}
