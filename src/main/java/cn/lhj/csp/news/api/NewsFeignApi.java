//package cn.lhj.csp.news.api;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.lhj.csp.news.feign.NewsApiInterface;
//import cn.lhj.csp.news.po.Category;
//import cn.lhj.csp.news.po.News;
//
///*
// *通过feign获取数据
// * */
//@RestController
//@RequestMapping("/feign/news")
//@CrossOrigin
//public class NewsFeignApi {
//
//	 @Autowired
//	 private NewsApiInterface newsApiInterface;
//	 
//	//新闻分类(Category)
//	//获取所有分类
//	@RequestMapping("/allcategory")
//	public List<Category> findAllCategory(){
//			return newsApiInterface.findAllCategory();
//	}
//	
//	//获得所有叶子分类
//	@RequestMapping("/allcategoryIsleaf")
//	public List<Category> findAllcategoryIsleaf(){
//		return newsApiInterface.findAllcategoryIsleaf();
//	}
//	
//	//根据分类Id获得单个分类信息
//	@RequestMapping("/onecategory")
//	public Category findOnecategory(@RequestParam("id") String id) {
//		return newsApiInterface.findOnecategory(id);
//	}
//	
//	
//	
//	
//	//新闻内容(News)
//	//根据新闻关键词进行模糊查询
//	@RequestMapping("/findAllNewsByNewsKeywordLike")
//	public List<News> findAllNewsByNewsKeywordLike(@RequestParam("newsKeyword") String newsKeyword){
//		return newsApiInterface.findAllNewsByNewsKeywordLike(newsKeyword);
//	}
//}
