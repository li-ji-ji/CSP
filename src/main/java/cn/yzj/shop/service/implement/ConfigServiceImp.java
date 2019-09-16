package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.ConfigMapper;
import cn.yzj.shop.po.Config;
import cn.yzj.shop.po.ConfigExample;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.ConfigService;
import cn.yzj.shop.systemclass.Code;

/*
 *yzj
 *2019
 *2019年9月16日
 */
@Service
public class ConfigServiceImp implements ConfigService {
	@Autowired
	private ConfigMapper configMapper;

	@Override
	public Msg add(Serializable id) throws Exception {
		Msg msg=new Msg();
		if(configMapper.insertSelective((Config) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;		
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		Msg msg=new Msg();
		ConfigExample example=new ConfigExample();
		List<Short> ids=new ArrayList<Short>();
		JSONArray array=JSONArray.parseArray((String) id);
		for (Object item : array) {
			ids.add(Short.valueOf((String) item));
		}
		example.createCriteria().andIdIn(ids);
		if(configMapper.deleteByExample(example)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		Msg msg=new Msg();
		if(configMapper.updateByPrimaryKeySelective((Config) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		ConfigExample example=new ConfigExample();
		example.createCriteria().andIncTypeEqualTo((String) id);
		List<Config> configs=configMapper.selectByExample(example);
		Map<String, String> map=new HashMap<String, String>();
		for (Config config : configs) {
			map.put(config.getName(), config.getValue());
		}
		return (Serializable) map;
	}

	@Override
	public Serializable find() throws Exception {
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page) throws Exception {
		PageHelper.startPage(page,limit);
		List<Config> configs=configMapper.selectByExample(null);
		PageInfo<Config> pageInfo=new PageInfo<Config>(configs);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(),configs);
		return uijson;
	}
	
}
