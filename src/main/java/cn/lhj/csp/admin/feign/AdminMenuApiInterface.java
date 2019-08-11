package cn.lhj.csp.admin.feign;


import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.config.po.Config;
import cn.lhj.csp.config.po.ConfigCategory;
import cn.lhj.csp.news.po.Category;
import cn.lhj.csp.news.po.Comment;
import cn.lhj.csp.news.po.News;
import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;




@FeignClient(name="csp-assist")
public interface AdminMenuApiInterface {
	//获取所有后台菜单
	@RequestMapping(value="/getAll")
	public String getAll();
	//获取菜单表列名
	@RequestMapping(value="/getColumnName")
	public String getColumnName();
	//获取所有后台菜单以LayUI数据格式返回
	@RequestMapping(value="/getAllToLayUI")
	public String getAllToLayUI();
	//分页获取数据并以Layui数据格式返回
	@RequestMapping(value="/getMenuLimit")
	public String getMenuLimit(@RequestParam("page")Integer page,@RequestParam("limit")Integer count);
	//根据ID查询后台菜单
	@RequestMapping("/getById")
	public int getById(@RequestParam("id") Integer id)throws Exception;
	@RequestMapping("/getLayUIJSONByPid")
	public String getLayUIJSONByPid(@RequestParam("pid") Integer pid,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit)throws Exception;	
	//根据ID删除菜单
	@RequestMapping("/delById")
	public int delById(@RequestParam("id") Integer id)throws Exception;
	//更新菜单
	@RequestMapping("/updateOne")
	public int updateOne(@RequestParam("menu") String getMsg)throws Exception;
	//插入新菜单
	@RequestMapping("/addOne")
	public int addOne(@RequestParam("menu") String getMsg) throws Exception;
	
	/*配置管理*/
	@RequestMapping("/api/config/getAllConfig")
	public List<Config> getAllConfig();
	
	@RequestMapping("/api/config/layuigetAll")
	public Map<String, Object> layuigetAll(@RequestParam(value = "name") int page,
			@RequestParam(value = "limit") int limit);
	
	@RequestMapping("/api/config/getById")
	public Config getByIdConfig(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/config/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestBody Config config, @RequestParam(value="id",required = false, defaultValue = "0") int id);
	
	@RequestMapping("/api/config/updateEnableById")
	public void updateEnableById(@RequestParam(value = "id")Integer id,@RequestParam(value = "enable") String enable);
	
