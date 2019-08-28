package cn.lhj.csp.news.po;

import java.io.Serializable;

public class News implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;//新闻编号
	
	private String newsTitle;//新闻标题
	
	private String categoryId;//分类编号
	
	private String categoryType;//分类类型
	
	private String newsPubdate;//新闻发布时间
	
	private String newsPublisher;//新闻发布者
	
	private String newsKeyword;//新闻关键字
	
	private Integer iscate;//是否引用
	
	private Integer isaudit;//是否审核
	
	private String newsContent;//新闻内容
	
	private String newsPicture;//新闻图片
	
	private Integer isshow;//是否显示
	
	private Integer isdelete;//是否删除标记
	
	private String citeAddress;//引用地址
	
	private String citeAuthor;//引用作者
	
	private Integer istop;//是否置顶
	
	private Integer isrecommend;//是否推荐
	
	private Integer newsHits;//点击次数
	
	private Integer newsLikenum;//点赞数
	
	private Integer newsCommentCount;//新闻评论数

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getNewsPubdate() {
		return newsPubdate;
	}

	public void setNewsPubdate(String newsPubdate) {
		this.newsPubdate = newsPubdate;
	}

	public String getNewsPublisher() {
		return newsPublisher;
	}

	public void setNewsPublisher(String newsPublisher) {
		this.newsPublisher = newsPublisher;
	}

	public String getNewsKeyword() {
		return newsKeyword;
	}

	public void setNewsKeyword(String newsKeyword) {
		this.newsKeyword = newsKeyword;
	}

	public Integer getIscate() {
		return iscate;
	}

	public void setIscate(Integer iscate) {
		this.iscate = iscate;
	}

	public Integer getIsaudit() {
		return isaudit;
	}

	public void setIsaudit(Integer isaudit) {
		this.isaudit = isaudit;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsPicture() {
		return newsPicture;
	}

	public void setNewsPicture(String newsPicture) {
		this.newsPicture = newsPicture;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getCiteAddress() {
		return citeAddress;
	}

	public void setCiteAddress(String citeAddress) {
		this.citeAddress = citeAddress;
	}

	public String getCiteAuthor() {
		return citeAuthor;
	}

	public void setCiteAuthor(String citeAuthor) {
		this.citeAuthor = citeAuthor;
	}

	public Integer getIstop() {
		return istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public Integer getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(Integer isrecommend) {
		this.isrecommend = isrecommend;
	}


	public Integer getNewsHits() {
		return newsHits;
	}

	public void setNewsHits(Integer newsHits) {
		this.newsHits = newsHits;
	}

	public Integer getNewsLikenum() {
		return newsLikenum;
	}

	public void setNewsLikenum(Integer newsLikenum) {
		this.newsLikenum = newsLikenum;
	}

	public Integer getNewsCommentCount() {
		return newsCommentCount;
	}

	public void setNewsCommentCount(Integer newsCommentCount) {
		this.newsCommentCount = newsCommentCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
