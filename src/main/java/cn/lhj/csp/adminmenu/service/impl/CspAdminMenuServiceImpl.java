package cn.lhj.csp.adminmenu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.adminmenu.mapper.CspAdminMenuMapper;
import cn.lhj.csp.adminmenu.mapper.SpecialMapper;
import cn.lhj.csp.adminmenu.po.CspAdminMenu;
import cn.lhj.csp.adminmenu.po.CspAdminMenuExample;
import cn.lhj.csp.adminmenu.po.CspAdminMenuExample.Criteria;
import cn.lhj.csp.adminmenu.po.CspAdminMenuExample.Criterion;
import cn.lhj.csp.adminmenu.service.CspAdminMenuService;

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

	//根据页数和条数查询菜单数据
	@Override
	public List<CspAdminMenu> selectMenuLimit(Integer No, Integer limit) throws Exception {
		CspAdminMenuExample example=new CspAdminMenuExample();
		CspAdminMenuExample.Criteria criteria=example.createCriteria();
		example.setOffset(No);
		example.setLimit(limit);
		return cspAdminMenuMapper.selectByExample(example);
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
}
