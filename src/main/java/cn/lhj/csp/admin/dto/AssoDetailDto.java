package cn.lhj.csp.admin.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class AssoDetailDto implements Serializable {
	
	private Integer id;
	private String assoId;
	private String assoName;
	private Integer assoStatus;
	private Integer assoExamined;
	private Integer assoGuiderId;
	private String assoLeader;
	private String assoAffiliateNo;
	private String assoAffiliateName;
	
	private Integer memberNum; //社团人数
	private List<Object> memberList; //社团成员
	
	public AssoDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssoDetailDto(Integer id, String assoId, String assoName, Integer assoStatus, Integer assoExamined,
			Integer assoGuiderId, String assoLeader, String assoAffiliateNo, String assoAffiliateName,
			Integer memberNum, List<Object> memberList) {
		super();
		this.id = id;
		this.assoId = assoId;
		this.assoName = assoName;
		this.assoStatus = assoStatus;
		this.assoExamined = assoExamined;
		this.assoGuiderId = assoGuiderId;
		this.assoLeader = assoLeader;
		this.assoAffiliateNo = assoAffiliateNo;
		this.assoAffiliateName = assoAffiliateName;
		this.memberNum = memberNum;
		this.memberList = memberList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssoId() {
		return assoId;
	}

	public void setAssoId(String assoId) {
		this.assoId = assoId;
	}

	public String getAssoName() {
		return assoName;
	}

	public void setAssoName(String assoName) {
		this.assoName = assoName;
	}

	public Integer getAssoStatus() {
		return assoStatus;
	}

	public void setAssoStatus(Integer assoStatus) {
		this.assoStatus = assoStatus;
	}

	public Integer getAssoExamined() {
		return assoExamined;
	}

	public void setAssoExamined(Integer assoExamined) {
		this.assoExamined = assoExamined;
	}

	public Integer getAssoGuiderId() {
		return assoGuiderId;
	}

	public void setAssoGuiderId(Integer assoGuiderId) {
		this.assoGuiderId = assoGuiderId;
	}

	public String getAssoLeader() {
		return assoLeader;
	}

	public void setAssoLeader(String assoLeader) {
		this.assoLeader = assoLeader;
	}

	public String getAssoAffiliateNo() {
		return assoAffiliateNo;
	}

	public void setAssoAffiliateNo(String assoAffiliateNo) {
		this.assoAffiliateNo = assoAffiliateNo;
	}

	public String getAssoAffiliateName() {
		return assoAffiliateName;
	}

	public void setAssoAffiliateName(String assoAffiliateName) {
		this.assoAffiliateName = assoAffiliateName;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public List<Object> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Object> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "AssoDetailDto [id=" + id + ", assoId=" + assoId + ", assoName=" + assoName + ", assoStatus="
				+ assoStatus + ", assoExamined=" + assoExamined + ", assoGuiderId=" + assoGuiderId + ", assoLeader="
				+ assoLeader + ", assoAffiliateNo=" + assoAffiliateNo + ", assoAffiliateName=" + assoAffiliateName
				+ ", memberNum=" + memberNum + ", memberList=" + memberList + "]";
	}
	
	
}
