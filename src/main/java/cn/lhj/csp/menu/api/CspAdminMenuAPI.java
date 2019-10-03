package cn.lhj.csp.menu.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.menu.po.CspAdminMenu;
import cn.lhj.csp.menu.service.CspAdminMenuService;
import cn.lhj.csp.utils.LayUIJSON;

/*
    *       后台菜单API
 * */
@RestController
@CrossOrigin
@RequestMapping("/menu")
public class CspAdminMenuAPI{

	@Autowired
	private CspAdminMenuService cspAdminMenuService;
	
	
	//获取所有后台菜单以JSON格式返回
	@RequestMapping("/getAll")
	public List<CspAdminMenu> getAll()throws Exception{
		List<CspAdminMenu> allMenu=cspAdminMenuService.getAll();
		for(int i=0;i<allMenu.size();i++) {
			if(allMenu.get(i).getIsHidden()==0) {
				allMenu.remove(i);
			}
		}
		return allMenu;
	}
	
	//获取所有菜单数据以LayUI接口数据格式返回
	@RequestMapping("/getAllToLayUI")
	public LayUIJSON getAllToLayUI() throws Exception{
		LayUIJSON menuMsg=new LayUIJSON();
		menuMsg.setData(getAll());
		menuMsg.setCount((long) 10);
		return menuMsg;
	}
	
	//查询菜单列名
	@RequestMapping("/getColumnName")
	public JSONArray getColumnName()throws Exception{
		List<Map> getColumn=cspAdminMenuService.getColunmByTableName("csp_admin_menu");
		JSONArray column=JSONArray.parseArray(JSONObject.toJSONString(getColumn));
		//System.out.println(column);//打印出转换后的JSON数据
		return column;
	}
	
	//根据ID查询菜单
	@RequestMapping("/getById")
	public CspAdminMenu getById(@RequestParam("id") Integer id)throws Exception{
		return cspAdminMenuService.getById(id);
	}
	
	//根据PID查询菜单
	@RequestMapping("/getByPid")
	public List<CspAdminMenu> getByPid(@RequestParam("pid") Integer pid)throws Exception{
		return cspAdminMenuService.getByPid(pid, pid, pid);
	}
	//根据PID查询菜单以layuiJSON返回
	@RequestMapping("/getLayUIJSONByPid")
	public LayUIJSON<CspAdminMenu> getLayUIJSONByPid(@RequestParam("pid") Integer pid,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception{
		LayUIJSON<CspAdminMenu> Msg=new LayUIJSON<>();
		Integer No;
		No=(page-1)*limit;
		Msg.setCode(0);
		Msg.setCount((long) cspAdminMenuService.getCountByPid(pid));
		Msg.setData(cspAdminMenuService.getByPid(pid, No, limit));
		return Msg;
	}
	
	//根据菜单名称进行模糊搜索
	@RequestMapping("/getLayUIJSONByNameLike")
	public LayUIJSON<CspAdminMenu> getLayUIJSONByNameLike(@RequestParam("nameLike") String nameLike,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception{
		LayUIJSON<CspAdminMenu> Msg=new LayUIJSON<>();
		Integer No;
		No=(page-1)*limit;
		Msg.setCode(0);
		Msg.setCount((long) cspAdminMenuService.getCountByNameLike(nameLike));
		Msg.setData(cspAdminMenuService.getByNameLike(nameLike, No, limit));
		return Msg;
	}
	
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception{
		//System.out.println("从页面获取的JSON："+getMsg);//输出从页面获取的JSON数据
		CspAdminMenu menu=JSON.parseObject(getMsg, CspAdminMenu.class);
		//System.out.println("转换后的CspBackgroundMenu："+menu);//输出转换后的CspBackgroundMenu
		return cspAdminMenuService.insert(menu);
	}
	
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception{
		return cspAdminMenuService.deleteById(id);
	}
	
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception{
		//System.out.println("从页面获取的JSON："+getMsg);//输出从页面获取的JSON数据
		CspAdminMenu menu=JSON.parseObject(getMsg, CspAdminMenu.class);
		//System.out.println("转换后的CspBackgroundMenu："+menu);//输出转换后的CspBackgroundMenu
		return cspAdminMenuService.updateSeletiveById(menu);
	}
	
	//根据页数和条数查询菜单数据并用LayuiJSON返回
	@RequestMapping("/getMenuLimit")
	public LayUIJSON<CspAdminMenu> selectMenuLimit(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) throws Exception{
		LayUIJSON<CspAdminMenu> msg=new LayUIJSON<CspAdminMenu>();
//		msg.setCount((long) cspAdminMenuService.getCount());
//		int No;
//		No=(page-1)*limit;
//		List<CspAdminMenu> getMenu=cspAdminMenuService.selectMenuLimit(No, limit);
//		for(CspAdminMenu menu:getMenu) {
//			int id=menu.getId();
//			CspAdminMenu get=cspAdminMenuService.getById(id);
//			menu.setpName(get.getName());
//		}
//		msg.setData(getMenu);
//		//System.out.println(cspAdminMenuService.selectMenuLimit(No, count));
		return msg;
		
	}
//	@RequestMapping("/hello")
//    public String Hello(@RequestParam("name")String name){
//		System.out.println("进入服务");
//		System.out.println(name);
//        String name1=helloRemote.Hello(name);
//        return name1;
//    }
}
