package cn.lhj.csp.news.service;

import java.util.List;


import cn.lhj.csp.news.po.News;


public interface NewsService {
	
	//获取所有新闻
	List<News> findAllNews();
	
	//获取所有已审核或待审核的新闻
	List<News> findAllNewsIsaudit(Integer isaudit);
	
	//添加一条数据
	int insertOneEntity(News news);
	
	//根据新闻ID获取单个新闻信息
	News findOneNewsById(String id);
	
	//更新一条数据
	int updateOneEntity(News news);
	
	//删除一条数据
	int deleteOneEntity(News news);
	
	//根据新闻是否删除标记查询
	List<News> findAllIsdeleteNews(Integer isdelete);
	
	//根据新闻关键词进行模糊查询
	List<News> findAllNewsByNewsKeywordLike(String newsKeyword);
	
	//根据ID集合批量查询新闻
	List<News> findAllByNewsIdList(List<String> ids);
	
	//获取新闻总数
	long findAllNewsCount();

	//分页查询新闻
	List<News> findAll(Integer page, Integer size);
	
	//根据新闻分类类型查询所有新闻
	List<News> findAllNewsByType(String categoryType);

	//根据分类类型分页查询所有新闻
	List<News> findAllByCategoryType(String categoryType, Integer page, Integer size);

}
