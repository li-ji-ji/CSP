package cn.lhj.csp.admin.dto;

import java.io.Serializable;

public class AssoSchoolUnitDto implements Serializable {
	
	/*
	 *yzj
	 *2019
	 *2019年10月17日
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String unitNo;
	private String unitName;
	private String pUnitNo;
	public AssoSchoolUnitDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssoSchoolUnitDto(int id, String unitNo, String unitName, String pUnitNo) {
		super();
		this.id = id;
		this.unitNo = unitNo;
		this.unitName = unitName;
		this.pUnitNo = pUnitNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnitNo() {
		return unitNo;
	}
	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getpUnitNo() {
		return pUnitNo;
	}
	public void setpUnitNo(String pUnitNo) {
		this.pUnitNo = pUnitNo;
	}
	@Override
	public String toString() {
		return "AssoSchoolUnitDto [id=" + id + ", unitNo=" + unitNo + ", unitName=" + unitName + ", pUnitNo=" + pUnitNo
				+ "]";
	}
	
	
	
}
