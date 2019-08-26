package cn.lhj.csp.news.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.lhj.csp.news.po.News;
import cn.lhj.csp.news.repository.NewsRepository;
import cn.lhj.csp.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
    private NewsRepository newsRepository;

	@Override
	//获得所有新闻
	public List<News> findAllNews() {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		return newsRepository.findAll(sort);
	}

	
	@Override
	//获取所有已审核或待审核的新闻
	public List<News> findAllNewsIsaudit(Integer isaudit) {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		return newsRepository.findByIsaudit(isaudit,sort);
	}


	@Override
	//插入一条新闻
	public int insertOneEntity(News news) {
		newsRepository.insert(news);
		return 1;
	}


	@Override
	//根据新闻ID获取单个新闻信息
	public News findOneNewsById(String id) {
		Optional<News> optional = newsRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}


	@Override
	//更新一条数据
	public int updateOneEntity(News news) {
		newsRepository.save(news);
		return 1;
	}


	@Override
	//删除一条数据
	public int deleteOneEntity(News news) {
		newsRepository.delete(news);
		return 1;
	}


	@Override
	//根据新闻是否删除标记查询
	public List<News> findAllIsdeleteNews(Integer isdelete) {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		
		return newsRepository.findByIsdelete(isdelete, sort);
	}


	@Override
	//根据新闻关键词进行模糊查询
	public List<News> findAllNewsByNewsKeywordLike(String newsKeyword) {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		return newsRepository.findByNewsKeywordLike(newsKeyword,sort);
	}


	@Override
	//根据ID集合批量查询新闻
	public List<News> findAllByNewsIdList(List<String> ids) {
		Iterator<News> iterator = newsRepository.findAllById(ids).iterator();
		List<News> newses = new ArrayList<News>();
		while(iterator.hasNext()) {
			newses.add(iterator.next());
		}
		return newses;
	}
	
	@Override
	//获取新闻总数
	public long findAllNewsCount() {
		return newsRepository.count();
	}
	
	@Override
	//分页查询新闻
	public List<News> findAll(Integer page, Integer size) {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		Pageable pageable = new PageRequest(page-1,size,sort);
		return newsRepository.findAll(pageable).getContent();
	}
	
	@Override
	//根据分类类型分页查询所有新闻
	public List<News> findAllByCategoryType(String categoryType,Integer page, Integer size) {
		
		
		News news=new News();
		news.setCategoryType(categoryType);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("categoryType", GenericPropertyMatchers.contains());
                
		Example<News> example = Example.of(news, matcher); 
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		Pageable pageable = PageRequest.of(page-1,size,sort);
		Page<News> pages = newsRepository.findAll(example,pageable);

		return pages.getContent();
	}


	@Override
	//根据新闻分类类型查询所有新闻
	public List<News> findAllNewsByType(String categoryType) {
		//按新闻发布时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"newsPubdate");
		return newsRepository.findByCategoryType(categoryType, sort);
	}


	@Override
	//根据新闻编号查询使新闻点击数+1
	public int updateNewsHits(String id) {
		//根据新闻id查询单个新闻
		News news = findOneNewsById(id);
		int hits = news.getNewsHits();
		news.setNewsHits(hits+1);
		newsRepository.save(news);
		return 1;
	}
	
	
}
