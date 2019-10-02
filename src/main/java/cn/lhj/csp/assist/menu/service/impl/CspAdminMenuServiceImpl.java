package cn.lhj.csp.assist.menu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.lhj.csp.assist.menu.mapper.CspAdminMenuMapper;
import cn.lhj.csp.assist.menu.mapper.SpecialMapper;
import cn.lhj.csp.assist.menu.po.CspAdminMenu;
import cn.lhj.csp.assist.menu.po.CspAdminMenuExample;
import cn.lhj.csp.assist.menu.service.CspAdminMenuService;
import cn.lhj.csp.utils.LayUIJSON;


@Service
public class CspAdminMenuServiceImpl implements CspAdminMenuService {
	
	@Autowired
	private CspAdminMenuMapper cspAdminMenuMapper; 
	@Autowired
	private SpecialMapper specialMapper;
	
	//查询所有菜单
	@Override
	public List<CspAdminMenu> getAll() throws Exception {
		return cspAdminMenuMapper.selectByExample(null);
	}
	
	
	//查询可显示菜单并封装为JSON数据
	@Override
	public String getShowMenuToJson()throws Exception{
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		criteria.andIsHiddenEqualTo(1);
		List<CspAdminMenu> menus=cspAdminMenuMapper.selectByExample(example);
		String resultMsg=JSON.toJSONString(menus);
		return resultMsg;
	}
	
	//查询可显示菜单并封装为layUIJSON数据
	@Override
	public LayUIJSON<CspAdminMenu> getAllMenuToLayuiJson()throws Exception{
		LayUIJSON<CspAdminMenu> resultMsg=new LayUIJSON<CspAdminMenu>();
		resultMsg.setData(cspAdminMenuMapper.selectByExample(null));
		return resultMsg;
	}
	
	//根据菜单所属表名查询列名
	@Override
	public List<Map> getColunmByTableName(String tableName) throws Exception {
		return specialMapper.getColunmByTableName(tableName);
	}
	
	//根据ID查询菜单
	@Override
	public CspAdminMenu getById(Integer id) throws Exception {
		return cspAdminMenuMapper.selectByPrimaryKey(id);
	}

	//根据PID查询菜单(限制条数)
	@Override
	public List<CspAdminMenu> getByPid(Integer pid,Integer No,Integer limit) throws Exception {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		example.setOffset(No);
		example.setLimit(limit);
		criteria.andPIdEqualTo(pid);
		return cspAdminMenuMapper.selectByExample(example);
	}
	
	//插入新菜单
	@Override
	public int insert(CspAdminMenu menu) throws Exception {
		try {
			cspAdminMenuMapper.insertSelective(menu);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	//根据ID删除菜单
	@Override
	public int deleteById(Integer id) throws Exception {
		try {
			cspAdminMenuMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	//选择性更新菜单
	@Override
	public int updateSeletiveById(CspAdminMenu menu) throws Exception {
		try {
			cspAdminMenuMapper.updateByPrimaryKeySelective(menu);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	//根据页数和条数查询菜单数据并返回layuiJSON
	@Override
	public LayUIJSON<CspAdminMenu> selectMenuLimitToJSON(Integer page, Integer limit) throws Exception {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		LayUIJSON<CspAdminMenu> msg=new LayUIJSON<CspAdminMenu>();
		msg.setCount((long)getCount());
		int No;
		No=(page-1)*limit;
		example.setOffset(No);
		example.setLimit(limit);
		List<CspAdminMenu> getMenu=cspAdminMenuMapper.selectByExample(example);
		for(CspAdminMenu menu:getMenu) {
			int id=menu.getId();
			CspAdminMenu get=getById(id);
			menu.setpName(get.getName());
		}
		msg.setData(getMenu);
		return msg;
	}

	//查询数据条数
	@Override
	public int getCount() {
		return cspAdminMenuMapper.countByExample(null);
	}

	//根据Pid查询数据条数
	@Override
	public int getCountByPid(Integer pId) {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pId);
		return cspAdminMenuMapper.countByExample(example);
	}

	//根据菜单名称进行模糊搜索
	@Override
	public List<CspAdminMenu> getByNameLike(String nameLike,Integer No,Integer limit) throws Exception {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike(nameLike);
		System.out.println(cspAdminMenuMapper.selectByExample(example));
		return cspAdminMenuMapper.selectByExample(example);
	}

	@Override
	public int getCountByNameLike(String nameLike) {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike(nameLike);
		return cspAdminMenuMapper.countByExample(example);
	}
	
	//根据PID查询菜单以layuiJSON返回
	@Override
	public LayUIJSON<CspAdminMenu> getLayUIJSONByPid(Integer pid,Integer page,Integer limit)throws Exception{
		LayUIJSON<CspAdminMenu> Msg=new LayUIJSON<>();
		Integer No;
		No=(page-1)*limit;
		Msg.setCode(0);
		Msg.setCount((long)getCountByPid(pid));
		Msg.setData(getByPid(pid, No, limit));
		return Msg;
	}
}