	@RequestMapping("/api/config/delete")
	public void delete(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/config/selectByType")
	public List<Config> selectByType(@RequestParam(value = "type")String type);
	
	@RequestMapping("/api/config/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile)throws Exception;
	
	@RequestMapping("/api/config/insert")
	public int insertConfigOne(@RequestBody Config config )throws Exception;
	
	@RequestMapping("/api/config/update")
	public int updateConfigOne(@RequestBody Config config )throws Exception;

	@RequestMapping("/api/config/getTypes")
	public List<String> getTypes();
	/*
	 * 配置分类
	 */
	@RequestMapping("/api/configCategory/getAll")
	public List<ConfigCategory> getAllConfigCategory();
	
	@RequestMapping("/api/configCategory/edit")
	public void editConfigCategory(@RequestParam("operation")String operation,@RequestParam("editid")String editid,@RequestParam("name")String name, @RequestParam(required = false, defaultValue = "0") int id);
	
	@RequestMapping("/api/configCategory/insert")
	public String insertConfigCategory(@RequestBody ConfigCategory configCategory);
	
	@RequestMapping("/api/configCategory/delete")
	public String deleteConfigCategory(@RequestParam("id")Integer id);
	
	@RequestMapping("/api/configCategory/update")
	public String updateConfigCategory(@RequestBody ConfigCategory configCategory);
	
	@RequestMapping("/api/configCategory/findById")
	public ConfigCategory findByIdConfigCategory(@RequestParam("id")Integer id);
	
	//新闻分类管理(Category)
	//页面级
	
	//根据分类Id获取所有子级分类
	@RequestMapping("/allcategoryByPid")
	public List<Category> findAllcategoryByPid(@RequestParam("id") String id);
	
	//获取所有分类
	@RequestMapping("/allcategory")
	public List<Category> findAllCategory();
	
	//获得所有叶子分类
	@RequestMapping("/allcategoryIsleaf")
	public List<Category> findAllcategoryIsleaf();
	
	//获得所有非叶子分类
	@RequestMapping("/allcategoryIsNotleaf")
	public List<Category> findAllcategoryIsNotleaf();
	
	//根据分类Id获得单个分类信息
	@RequestMapping("/onecategory")
	public Category findOnecategory(@RequestParam("id") String id);
	
	//根据分类父Id获取分类信息
	@RequestMapping("/findByPid")
	public Category findByPid(@RequestParam("categorypid") String categorypid);
	
	//根据分类实体更新一条数据
	@RequestMapping("/updateOneEntity")
	public int updateOneEntity(@RequestBody Category category);
	
	//根据分类实体添加一条数据
	@RequestMapping("/insertOneEntity")
	public int insertOneEntity(@RequestBody Category category);
	
	//根据分类实体删除一条数据
	@RequestMapping("/deleteOneEntity")
	public int deleteOneEntity(@RequestBody Category category);
	
	
	
	
	
	
	//新闻内容管理(News)
	//页面级
	
	//获取所有新闻
	@RequestMapping("/allnews")
	public List<News> findAllcategory();
	
	//获取所有已审核的新闻
	@RequestMapping("/findAllNewsIsaudit")
	public List<News> findAllNewsIsaudit();
	
	//获取所有未审核的新闻
	@RequestMapping("/findAllNewsIsNotaudit")
	public List<News> findAllNewsIsNotaudit();
	
	//根据新闻是删除标记查询
	@RequestMapping("/findAllIsdeleteNews")
	public List<News> findAllIsdeleteNews();
	
	//根据新闻不是删除标记查询
	@RequestMapping("/findAllIsNotdeleteNews")
	public List<News> findAllIsNotdeleteNews();
	
	//根据新闻ID获取单个新闻信息
	@RequestMapping("/findOneNewsById")
	public News findOneNewsById(@RequestParam("id") String id);
	
	//根据新闻实体添加一条数据
	@RequestMapping("/insertOneNewsEntity")
	public int insertOneEntity(@RequestBody News news);
	
	//根据新闻实体更新一条数据
	@RequestMapping("/updateOneNewsEntity")
	public int updateOneEntity(@RequestBody News news);
	
	//根据新闻实体删除一条数据
	@RequestMapping("/deleteOneNewsEntity")
	public int deleteOneEntity(@RequestBody News news);
	
	//根据ID集合批量查询新闻
	@RequestMapping("/findAllByNewsIdList")
	public List<News> findAllByNewsIdList(@RequestParam("ids") List<String> ids);
	
	//根据新闻关键词进行模糊查询
	@RequestMapping("/findAllNewsByNewsKeywordLike")
	public List<News> findAllNewsByNewsKeywordLike(@RequestParam("newsKeyword") String newsKeyword);
	
	
	
	
	
	
	//新闻评论管理(Comment)
	//页面级
	
	//获取所有新闻
	@RequestMapping("/allcomment")
	public List<Comment> findAllComment();
	
	//根据评论ID获取评论
	@RequestMapping("/findOneCommentById")
	public Comment findOneCommentById(@RequestParam("id") String id);
	
	//根据评论实体删除一条数据
	@RequestMapping("/deleteOneCommentEntity")
	public int deleteOneEntity(@RequestBody Comment comment);
	
	
	/*
	 *  地区管理
	 * */
	//数据级
	//查询所有地区
	@RequestMapping("/areaAll")
	public List<Region2> findAllRegion();
	
	
	//获取表region2所有数据返回JSON格式
	@RequestMapping("/areaAllJSON")
	public Map<String, Object> findAreaAllJSON();
	
	
	//通过后台传参获取数据返回JSON格式，默认100条,根据关键字模糊查询地区
	@ResponseBody
	@RequestMapping("/areaParamJSON")
	public Map<String,Object> methodx(
	         @RequestParam(required=false,defaultValue="1") int page,
	         @RequestParam(required=false,defaultValue="100") int limit,
	         @RequestParam("keyWord") String keyWord
	    );
	
	
	
	//获得所有一级地区返回JSON格式,默认100条
	@RequestMapping("/areaParent")
	public  Map<String,Object> findAllLevelOne(
				 @RequestParam(required=false,defaultValue="1") int page,
		         @RequestParam(required=false,defaultValue="100") int limit
			);
	
	
	//获取下级地区
	@RequestMapping("/areaChild")
	public List<Region2> findAllLevelTwo(@RequestParam("id") int id);
	
	//通过后台传参获取数据返回JSON格式，默认100条,根据id查询子地区
	@ResponseBody
	@RequestMapping("/areaParamJSON2")
	    public Map<String,Object> methodx2(
	            @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="100") int limit,
	            @RequestParam("id") Integer id
	    );
	
	
	
	//页面级
	//根据ID查询地区
	@RequestMapping("/selectByPrimaryKey")
	public Region2 selectByPrimaryKey(@RequestParam("id") Integer id);
	
	
	//根据父ID查询名称
	@RequestMapping("/findNameByParentId")
	public String findNameByParentId(@RequestParam("parentId") Integer parentId);
	
	
	//所有行数
	@RequestMapping("/countByExample")
	public int countByExample(@RequestBody Region2Example example);
	
	//根据分页条件及关键字查询数据
	@RequestMapping("/queryAllDataFromTable")
	public List<Region2> queryAllDataFromTable(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("keyWord") String keyWord);
	
	
	//根据对象更新地区
	@RequestMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody Region2 record);
	
	//根据ID查询子地区
	@RequestMapping("/selectSingleStageById")
	public List<Region2> selectSingleStageById(@RequestParam("id") Integer id);

	//添加子地区
	@RequestMapping("/insertSelective")
	public int insertSelective(@RequestBody Region2 record);
	
	//删除地区
	@RequestMapping("/deleteByPrimaryKey")
	public int deleteByPrimaryKey(@RequestParam("id") Integer id);
	
}
