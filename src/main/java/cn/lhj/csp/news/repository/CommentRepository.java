package cn.lhj.csp.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.lhj.csp.news.po.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{

}
