package cn.lhj.csp.news.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.news.po.Comment;
import cn.lhj.csp.news.service.CommentService;


@CrossOrigin
@RestController
public class CommentApi {

	@Autowired
	private CommentService commentService;
	
		//获取所有新闻
		@RequestMapping("/allcomment")
		public List<Comment> findAllComment(){
			return commentService.findAllComment();
		}
		
		
		//根据评论ID获取评论
		@RequestMapping("/findOneCommentById")
		public Comment findOneCommentById(@RequestParam("id") String id){
			return commentService.findOneCommentById(id);
		}
		
		
		//根据评论实体删除一条数据
		@RequestMapping("/deleteOneCommentEntity")
		public int deleteOneEntity(@RequestBody Comment comment) {
			return commentService.deleteOneEntity(comment);
		}
		
		
}
