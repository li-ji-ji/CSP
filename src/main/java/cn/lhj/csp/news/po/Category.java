package cn.lhj.csp.news.po;

import java.io.Serializable;


public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;//分类编号
	
	private String categorytype;//分类类型
	
	private String categorypid;//分类父编号
	
	private Integer isleaf;//是否为叶子结点
	
	private String categoryicon;//分类图标
	
	private Integer categorystatus;//分类状态
	
	private Integer categorylevel;//分类等级

	private String category_pname;//分类父名字

	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public String getCategorypid() {
		return categorypid;
	}

	public void setCategorypid(String categorypid) {
		this.categorypid = categorypid;
	}

	public Integer getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}

	public String getCategoryicon() {
		return categoryicon;
	}

	public void setCategoryicon(String categoryicon) {
		this.categoryicon = categoryicon;
	}

	public Integer getCategorystatus() {
		return categorystatus;
	}

	public void setCategorystatus(Integer categorystatus) {
		this.categorystatus = categorystatus;
	}

	public Integer getCategorylevel() {
		return categorylevel;
	}

	public void setCategorylevel(Integer categorylevel) {
		this.categorylevel = categorylevel;
	}

	public String getCategory_pname() {
		return category_pname;
	}

	public void setCategory_pname(String category_pname) {
		this.category_pname = category_pname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
	
	
	

	
	
	
	
}
