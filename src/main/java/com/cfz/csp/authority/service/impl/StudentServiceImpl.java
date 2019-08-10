package com.cfz.csp.authority.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfz.csp.authority.mapper.StudentMapper;
import com.cfz.csp.authority.mapper.SysPermissionMapper;
import com.cfz.csp.authority.mapper.SysRolePermissionMapper;
import com.cfz.csp.authority.po.Student;
import com.cfz.csp.authority.po.StudentExample;
import com.cfz.csp.authority.po.SysPermission;
import com.cfz.csp.authority.po.SysRole;
import com.cfz.csp.authority.po.SysRolePermission;
import com.cfz.csp.authority.po.SysRolePermissionExample;
import com.cfz.csp.authority.service.StudentService;
import com.cfz.csp.authority.util.HttpRequestsUtil;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@Autowired
	private SysPermissionMapper sysPermissionMapper;

	

	/**
	 * 微信登录业务实现类:
	 * 
	 * @param openid 用户id
	 * @return User
	 */
	@Override
	public String loginByWeixin(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 发送
		// https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
		// 获取用户的openid和session_key
		// 注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret
		// 这个也一样，我这里是用了常量来进行保存方便多次使用
		String appId = "wxf8c87e5d14aa1aa5";
		String appSecret = "ae57e2cc64b4653453d39ef69293c3aa";
		String params = "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code
				+ "&grant_type=authorization_code";
		String WeChatTool = "https://api.weixin.qq.com/sns/jscode2session";
		String sendGet = HttpRequestsUtil.sendGet(WeChatTool, params); // 发起请求拿到key和openid
		return sendGet;
	}

	@Override
	public Student findByName(String name) {
		// TODO Auto-generated method stub
		Student student = studentMapper.selectStudentRolePermissionByName(name);
		Student studentBak = student;
		//添加学生的权限
		for (int i = 0; i < student.getRoleList().size(); i++) {
			SysRole role = student.getRoleList().get(i);
			Integer roleId = role.getId();
			SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
			sysRolePermissionExample.setDistinct(true);// 去除重复,true是选择不重复记录,false反之
			SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();// 构造自定义查询条件
			criteria.andRoleIdEqualTo(roleId);
			List<SysRolePermission> SysRolePermissions = sysRolePermissionMapper
					.selectByExample(sysRolePermissionExample);
			List<SysPermission> sysPermissionList = new ArrayList<SysPermission>();
			for (SysRolePermission s : SysRolePermissions) {
				Integer pId = s.getPermissionId();
				SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(pId);
				System.out.println(sysPermission);
				sysPermissionList.add(sysPermission);
			}
			student.getRoleList().get(i).setPermissions(sysPermissionList);
		}
		return student;
	}

	@Override
	public List<Student> select(int page, int limit) {
		// TODO Auto-generated method stub
		page = (page - 1) * 10;
		return studentMapper.select(page, limit);
	}

	@Override
	public long countByExample(StudentExample example) {
		// TODO Auto-generated method stub
		return studentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(StudentExample example) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.insertSelective(record);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		// TODO Auto-generated method stub
		return studentMapper.selectByExample(example);
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Student record, StudentExample example) {
		// TODO Auto-generated method stub
		return studentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Student record, StudentExample example) {
		// TODO Auto-generated method stub
		return studentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}

}
