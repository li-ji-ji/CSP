package com.csp.lhj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lhj.csp.fileinfo.mapper.FileInfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CspApplicationTests {
	
	@Autowired
	private FileInfoMapper mapper;
	
	@Test
	public void contextLoads() {
		System.out.println(mapper.selectByExample(null));
	}

}
