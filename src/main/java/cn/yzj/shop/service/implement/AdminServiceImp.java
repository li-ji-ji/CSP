package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.AdminMapper;
import cn.yzj.shop.po.AdminExample;
import cn.yzj.shop.po.AdminWithBLOBs;
import cn.yzj.shop.po.LayUIJSON;
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
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find() throws Exception {
		return null;
		/*
		 *yzj
		 *2019
		 *2019年9月20日
		 */
		//自动生成的方法存根
		
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
	public Serializable dataPage(int limit, int page) throws Exception {
		PageHelper.startPage(page,limit);
		List<AdminWithBLOBs> admins=adminMapper.selectByExampleWithBLOBs(null);
		PageInfo<AdminWithBLOBs> pageInfo=new PageInfo<AdminWithBLOBs>(admins);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(),admins);		
		return uijson;		
	}
	/*
	 *yzj
	 *2019
	 *2019年9月20日
	 */
}
