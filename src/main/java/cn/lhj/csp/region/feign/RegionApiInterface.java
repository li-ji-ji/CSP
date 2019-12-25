//package cn.lhj.csp.region.feign;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cn.lhj.csp.region.po.Region2;
//import cn.lhj.csp.region.po.Region2Example;
//
//
///*
// *  已整合到AdminMenuFeignInterface
// * */
//
//@FeignClient(name= "csp-region")
//@RequestMapping("/region")
//public interface RegionApiInterface {
//	
//	//数据级
//	//查询所有地区
//	@RequestMapping("/areaAll")
//	public List<Region2> findAllRegion();
//	
//	
//	//获取表region2所有数据返回JSON格式
//	@RequestMapping("/areaAllJSON")
//	public Map<String, Object> findAreaAllJSON();
//	
//	
//	//通过后台传参获取数据返回JSON格式，默认100条,根据关键字模糊查询地区
//	@ResponseBody
//	@RequestMapping("/areaParamJSON")
//	public Map<String,Object> methodx(
//	         @RequestParam(required=false,defaultValue="1") int page,
//	         @RequestParam(required=false,defaultValue="100") int limit,
//	         @RequestParam("keyWord") String keyWord
//	    );
//	
//	
//	
//	//获得所有一级地区返回JSON格式,默认100条
//	@RequestMapping("/areaParent")
//	public  Map<String,Object> findAllLevelOne(
//				 @RequestParam(required=false,defaultValue="1") int page,
//		         @RequestParam(required=false,defaultValue="100") int limit
//			);
//	
//	
//	//获取下级地区
//	@RequestMapping("/areaChild")
//	public List<Region2> findAllLevelTwo(@RequestParam("id") int id);
//	
//	//通过后台传参获取数据返回JSON格式，默认100条,根据id查询子地区
//	@ResponseBody
//	@RequestMapping("/areaParamJSON2")
//	    public Map<String,Object> methodx2(
//	            @RequestParam(required=false,defaultValue="1") int page,
//	            @RequestParam(required=false,defaultValue="100") int limit,
//	            @RequestParam("id") Integer id
//	    );
//	
//	
//	
//	//页面级
//	//根据ID查询地区
//	@RequestMapping("/selectByPrimaryKey")
//	public Region2 selectByPrimaryKey(@RequestParam("id") Integer id);
//	
//	
//	//根据父ID查询名称
//	@RequestMapping("/findNameByParentId")
//	public String findNameByParentId(@RequestParam("parentId") Integer parentId);
//	
//	
//	//所有行数
//	@RequestMapping("/countByExample")
//	public int countByExample(@RequestBody Region2Example example);
//	
//	//根据分页条件及关键字查询数据
//	@RequestMapping("/queryAllDataFromTable")
//	public List<Region2> queryAllDataFromTable(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("keyWord") String keyWord);
//	
//	
//	//根据对象更新地区
//	@RequestMapping("/updateByPrimaryKey")
//	public int updateByPrimaryKey(@RequestBody Region2 record);
//	
//	//根据ID查询子地区
//	@RequestMapping("/selectSingleStageById")
//	public List<Region2> selectSingleStageById(@RequestParam("id") Integer id);
//
//	//添加子地区
//	@RequestMapping("/insertSelective")
//	public int insertSelective(@RequestBody Region2 record);
//	
//	//删除地区
//	@RequestMapping("/deleteByPrimaryKey")
//	public int deleteByPrimaryKey(@RequestParam("id") Integer id);
//	
//}
