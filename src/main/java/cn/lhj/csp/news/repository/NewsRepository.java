package cn.lhj.csp.news.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.lhj.csp.news.po.News;


public interface NewsRepository extends MongoRepository<News, String>{
	//根据新闻是否审核查询
	List<News> findByIsaudit(Integer isaudit,Sort sort);
	
	//根据新闻是否删除标记查询
	List<News> findByIsdelete(Integer isdelete,Sort sort);
	
	//根据新闻关键词进行模糊查询
	List<News> findByNewsKeywordLike(String newsKeyword,Sort sort);

	//根据新闻分类类型查询所有新闻
	List<News> findByCategoryType(String categoryType,Sort sort);
	
}
