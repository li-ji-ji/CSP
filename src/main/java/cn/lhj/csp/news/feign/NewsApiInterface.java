package cn.lhj.csp.news.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.news.po.Category;
import cn.lhj.csp.news.po.Comment;
import cn.lhj.csp.news.po.News;

/*
 *  已整合到AdminMenuFeignInterface中
 * */

@FeignClient(name= "csp-news")
public interface NewsApiInterface {

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
}
