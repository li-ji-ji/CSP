package cn.lhj.csp.news.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.lhj.csp.news.po.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{

	//根据新闻ID获取所有评论
	List<Comment> findByNewsId(String newsId,Sort sort);
}
