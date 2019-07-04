package cn.lhj.csp.adminmenu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.admin.mapper.SpecialMapper;
import cn.lhj.csp.adminmenu.mapper.CspBackgroundMenuMapper;
import cn.lhj.csp.adminmenu.po.CspBackgroundMenu;
import cn.lhj.csp.adminmenu.service.CspBackgroundMenuService;

@Service
public class CspBackgroundMenuServiceImpl implements CspBackgroundMenuService {
	
	@Autowired
	private CspBackgroundMenuMapper cspBackgroundMenuMapper; 
	@Autowired
	private SpecialMapper specialMapper;
	
	//查询所有菜单
	@Override
	public List<CspBackgroundMenu> getAll() throws Exception {
		return cspBackgroundMenuMapper.selectByExample(null);
	}
	
	//根据菜单所属表名查询列名
	@Override
	public List<Map> getColunmByTableName(String tableName) throws Exception {
		return specialMapper.getColunmByTableName(tableName);
	}
	@Override
	public CspBackgroundMenu getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CspBackgroundMenu> getByPid(Integer pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CspBackgroundMenu menu) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSeletiveById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
