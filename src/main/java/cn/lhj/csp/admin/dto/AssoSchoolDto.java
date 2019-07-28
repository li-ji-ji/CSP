package cn.lhj.csp.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AssoSchoolDto implements Serializable {
	
	private Integer id;
	private String schoolNo;
	private String schoolName;
	private Integer schoolAddressProvinceId;
	private Integer schoolAddressCityId;
	public AssoSchoolDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssoSchoolDto(Integer id, String schoolNo, String schoolName, Integer schoolAddressProvinceId,
			Integer schoolAddressCityId) {
		super();
		this.id = id;
		this.schoolNo = schoolNo;
		this.schoolName = schoolName;
		this.schoolAddressProvinceId = schoolAddressProvinceId;
		this.schoolAddressCityId = schoolAddressCityId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(String schoolNo) {
		this.schoolNo = schoolNo;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getSchoolAddressProvinceId() {
		return schoolAddressProvinceId;
	}
	public void setSchoolAddressProvinceId(Integer schoolAddressProvinceId) {
		this.schoolAddressProvinceId = schoolAddressProvinceId;
	}
	public Integer getSchoolAddressCityId() {
		return schoolAddressCityId;
	}
	public void setSchoolAddressCityId(Integer schoolAddressCityId) {
		this.schoolAddressCityId = schoolAddressCityId;
	}
	@Override
	public String toString() {
		return "AssoSchoolDto [id=" + id + ", schoolNo=" + schoolNo + ", schoolName=" + schoolName
				+ ", schoolAddressProvinceId=" + schoolAddressProvinceId + ", schoolAddressCityId="
				+ schoolAddressCityId + "]";
	}
	
	
	
}
