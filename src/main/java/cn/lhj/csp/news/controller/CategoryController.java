package cn.lhj.csp.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.news.feign.NewsApiInterface;
import cn.lhj.csp.news.po.Category;


@Controller
@RequestMapping("/category")
public class CategoryController {

	 @Autowired
	 private NewsApiInterface newsApiInterface;
	
		// 跳转到分类列表
		@RequestMapping("/toCategoryList")
		public String toCategoryList(Model model, @RequestParam(value = "id", required = false) String id,
				@RequestParam(value = "operation", required = false) String operation) {

			if (operation != null && operation.equals("toChild") && id != null) {// 获取子级分类
				List<Category> categories = newsApiInterface.findAllcategoryByPid(id);

				for (Category category : categories) {
					if (category.getCategorypid().equals("0")) {
						category.setCategory_pname("无");
					} else {
						category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
					}

					// 判断是否有子集,若有，设置isleaf=0,否则设置isleaf=1
					List<Category> list = newsApiInterface.findAllcategoryByPid(category.getId());
					if (list.size() == 0) {
						category.setIsleaf(1);
					} else {
						category.setIsleaf(0);
					}
					newsApiInterface.updateOneEntity(category);

				}

				model.addAttribute("categories", categories);
				return "ftl/news/category/categorylist";
			}

			else if (operation != null && operation.equals("isLeaf")) {// 获取所有叶子分类
				List<Category> categories = newsApiInterface.findAllcategoryIsleaf();
				for (Category category : categories) {
					if (category.getCategorypid().equals("0")) {
						category.setCategory_pname("无");
					} else {
						category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
					}

					// 判断是否有子集,若有，设置isleaf=0,否则设置isleaf=1
					List<Category> list = newsApiInterface.findAllcategoryByPid(category.getId());
					if (list.size() == 0) {
						category.setIsleaf(1);
					} else {
						category.setIsleaf(0);
					}
					newsApiInterface.updateOneEntity(category);

				}
				model.addAttribute("categories", categories);
				return "ftl/news/category/categorylist";
			}

			else if (operation != null && operation.equals("isNotLeaf")) {// 获取所有非叶子分类
				List<Category> categories = newsApiInterface.findAllcategoryIsNotleaf();
				for (Category category : categories) {
					if (category.getCategorypid().equals("0")) {
						category.setCategory_pname("无");
					} else {
						category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
					}

					// 判断是否有子集,若有，设置isleaf=0,否则设置isleaf=1
					List<Category> list = newsApiInterface.findAllcategoryByPid(category.getId());
					if (list.size() == 0) {
						category.setIsleaf(1);
					} else {
						category.setIsleaf(0);
					}
					newsApiInterface.updateOneEntity(category);

				}
				model.addAttribute("categories", categories);
				return "ftl/news/category/categorylist";
			}

			else {// 获取所有分类
				List<Category> categories = newsApiInterface.findAllCategory();
				for (Category category : categories) {
					if (category.getCategorypid().equals("0")) {
						category.setCategory_pname("无");
					} else {
						category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
					}

					// 判断是否有子集,若有，设置isleaf=0,否则设置isleaf=1
					List<Category> list = newsApiInterface.findAllcategoryByPid(category.getId());
					if (list.size() == 0) {
						category.setIsleaf(1);
					} else {
						category.setIsleaf(0);
					}
				newsApiInterface.updateOneEntity(category);

				}
				model.addAttribute("categories", categories);
				return "ftl/news/category/categorylist";
			}

		}

		// 跳到分类修改
		@RequestMapping("/toCategoryEdit")
		public String toCategoryEdit(Model model, @RequestParam("id") String id,
				@RequestParam("operation") String operation) {

			if (operation != null && operation.equals("edit") && id != null) {

				List<Category> categories = newsApiInterface.findAllCategory();// 获得所有分类
				Category category = newsApiInterface.findOnecategory(id);// 获得单个分类
				if (category.getCategorypid().equals("0")) {
					category.setCategory_pname("无");
				} else {
					category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
				}
				model.addAttribute("category", category);
				model.addAttribute("categories", categories);
				return "ftl/news/category/categoryedit";
			}

			else {
				return "ftl/news/category/categorylist";
			}
		}

		// 更新一条数据
		@RequestMapping("/updateCategory")
		public String updateCategory(Category category) {
			if (category.getCategorystatus() == null) {
				category.setCategorystatus(0);
			} else {
				category.setCategorystatus(1);
			}
			if (category.getIsleaf() == null) {
				category.setIsleaf(0);
			} else {
				category.setIsleaf(1);
			}

			if (category.getCategorypid().equals("0")) {// 如果父ID为0的，不作为
			} else {// 父ID不为0，修改该父ID对应信息的isleaf字段值为0
				Category pcategory = newsApiInterface.findByPid(category.getCategorypid());
				pcategory.setIsleaf(0);
				newsApiInterface.updateOneEntity(pcategory);
			}

			newsApiInterface.updateOneEntity(category);

			// 若有子分类，更新其子分类信息,递归方法
			recursiveUpdate(category);

			return "redirect:toCategoryList";
		}

		// 递归更新所有子集分类等级
		public void recursiveUpdate(Category category) {
			List<Category> categories = newsApiInterface.findAllcategoryByPid(category.getId());
			if (categories != null) {
				for (Category child : categories) {
					child.setCategorylevel(category.getCategorylevel() + 1);
					newsApiInterface.updateOneEntity(child);
					recursiveUpdate(child);
				}
			}
		}

		// 跳到分类添加
		@RequestMapping("/toCategoryAdd")
		public String toCategoryAdd(Model model) {

			List<Category> categories = newsApiInterface.findAllCategory();
			for (Category category : categories) {
				if (category.getCategorypid().equals("0")) {
					category.setCategory_pname("无");
				} else {
					category.setCategory_pname(newsApiInterface.findByPid(category.getCategorypid()).getCategorytype());
				}

			}
			model.addAttribute("categories", categories);

			return "ftl/news/category/categoryadd";

		}

		// 添加一条数据
		@RequestMapping("/addCategory")
		public String addCategory(Category category) {
			if (category.getCategorystatus() == null) {
				category.setCategorystatus(0);
			} else {
				category.setCategorystatus(1);
			}
			if (category.getIsleaf() == null) {
				category.setIsleaf(0);
			} else {
				category.setIsleaf(1);
			}

			newsApiInterface.insertOneEntity(category);

			return "redirect:toCategoryList";
		}
		
		
		// 删除一条分类及其子分类
		@RequestMapping("/deleteCategory")
		public String deleteCategory(@RequestParam("id") String id,
				@RequestParam("operation") String operation) {
			
			if(operation != null && operation.equals("del") && id != null) {
				Category category = newsApiInterface.findOnecategory(id);
				
				//若有子分类，删除其子分类信息,递归方法
				recursiveDelete(category);
				
			}


			return "redirect:toCategoryList";
		}

		
		// 递归删除所有子集分类
		private void recursiveDelete(Category category) {
			List<Category> categories=newsApiInterface.findAllcategoryByPid(category.getId());//根据ID获取所有子集分类
			if(categories!=null) {
				for(Category child:categories) {
					recursiveDelete(child);
				}
			}
			
			newsApiInterface.deleteOneEntity(category);
		}
}
