package cn.lhj.csp.news.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.news.po.Category;
import cn.lhj.csp.news.service.CategoryService;

@CrossOrigin
@RestController
public class CategoryApi {

	@Autowired
	private CategoryService categoryService;
	
	//获取所有分类
	@RequestMapping("/allcategory")
	public List<Category> findAllCategory(){
		return categoryService.findAllCategory();
	}
	
	
	//根据分类Id获取所有子级分类
	@RequestMapping("/allcategoryByPid")
	public List<Category> findAllcategoryByPid(@RequestParam("id") String id){
		return categoryService.findAllById(id);
	}
	
	
	//获得所有叶子分类
	@RequestMapping("/allcategoryIsleaf")
	public List<Category> findAllcategoryIsleaf(){
		return categoryService.findAllCategoryIsleaf(1);
	}
	
	//获得所有非叶子分类
	@RequestMapping("/allcategoryIsNotleaf")
	public List<Category> findAllcategoryIsNotleaf(){
		return categoryService.findAllCategoryIsleaf(0);
	}
	
	//根据分类Id获得单个分类信息
	@RequestMapping("/onecategory")
	public Category findOnecategory(@RequestParam("id") String id){
		return categoryService.findOneById(id);
	}
	
	
	//根据分类父Id获取分类信息
	@RequestMapping("/findByPid")
	public Category findByPid(@RequestParam("categorypid") String categorypid) {
		return categoryService.findByPid(categorypid);
	}
	
	
	//根据分类实体更新一条数据
	@RequestMapping("/updateOneEntity")
	public int updateOneEntity(@RequestBody Category category) {
		return categoryService.updateOneEntity(category);
	}
	
	//根据分类实体添加一条数据
	@RequestMapping("/insertOneEntity")
	public int insertOneEntity(@RequestBody Category category) {
		return categoryService.insertOneEntity(category);
	}
	
	//根据分类实体删除一条数据
	@RequestMapping("/deleteOneEntity")
	public int deleteOneEntity(@RequestBody Category category) {
		return categoryService.deleteOneEntity(category);
	}
	
}
