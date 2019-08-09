package cn.lhj.csp.region.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;
import cn.lhj.csp.region.service.Region2Service;

@RestController
@CrossOrigin
public class Region2Controller {
	@Autowired
	private Region2Service region2Service;
	
	@RequestMapping("/areaAll")
	public List<Region2> findAllRegion() {
		return region2Service.selectAll();
	}
	
	//获取表region2所有数据返回JSON格式
	@RequestMapping("/areaAllJSON")
	public Map<String, Object> findAreaAllJSON() {
		Map<String, Object> maps = new HashMap<String, Object>();
		List<Region2> data=region2Service.selectAll();
		maps.put("code", 0);
		maps.put("msg", "");
		maps.put("count", data.size());
		maps.put("data", data);
		return maps;
	}
	
	//通过后台传参获取数据返回JSON格式，默认100条,根据关键字模糊查询地区
	@ResponseBody
    @RequestMapping("/areaParamJSON")
    public Map<String,Object> methodx(
            @RequestParam(value="page",required=false,defaultValue="1") int page,
            @RequestParam(value="limit",required=false,defaultValue="100") int limit,
            String keyWord
    ){
    List<Region2> data=region2Service.queryAllDataFromTable(page,limit,keyWord);
    for(Region2 item:data) {
    	if(item.getParentId()==0) {
    		item.setParentName("中国");
    	}
    	else {
    		item.setParentName(region2Service.findNameByParentId(item.getParentId()));
    	}
    }
    int count=  region2Service.queryAllCount(keyWord);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",data);
        return map;
    }

	//获得所有一级地区返回JSON格式,默认100条
	@RequestMapping("/areaParent")
	public  Map<String,Object> findAllLevelOne(
			 @RequestParam(required=false,defaultValue="1") int page,
	         @RequestParam(required=false,defaultValue="100") int limit
			) {
		List<Region2> data=region2Service.selectSingleStageByIdPage(page, limit);
		for(Region2 item:data) {
				item.setParentName("中国");
		}
		int count=  region2Service.queryAllCountByIdLevelOne();
		Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",data);
		return map;
	}
	
	@RequestMapping("/areaChild")
	public List<Region2> findAllLevelTwo(@RequestParam("id") int id) {
		return region2Service.selectSingleStageById(id);
	}
	

	//通过后台传参获取数据返回JSON格式，默认100条,根据id查询子地区
	@ResponseBody
    @RequestMapping("/areaParamJSON2")
    public Map<String,Object> methodx2(
            @RequestParam(required=false,defaultValue="1") int page,
            @RequestParam(required=false,defaultValue="100") int limit,
            Integer id
    ){
    List<Region2> data=region2Service.queryAllDataFromTableById(page,limit,id);
    for(Region2 item:data) {
			item.setParentName(region2Service.findNameByParentId(item.getParentId()));
	}
    int count=  region2Service.queryAllCountById(id);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",data);
        return map;
    }
	
	
	
	
	
	
	
	//根据ID查询地区
	@RequestMapping("/selectByPrimaryKey")
	public Region2 selectByPrimaryKey(@RequestParam("id") Integer id) {
		return region2Service.selectByPrimaryKey(id);
	} 
	
	
	
	//根据父ID查询名称
	@RequestMapping("/findNameByParentId")
	public String findNameByParentId(@RequestParam("parentId") Integer parentId) {
		return region2Service.findNameByParentId(parentId);
	} 
	
	
	//所有行数
	@RequestMapping("/countByExample")
	public int countByExample(@RequestBody Region2Example example) {
		return region2Service.countByExample(example);
	}
	
	//根据分页条件及关键字查询数据
	@RequestMapping("/queryAllDataFromTable")
	public List<Region2> queryAllDataFromTable(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("keyWord") String keyWord){
		if(keyWord.equals("nullable")||keyWord==null||keyWord.equals("")) {
			keyWord=null;
		}
		
		return region2Service.queryAllDataFromTable(page, limit, keyWord);
	}
	
	
	//根据对象更新地区
	@RequestMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody Region2 record) {
		return region2Service.updateByPrimaryKey(record);
	}
	
	
	//根据ID查询子地区
	@RequestMapping("/selectSingleStageById")
	public List<Region2> selectSingleStageById(@RequestParam("id") Integer id){
		return region2Service.selectSingleStageById(id);
	}
	
	
	//添加子地区
	@RequestMapping("/insertSelective")
    public int insertSelective(@RequestBody Region2 record) {
    	return region2Service.insertSelective(record);
    }
    
    //删除地区
	@RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestParam("id") Integer id) {
    	return region2Service.deleteByPrimaryKey(id);
    }
	
	
	
	
	
	
	
	
	
	

	
}
