package cn.lhj.csp.news.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.lhj.csp.news.po.Comment;
import cn.lhj.csp.news.repository.CommentRepository;
import cn.lhj.csp.news.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
    private CommentRepository commentRepository;

	@Override
	//获取所有评论
	public List<Comment> findAllComment() {
		//按评论时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"commentTime");
		return commentRepository.findAll(sort);
	}

	@Override
	//根据评论ID获取评论信息
	public Comment findOneCommentById(String id) {
		Optional<Comment> optional = commentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}

	}

	@Override
	//根据评论实体删除一条数据
	public int deleteOneEntity(Comment comment) {
		commentRepository.delete(comment);
		return 1;
	}

	@Override
	//根据新闻ID获取所有评论
	public List<Comment> findAllCommentByNewsId(String newsId) {
		//按评论时间排序
		Sort sort = new Sort(Sort.Direction.DESC,"commentTime");
		return commentRepository.findByNewsId(newsId, sort);
	}
	
	
	
}
