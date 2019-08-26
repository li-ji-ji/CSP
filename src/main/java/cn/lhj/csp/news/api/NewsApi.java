package cn.lhj.csp.news.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.news.po.News;
import cn.lhj.csp.news.service.NewsService;

@CrossOrigin
@RestController
public class NewsApi {

	@Autowired
	private NewsService newsService;
	
		//获取所有新闻
		@RequestMapping("/allnews")
		public List<News> findAllcategory(){
			return newsService.findAllNews();
		}
		
		//获取新闻总数
		@RequestMapping("/findAllNewsCount")
		public long findAllNewsCount() {
			return newsService.findAllNewsCount();
		}
		
		//分页查询新闻
		@RequestMapping("/findAllNewsPage")
		public List<News> findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
			return newsService.findAll(page, size);
		}
		
		
		//获取所有已审核的新闻
		@RequestMapping("/findAllNewsIsaudit")
		public List<News> findAllNewsIsaudit(){
			return newsService.findAllNewsIsaudit(1);
		}
		
		//获取所有未审核的新闻
		@RequestMapping("/findAllNewsIsNotaudit")
		public List<News> findAllNewsIsNotaudit(){
			return newsService.findAllNewsIsaudit(0);
		}
		
		//根据新闻是删除标记查询
		@RequestMapping("/findAllIsdeleteNews")
		public List<News> findAllIsdeleteNews(){
			return newsService.findAllIsdeleteNews(1);
		}
		
		//根据新闻不是删除标记查询
		@RequestMapping("/findAllIsNotdeleteNews")
		public List<News> findAllIsNotdeleteNews(){
			return newsService.findAllIsdeleteNews(0);
		}
		
		//根据新闻ID获取单个新闻信息
		@RequestMapping("/findOneNewsById")
		public News findOneNewsById(@RequestParam("id") String id) {
			return newsService.findOneNewsById(id);
		}
		
		
		//根据新闻实体添加一条数据
		@RequestMapping("/insertOneNewsEntity")
		public int insertOneEntity(@RequestBody News news) {
			return newsService.insertOneEntity(news);
		}
		
		
		//根据新闻实体更新一条数据
		@RequestMapping("/updateOneNewsEntity")
		public int updateOneEntity(@RequestBody News news) {
			return newsService.updateOneEntity(news);
		}
		
		
		//根据ID集合批量查询新闻
		@RequestMapping("/findAllByNewsIdList")
		public List<News> findAllByNewsIdList(@RequestParam("ids") List<String> ids){
			return newsService.findAllByNewsIdList(ids);
		}
		
		//根据新闻实体删除一条数据
		@RequestMapping("/deleteOneNewsEntity")
		public int deleteOneEntity(@RequestBody News news) {
			return newsService.deleteOneEntity(news);
		}
		
		//根据新闻关键词进行模糊查询
		@RequestMapping("/findAllNewsByNewsKeywordLike")
		public List<News> findAllNewsByNewsKeywordLike(@RequestParam("newsKeyword") String newsKeyword){
			return newsService.findAllNewsByNewsKeywordLike(newsKeyword);
		}
		
		
		//根据新闻分类类型查询所有新闻
		@RequestMapping("/findAllNewsByType")
		public List<News> findAllNewsByType(@RequestParam("categoryType") String categoryType){
			return newsService.findAllNewsByType(categoryType);
		}
		
		//根据分类类型分页查询所有新闻
		@RequestMapping("/findAllByCategoryType")
		public List<News> findAllByCategoryType(@RequestParam("categoryType") String categoryType,@RequestParam("page") Integer page,@RequestParam("size") Integer size){
			return newsService.findAllByCategoryType(categoryType, page, size);
		}
		
		//根据新闻编号查询使新闻点击数+1
		@RequestMapping("/updateNewsHits")
		public int updateNewsHits(@RequestParam("id") String id) {
			return newsService.updateNewsHits(id);
		}
		
}
