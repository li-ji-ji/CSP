package cn.lhj.csp.news.po;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="comment")
public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field("_id")
	private String id;//评论编号
	
	private String newsId;//新闻编号
	
	private String commentContent;//评论内容
	
	private String commentTime;//评论时间
	
	private String commentorId;//评论者编号
	
	private String commentorName;//评论者
	
	private Integer commentLikenum;//评论数
	
	private Integer commentStatus;//评论状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentorId() {
		return commentorId;
	}

	public void setCommentorId(String commentorId) {
		this.commentorId = commentorId;
	}

	public String getCommentorName() {
		return commentorName;
	}

	public void setCommentorName(String commentorName) {
		this.commentorName = commentorName;
	}

	public Integer getCommentLikenum() {
		return commentLikenum;
	}

	public void setCommentLikenum(Integer commentLikenum) {
		this.commentLikenum = commentLikenum;
	}

	public Integer getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
