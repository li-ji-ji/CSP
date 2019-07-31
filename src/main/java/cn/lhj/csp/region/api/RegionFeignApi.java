package cn.lhj.csp.region.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.region.feign.RegionApiInterface;
import cn.lhj.csp.region.po.Region2;

/*
 *通过feign获取数据
 * */
@RestController
@RequestMapping("/feign/region")
@CrossOrigin
public class RegionFeignApi {
	@Autowired
	 private RegionApiInterface regionApiInterface;
	
	//获取所有地区
	@RequestMapping("/allregion")
	 public List<Region2> findAllregion() {
		 return regionApiInterface.findAllRegion();
	 }
	
	
	//获取表region2所有数据返回JSON格式
		@RequestMapping("/areaAllJSON")
		public Map<String, Object> findAreaAllJSON(){
			return regionApiInterface.findAreaAllJSON();
		}
	

		
		//通过后台传参获取数据返回JSON格式，默认100条,根据关键字模糊查询地区
		@ResponseBody
		@RequestMapping("/areaParamJSON")
		public Map<String,Object> methodx(
		         @RequestParam(required=false,defaultValue="1") int page,
		         @RequestParam(required=false,defaultValue="100") int limit,
		         @RequestParam("keyWord") String keyWord
		    ){
			return regionApiInterface.methodx(page, limit, keyWord);
		}
	
		
		
		//获得所有一级地区返回JSON格式,默认100条
		@RequestMapping("/areaParent")
		public  Map<String,Object> findAllLevelOne(
					 @RequestParam(required=false,defaultValue="1") int page,
			         @RequestParam(required=false,defaultValue="100") int limit
				){
			return regionApiInterface.findAllLevelOne(page, limit);
		}
		
		
		//获取下级地区
		@RequestMapping("/areaChild")
		public List<Region2> findAllLevelTwo(@RequestParam("id") int id){
			return regionApiInterface.findAllLevelTwo(id);
		}
		

		//通过后台传参获取数据返回JSON格式，默认100条,根据id查询子地区
		@ResponseBody
		@RequestMapping("/areaParamJSON2")
		    public Map<String,Object> methodx2(
		            @RequestParam(required=false,defaultValue="1") int page,
		            @RequestParam(required=false,defaultValue="100") int limit,
		            @RequestParam("id") Integer id
		    ){
			return regionApiInterface.methodx2(page, limit, id);
		}
	
}
