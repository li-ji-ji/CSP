package cn.lhj.csp.news.po;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Field("_id")
	private String id;//分类编号
	
	@Field("category_type")
	private String categorytype;//分类类型
	
	@Field("category_pid")
	private String categorypid;//分类父编号
	
	private Integer isleaf;//是否为叶子结点
	
	@Field("category_icon")
	private String categoryicon;//分类图标
	
	@Field("category_status")
	private Integer categorystatus;//分类状态
	
	@Field("category_level")
	private Integer categorylevel;//分类等级

	@Transient
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
