package cn.lhj.csp.news.service;

import java.util.List;

import cn.lhj.csp.news.po.Category;

public interface CategoryService {

	//获取所有分类
	List<Category> findAllCategory();
	
	//根据分类父Id获取分类信息
	Category findByPid(String categorypid);
	
	//根据分类Id获取所有子级分类
	List<Category> findAllById(String id);
	
	//获取所有叶子或非叶子分类
	List<Category> findAllCategoryIsleaf(Integer isleaf);
	
	//根据分类ID获得单个分类信息
	Category findOneById(String id);
	
	//更新一条数据
	int updateOneEntity(Category category);
	
	//添加一条数据
	int insertOneEntity(Category category);
	
	//删除一条数据
	int deleteOneEntity(Category category);
	
	
}
