package cn.lhj.csp.assist.menu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.lhj.csp.assist.menu.po.CspAdminMenu;
import cn.lhj.csp.utils.LayUIJSON;


@Service
public interface CspAdminMenuService {
	
	//根据菜单所属表名查询列名
	public List<Map> getColunmByTableName(String tableName) throws Exception;
	
	//查询所有后台菜单
	public List<CspAdminMenu> getAll() throws Exception;
	
	//查询可显示菜单并封装为JSON数据
	public String getShowMenuToJson()throws Exception;
	
	//查询可显示菜单并封装为layUIJSON数据
	public LayUIJSON<CspAdminMenu> getAllMenuToLayuiJson()throws Exception;
	
	//根据ID查询后台菜单
	public CspAdminMenu getById(Integer id)throws Exception;
	
	//根据返回页码和条数查询菜单数据
	public LayUIJSON<CspAdminMenu> selectMenuLimitToJSON(Integer No,Integer count) throws Exception;
	
	//查询数据条数
	public int getCount();
	//根据Pid查询数据条数
	public int getCountByPid(Integer pId);
	//根据菜单名称模糊查询数据条数
	public int getCountByNameLike(String nameLike);
	
	//根据PID查询菜单
	public List<CspAdminMenu> getByPid(Integer pid,Integer page,Integer limit)throws Exception;
	
	//根据菜单名称进行模糊搜索
	public List<CspAdminMenu> getByNameLike(String nameLike,Integer No,Integer limit)throws Exception;
	
	//选择性添加菜单
	public int insert(CspAdminMenu menu)throws Exception;
	
	//根据ID删除菜单
	public int deleteById(Integer id)throws Exception;
	
	//根据ID选择性更新菜单
	public int updateSeletiveById(CspAdminMenu menu)throws Exception;

	LayUIJSON<CspAdminMenu> getLayUIJSONByPid(Integer pid, Integer page, Integer limit) throws Exception;
	
}
