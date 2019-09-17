package cn.yzj.shop.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectTreeDTO implements Serializable{
	private int id;
	private String name;
	private String icon;
	private String url;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private boolean open=false;
	private List<Object> children=new ArrayList<Object>();
	private boolean checked=true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public List<Object> getChildren() {
		return children;
	}
	public void setChildren(List<Object> children) {
		this.children = children;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
