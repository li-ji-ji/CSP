package com.cfz.csp.authority;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cfz.csp.authority.mapper.StudentMapper;
import com.cfz.csp.authority.mapper.SysPermissionMapper;
import com.cfz.csp.authority.mapper.SysRoleMapper;
import com.cfz.csp.authority.mapper.SysRolePermissionMapper;
import com.cfz.csp.authority.mapper.SysStudentRoleMapper;
import com.cfz.csp.authority.po.SysPermission;
import com.cfz.csp.authority.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampusEurekaClientApplicationTests {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private SysStudentRoleMapper sysStudentRoleMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void contextLoads() {
		System.out.println("最小化成功");
		SysPermission record = new SysPermission();
		System.out.println(record);
		sysPermissionMapper.insert(record);
	}
}
