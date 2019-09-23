package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.AdminLogMapper;
import cn.yzj.shop.po.AdminLog;
import cn.yzj.shop.po.AdminLogExample;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.AdminLogService;
import cn.yzj.shop.systemclass.Code;

/*
 *yzj
 *2019
 *2019年9月21日
 */
@Service
public class AdminLogServiceImp implements AdminLogService {
	@Autowired
	private AdminLogMapper adminLogMapper;

	@Override
	public Msg add(Serializable id) throws Exception {
		return null;
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
		List<Long> ids=new ArrayList<Long>();
		for (Object item : array) {
			ids.add(Long.valueOf((String) item));
		}
		AdminLogExample example=new AdminLogExample();
		example.createCriteria().andLogIdIn(ids);
		if(adminLogMapper.deleteByExample(example)>0) {
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
		return null;
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
		return null;
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
		PageHelper.startPage(page, limit);
		AdminLogExample example=new AdminLogExample();
		example.setOrderByClause("log_id DESC");
		List<AdminLog> adminLog=adminLogMapper.selectByExample(example);
		PageInfo< AdminLog> pageInfo=new PageInfo<AdminLog>(adminLog);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(), adminLog);
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
