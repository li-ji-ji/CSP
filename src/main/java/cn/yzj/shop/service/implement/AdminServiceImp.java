package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.AdminMapper;
import cn.yzj.shop.mapper.AdminRoleMapper;
import cn.yzj.shop.po.AdminDTO;
import cn.yzj.shop.po.AdminExample;
import cn.yzj.shop.po.AdminRole;
import cn.yzj.shop.po.AdminWithBLOBs;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.LoginDTO;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.AdminService;
import cn.yzj.shop.systemclass.Code;
import cn.yzj.shop.util.WXPayUtil;

/*
 *yzj
 *2019
 *2019年9月20日
 */
@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private StringEncryptor encryptor;
	@Autowired
	private AdminRoleMapper roleMapper;
	@Override
	public Msg add(Serializable id) throws Exception {
		Msg msg=new Msg();
		AdminWithBLOBs admin=(AdminWithBLOBs) id;
		System.out.println("++++++++");
		admin.setPassword(encryptor.encrypt(admin.getPassword()));
		System.out.println("---------");
		admin.setAddTime(WXPayUtil.getNewTime("yyyy-MM-dd HH:mm:ss"));
		if(adminMapper.insertSelective(admin)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		Msg msg=new Msg();
		JSONArray array=JSONArray.parseArray((String) id);
		List<Short> ids=new ArrayList<Short>();
		for (Object object : array) {
			ids.add(Short.valueOf((String) object));
		}
		AdminExample example=new AdminExample();
		example.createCriteria().andAdminIdIn(ids);
		if(adminMapper.deleteByExample(example)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		Msg msg=new Msg();
		AdminWithBLOBs admin=(AdminWithBLOBs) id;
		if(admin.getPassword()!=null) {
			admin.setPassword(encryptor.encrypt(admin.getPassword()));
		}
		if(adminMapper.updateByPrimaryKeySelective(admin)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
			msg.setJsonData(null);
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		return id;
		
	}
	@Override
	public Msg adminLogin(LoginDTO loginDTO) {
		Msg msg=new Msg();
		AdminExample example=new AdminExample();
		example.createCriteria().andUserNameEqualTo(loginDTO.getUserName()).andPasswordEqualTo(loginDTO.getPassWord());
		if(adminMapper.selectByExampleWithBLOBs(example).size()>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
			msg.setJsonData(null);
		}
		return msg;
	}

	@Override
	public Serializable find() throws Exception {
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		return id;
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
	}

	@Override
	@Transactional
	public Serializable dataPage(int limit, int page) throws Exception {
		PageHelper.startPage(page,limit);
		List<AdminDTO> adminDTOs=new ArrayList<AdminDTO>();
		List<AdminWithBLOBs> admins=adminMapper.selectByExampleWithBLOBs(null);
		for (AdminWithBLOBs item : admins) {
		    AdminDTO admin=new AdminDTO();
		    admin.setAdminId(item.getAdminId());
		    admin.setAddTime(item.getAddTime());
		    admin.setAgencyId(item.getAgencyId());
		    admin.setCityId(item.getCityId());
		    admin.setDistrictId(item.getDistrictId());
		    admin.setEcSalt(item.getEcSalt());
		    admin.setEmail(item.getEmail());
		    admin.setLangType(item.getLangType());
		    admin.setLastIp(item.getLastIp());
		    admin.setLastLogin(item.getLastLogin());
		    admin.setPassword(encryptor.decrypt(item.getPassword()));
		    admin.setRoleId(item.getRoleId());
     		admin.setRoleName(roleMapper.selectByPrimaryKey(admin.getRoleId()).getRoleName());
			admin.setUserName(item.getUserName());
			adminDTOs.add(admin);
		}
		PageInfo<AdminWithBLOBs> pageInfo=new PageInfo<AdminWithBLOBs>(admins);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(),adminDTOs);		
		return uijson;		
	}
	/*
	 *yzj
	 *2019
	 *2019年9月20日
	 */
}
