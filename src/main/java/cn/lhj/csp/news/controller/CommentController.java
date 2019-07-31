package cn.lhj.csp.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
import cn.lhj.csp.news.feign.NewsApiInterface;
import cn.lhj.csp.news.po.Comment;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	 private AdminMenuApiInterface newsApiInterface;
	
	//跳到评论列表
		@RequestMapping("/toCommentList")
		public String toCommentList(Model model) {
			
			List<Comment> comments = newsApiInterface.findAllComment();
			
			model.addAttribute("comments", comments);
			
			return "ftl/news/comment/commentlist";
		}
		
		
		//删除一条评论
		@RequestMapping("/deleteOneComment")
		public String deleteOneComment(@RequestParam("id") String id,
				@RequestParam("operation") String operation) {
			if(operation != null && operation.equals("del") && id != null) {//删除一条评论
				Comment comment = newsApiInterface.findOneCommentById(id);
				if(comment!=null) {
					newsApiInterface.deleteOneEntity(comment);
				}
			
			}
			return "redirect:toCommentList";
		}
}
