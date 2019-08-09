package cn.lhj.csp.news.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.lhj.csp.news.po.Category;
import cn.lhj.csp.news.repository.CategoryRepository;
import cn.lhj.csp.news.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired

    private CategoryRepository categoryRepository;

	@Override
	//获取所有分类
	public List<Category> findAllCategory(){
		//按分类等级排序
		Sort sort = new Sort(Sort.Direction.ASC,"categorylevel");
		return categoryRepository.findAll(sort);
	}

	//根据分类父Id获取分类信息
	@Override
	public Category findByPid(String categorypid) {
		Optional<Category> optional = categoryRepository.findById(categorypid);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}

	
	//根据分类Id获取所有子级分类
	@Override
	public List<Category> findAllById(String id) {
		return categoryRepository.findByCategorypid(id);
	}

	//获取所有叶子或非叶子分类
	@Override
	public List<Category> findAllCategoryIsleaf(Integer isleaf) {
		Sort sort = new Sort(Sort.Direction.ASC,"categorylevel");
		return categoryRepository.findByIsleaf(isleaf,sort);
	}

	//根据分类ID获得单个分类信息
	@Override
	public Category findOneById(String id) {
		Optional<Category> optional =categoryRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}

	//更新一条数据
	@Override
	public int updateOneEntity(Category category) {
		categoryRepository.save(category);
		return 1;
	}

	//添加一条数据
	@Override
	public int insertOneEntity(Category category) {
		categoryRepository.insert(category);
		return 1;
	}

	
	//删除一条数据
	public int deleteOneEntity(Category category ) {
		categoryRepository.delete(category);
		return 1;
	}
	
	
	
	 
}
