package cn.lhj.csp.news.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.lhj.csp.news.po.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	//根据分类父Id查询
	 List<Category> findByCategorypid(String categorypid);
	 //根据分类是否为叶子查询
	 List<Category> findByIsleaf(Integer isleaf,Sort sort);
}
