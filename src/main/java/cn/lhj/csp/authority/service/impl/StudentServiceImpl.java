package cn.lhj.csp.authority.service.impl;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.lhj.csp.authority.mapper.StudentMapper;
import cn.lhj.csp.authority.mapper.SysPermissionMapper;
import cn.lhj.csp.authority.mapper.SysRolePermissionMapper;
import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.po.StudentExample;
import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysRole;
import cn.lhj.csp.authority.po.SysRolePermission;
import cn.lhj.csp.authority.po.SysRolePermissionExample;
import cn.lhj.csp.authority.po.UserBinding;
import cn.lhj.csp.authority.service.StudentService;
import cn.lhj.csp.authority.util.HttpRequestsUtil;
import cn.yzj.csp.task.util.WXPayUtil;
import cn.yzj.csp.task.util.WxConfig;

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
	public boolean updateByPrimaryKeySelective(Student record) {
		// TODO Auto-generated method stub
		boolean isok=false;
		if(studentMapper.updateByPrimaryKeySelective(record)>0) {
			isok=true;
		}
		return isok;
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}
	
	public int insertStudentInfoBatch(List<Student> students) {
		return studentMapper.insertStudentInfoBatch(students);
	}

	@Override
	@Transactional
	public List<Student> selectStudentBatch(String ids) throws Exception{
		List<Student> students=new ArrayList<Student>();
		JSONArray array=JSONArray.parseArray(ids);
		for (Object object : array) {
			students.add(studentMapper.selectByPrimaryKey((Integer) object));
		}
		return students;
	}

	@Override
	@Transactional
	public Student userLogin(String code) throws Exception {
		List<Student> students=null;
		Student student=new Student();
		WxConfig wxConfig=new WxConfig();
		String appid=wxConfig.getAppid();
		String secret=wxConfig.getAppSecret();
		String grant_type="authorization_code";
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		Map<String, String> pram=new HashMap<String, String>();
		pram.put("appid", appid);
		pram.put("secret", secret);
		pram.put("js_code", code);
		pram.put("grant_type",grant_type);
		String url="https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
	    Map<String, Object> mapSession = JSON.parseObject(restTemplate.getForObject(url,String.class,pram));
	    if(mapSession.get("openid")!=null) {
	    	StudentExample example=new StudentExample();
	    	example.createCriteria().andWxopenidEqualTo(String.valueOf(mapSession.get("openid")));
	    	students=studentMapper.selectByExample(example);
	    	if(students.size()>0) {
	    		student=students.get(0);
	    	}
	    }
		return student;
		/*
		 *yzj
		 *2019
		 *2019年12月10日
		 */
		//自动生成的方法存根
		
	}

	@Override
	@Transactional
	public Student binding(UserBinding user) throws Exception {
		StudentExample example=new StudentExample();
		example.createCriteria().andNameEqualTo(user.getName()).andSnEqualTo(user.getNumber()).andMajorEqualTo(user.getProfessional());
		List<Student> students=studentMapper.selectByExample(example);
		Student student=new Student();
		if(students.size()>0) {
			WxConfig wxConfig=new WxConfig();
			String appid=wxConfig.getAppid();
			String secret=wxConfig.getAppSecret();
			String grant_type="authorization_code";
			RestTemplate restTemplate=new RestTemplate();
			restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
			Map<String, String> pram=new HashMap<String, String>();
			pram.put("appid", appid);
			pram.put("secret", secret);
			pram.put("js_code", user.getCode());
			pram.put("grant_type",grant_type);
			String url="https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
			Map<String, Object> mapSession = JSON.parseObject(restTemplate.getForObject(url,String.class,pram));
			if(mapSession.get("openid")!=null) {
				student=students.get(0);
				student.setWxopenid(String.valueOf(mapSession.get("openid")));
				student.setHurl(user.getHurl());
				student.setWxname(user.getWxname());
				student.setSex(user.getSex());
				student.setSchool(user.getSchool());
				if(studentMapper.updateByPrimaryKeySelective(student)<=0) {
					student=null;
				}
			}
		}
		return student;
		/*
		 *yzj
		 *2019
		 *2019年12月10日
		 */
		//自动生成的方法存根
		
	}
}
