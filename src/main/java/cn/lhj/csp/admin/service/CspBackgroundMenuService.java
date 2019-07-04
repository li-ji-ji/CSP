package cn.lhj.csp.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.admin.po.CspBackgroundMenu;

@Service
public interface CspBackgroundMenuService {
	
	//查询所有后台菜单
	public List<CspBackgroundMenu> getAll() throws Exception;
	
	//根据ID查询后台菜单
	public CspBackgroundMenu getById(Integer id)throws Exception;
	
	//根据PID查询菜单
	public List<CspBackgroundMenu> getByPid(Integer pid)throws Exception;
	
	//选择性添加菜单
	public int insert(CspBackgroundMenu menu)throws Exception;
	
	//根据ID删除菜单
	public int deleteById(Integer id)throws Exception;
	
	//根据ID选择性更新菜单
	public int updateSeletiveById(Integer id)throws Exception;
}
