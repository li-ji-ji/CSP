package cn.lhj.csp.news.service;

import java.util.List;

import cn.lhj.csp.news.po.Comment;


public interface CommentService {
	//获取所有评论
	List<Comment> findAllComment();
	
	//根据评论ID获取评论信息
	Comment findOneCommentById(String id);
	
	//根据评论实体删除一条数据
	int deleteOneEntity(Comment comment);
}
