package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.AdminRoleMapper;
import cn.yzj.shop.po.AdminRole;
import cn.yzj.shop.po.AdminRoleExample;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.service.AdminRoleService;
import cn.yzj.shop.systemclass.Code;

/*
 *yzj
 *2019
 *2019年9月21日
 */
@Service
public class AdminRoleServiceImp implements AdminRoleService{

	@Autowired
	private AdminRoleMapper roleMapper;
	@Override
	public Msg add(Serializable id) throws Exception {
		Msg msg=new Msg();
		if(roleMapper.insertSelective((AdminRole) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		Msg msg=new Msg();
		JSONArray array=JSONArray.parseArray((String) id);
		List<Short> ids=new ArrayList<Short>();
		for (Object item : array) {
			ids.add(Short.valueOf((String) item));
		}
		AdminRoleExample example=new AdminRoleExample();
		example.createCriteria().andRoleIdIn(ids);
		if(roleMapper.deleteByExample(example)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		Msg msg=new Msg();
		if(roleMapper.updateByPrimaryKeyWithBLOBs((AdminRole) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		return id;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find() throws Exception {
		List<SelectTreeDTO> treeDTOs=new ArrayList<SelectTreeDTO>();
		List<AdminRole> adminRoles=roleMapper.selectByExampleWithBLOBs(null);
		for (AdminRole role : adminRoles) {
			SelectTreeDTO item=new SelectTreeDTO();
			item.setId(role.getRoleId());
			item.setName(role.getRoleName());
			treeDTOs.add(item);
		}
		return (Serializable) treeDTOs;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		return id;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable dataPage(int limit, int page) throws Exception {
		PageHelper.startPage(page,limit);
		List<AdminRole> adminRole=roleMapper.selectByExampleWithBLOBs(null);
		PageInfo<AdminRole> pageInfo=new PageInfo<AdminRole>(adminRole);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(),adminRole);
		return uijson;
		/*
		 *yzj
		 *2019
		 *2019年9月21日
		 */
		//自动生成的方法存根
		
	}
	/*
	 *yzj
	 *2019
	 *2019年9月21日
	 */
}
