//package cn.lhj.csp.news.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
//import cn.lhj.csp.news.feign.NewsApiInterface;
//import cn.lhj.csp.news.po.Category;
//import cn.lhj.csp.news.po.News;
//
//@Controller
//@RequestMapping("/news")
//public class NewsController {
//	@Autowired
//	 private AdminMenuApiInterface newsApiInterface;
//	
//	//跳到新闻列表
//		@RequestMapping("/toNewsList")
//		public String toNewsList(Model model,@RequestParam(value = "id", required = false) String id,
//				@RequestParam(value = "operation", required = false) String operation) {
//			
//			if (operation != null && operation.equals("isAudit")) {// 获取所有已审核新闻
//				List<News> newses = newsApiInterface.findAllNewsIsaudit();
//				
//				model.addAttribute("newses", newses);
//				return "ftl/news/news/newslist";
//			}
//			else if(operation != null && operation.equals("isNotAudit")) {//获取所有待审核新闻
//				List<News> newses = newsApiInterface.findAllNewsIsNotaudit();
//				
//				model.addAttribute("newses", newses);
//				return "ftl/news/news/newslist";
//			}
//			
//			//跳到新闻回收站
//			else if(operation != null && operation.equals("isDelete")) {//新闻回收站,获取所有为删除标记的新闻
//				List<News> newses = newsApiInterface.findAllIsdeleteNews();
//				
//				model.addAttribute("newses", newses);
//				return "ftl/news/news/newsrecycle";
//			}
//			
//			else {//获取所有非删除标记新闻
//				List<News> newses=newsApiInterface.findAllIsNotdeleteNews();
//				model.addAttribute("newses",newses);
//			
//				return "ftl/news/news/newslist";
//			}
//		}
//		
//		//跳到新闻添加
//		@RequestMapping("/toNewsAdd")
//		public String toNewsAdd(Model model) {
//			
//			List<Category> categories = newsApiInterface.findAllcategoryIsleaf();//从分类表获取所有叶子分类
//			
//			model.addAttribute("categories", categories);
//			
//			return "ftl/news/news/newsadd";
//		}
//		
//			//跳到新闻修改
//			@RequestMapping("/toNewsEdit")
//			public String toNewsEdit(Model model,@RequestParam("id") String id,
//					@RequestParam("operation") String operation) {
//				
//				if(operation != null && operation.equals("edit") && id != null) {
//					List<Category> categories = newsApiInterface.findAllcategoryIsleaf();//从分类表获取所有叶子分类
//					
//					News news = newsApiInterface.findOneNewsById(id);//根据id获取单个新闻信息
//					
//					model.addAttribute("news", news);
//					model.addAttribute("categories", categories);
//					
//					return "ftl/news/news/newsedit";
//				}
//				
//				else {
//					return "ftl/news/news/newslist";
//				}
//				
//				
//			}
//		
//		//添加一条新闻
//		@RequestMapping(value="/addNews",method=RequestMethod.POST)
//		public String addNews(News news) {
//			
//			Category category = newsApiInterface.findOnecategory(news.getCategoryId());//根据分类编号获取分类表信息
//			if(category!=null) {
//				news.setCategoryType(category.getCategorytype());//把分类类型赋值给新闻类型
//			}
//			
//			if (news.getIscate() == null) {//是否引用
//				news.setIscate(0);
//			} else {
//				news.setIscate(1);
//			}
//			
//			if (news.getIsaudit() == null) {//是否审核
//				news.setIsaudit(0);
//			} else {
//				news.setIsaudit(1);
//			}
//			
//			if (news.getIsdelete() == null) {//是否为删除标记
//				news.setIsdelete(0);
//			} else {
//				news.setIsdelete(1);
//			}
//			
//			if (news.getIsrecommend() == null) {//是否推荐
//				news.setIsrecommend(0);
//			} else {
//				news.setIsrecommend(1);
//			}
//			
//			if (news.getIsshow() == null) {//是否显示
//				news.setIsshow(0);
//			} else {
//				news.setIsshow(1);
//			}
//			
//			if (news.getIstop() == null) {//是否置顶
//				news.setIstop(0);
//			} else {
//				news.setIstop(1);
//			}
//			
//			
//			newsApiInterface.insertOneEntity(news);
//			
//			return "redirect:toNewsList";
//		}
//		
//		
//		//更新一条数据
//		@RequestMapping("/updateNews")
//		public String updateNews(News news) {
//			
//			Category category = newsApiInterface.findOnecategory(news.getCategoryId());//根据分类编号获取分类表信息
//			if(category!=null) {
//				news.setCategoryType(category.getCategorytype());//把分类类型赋值给新闻类型
//			}
//			
//			if (news.getIscate() == null) {//是否引用
//				news.setIscate(0);
//			} else {
//				news.setIscate(1);
//			}
//			
//			if (news.getIsaudit() == null) {//是否审核
//				news.setIsaudit(0);
//			} else {
//				news.setIsaudit(1);
//			}
//			
//			if (news.getIsdelete() == null) {//是否为删除标记
//				news.setIsdelete(0);
//			} else {
//				news.setIsdelete(1);
//			}
//			
//			if (news.getIsrecommend() == null) {//是否推荐
//				news.setIsrecommend(0);
//			} else {
//				news.setIsrecommend(1);
//			}
//			
//			if (news.getIsshow() == null) {//是否显示
//				news.setIsshow(0);
//			} else {
//				news.setIsshow(1);
//			}
//			
//			if (news.getIstop() == null) {//是否置顶
//				news.setIstop(0);
//			} else {
//				news.setIstop(1);
//			}
//			
//			newsApiInterface.updateOneEntity(news);
//			
//			return "redirect:toNewsList";
//		}
//		
//		
//			//把一条新闻设为删除标记，存入回收站
//			@RequestMapping("/deleteOneNewsInRecycle")
//			public String deleteOneNewsInRecycle(@RequestParam("id") String id,
//					@RequestParam("operation") String operation) {
//				if(operation != null && operation.equals("delInRecycle") && id != null) {//把一条新闻设为删除标记，存入回收站
//					News news = newsApiInterface.findOneNewsById(id);
//					if(news!=null) {
//						news.setIsdelete(1);//设置新闻为删除标记
//						newsApiInterface.updateOneEntity(news);
//					}
//				
//				}
//				return "redirect:toNewsList";
//			}
//			
//
//			//把多条新闻设为删除标记，存入回收站
//			@RequestMapping("/deleteNewsListInRecycle")
//			@ResponseBody
//			public String deleteOneNewsInRecycle(@RequestParam("idList") List<String> idList) {
//				String resultMsg="0";
//				if(idList.size()!=0) {//把多条新闻设为删除标记，存入回收站
//					List<News> newses = newsApiInterface.findAllByNewsIdList(idList);
//					if(newses != null) {
//						for(News news:newses) {
//							news.setIsdelete(1);//设置新闻为删除标记
//							newsApiInterface.updateOneEntity(news);
//						}
//						resultMsg="1";
//					}
//				}
//					return resultMsg;
//			}
//			
//
//			//批量删除回收站数据
//			@RequestMapping("/deleteNewsList")
//			@ResponseBody
//			public String deleteNewsList(@RequestParam("idList") List<String> idList) {
//				String resultMsg="0";
//				if(idList.size()!=0) {//把多条新闻设为删除标记，存入回收站
//					List<News> newses = newsApiInterface.findAllByNewsIdList(idList);
//					if(newses != null) {
//						for(News news:newses) {
//							newsApiInterface.deleteOneEntity(news);
//						}
//						resultMsg="1";
//					}
//				}
//				return resultMsg;
//			}
//			
//			
//			
//			//还原一条新闻数据
//			@RequestMapping("/reductionOneNews")
//			public String reductionOneNews(@RequestParam("id") String id,
//					@RequestParam("operation") String operation) {
//				
//				if(operation != null && operation.equals("reduction") && id != null) {
//					News news = newsApiInterface.findOneNewsById(id);
//					news.setIsdelete(0);//设置新闻为非删除标记
//					newsApiInterface.updateOneEntity(news);
//				}
//				
//				
//				return "redirect:toNewsList";
//			}
//			
//					//删除一条新闻
//					@RequestMapping("/deleteOneNews")
//					public String deleteOneNews(@RequestParam("id") String id,
//							@RequestParam("operation") String operation) {
//						if(operation != null && operation.equals("del") && id != null) {//删除一条新闻
//							News news = newsApiInterface.findOneNewsById(id);
//							if(news!=null) {
//								newsApiInterface.deleteOneEntity(news);
//							}
//						
//						}
//						return "redirect:toNewsList";
//					}
//					
//					//根据新闻关键词模糊查询
//					@RequestMapping("/selectNewsByNewsKeyword")
//					public String selectNewsByNewsKeyword(Model model,@RequestParam("newsKeyword") String newsKeyword) {
//						List<News> newses = newsApiInterface.findAllNewsByNewsKeywordLike(newsKeyword);
//						model.addAttribute("newses", newses);
//						return "ftl/news/news/newslist";
//					}
//}
