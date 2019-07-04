package cn.lhj.csp.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.admin.mapper.CspBackgroundMenuMapper;
import cn.lhj.csp.admin.po.CspBackgroundMenu;
import cn.lhj.csp.admin.service.CspBackgroundMenuService;

@Service
public class CspBackgroundMenuServiceImpl implements CspBackgroundMenuService {
	
	@Autowired
	private CspBackgroundMenuMapper cspBackgroundMenuMapper; 
	
	//查询所有菜单
	@Override
	public List<CspBackgroundMenu> getAll() throws Exception {
		// TODO Auto-generated method stub
		return cspBackgroundMenuMapper.selectByExample(null);
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
