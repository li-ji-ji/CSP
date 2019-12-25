package cn.lhj.csp.admin.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.lhj.csp.admin.po.asso.CspAssoManagement;
import cn.lhj.csp.admin.po.asso.CspAssoStudent;

public class AssoActivityFormDto implements Serializable {
	
    /*
	 *yzj
	 *2019
	 *2019年10月17日
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String activityId;
    private String activityName;
    private Integer activityStatus;
    private String activityAssoId;
    private String activityAssoName;
    private String activityOrganizerId;
    private String activityOrganizerName;
    private Integer activityNum;
    private Integer activityPartNum;
    private Date activityStartTime;
    private Date activityFinishTime;
    private String activityIntro;
    
    private List<CspAssoStudent> assoStuList;
    private List<CspAssoManagement> assoList;
	
    

	public AssoActivityFormDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AssoActivityFormDto(Integer id, String activityId, String activityName, Integer activityStatus,
			String activityAssoId, String activityAssoName, String activityOrganizerId, String activityOrganizerName,
			Integer activityNum, Integer activityPartNum, Date activityStartTime, Date activityFinishTime,
			String activityIntro, List<CspAssoStudent> assoStuList, List<CspAssoManagement> assoList) {
		super();
		this.id = id;
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityStatus = activityStatus;
		this.activityAssoId = activityAssoId;
		this.activityAssoName = activityAssoName;
		this.activityOrganizerId = activityOrganizerId;
		this.activityOrganizerName = activityOrganizerName;
		this.activityNum = activityNum;
		this.activityPartNum = activityPartNum;
		this.activityStartTime = activityStartTime;
		this.activityFinishTime = activityFinishTime;
		this.activityIntro = activityIntro;
		this.assoStuList = assoStuList;
		this.assoList = assoList;
	}
    
    
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getActivityAssoId() {
		return activityAssoId;
	}
	public void setActivityAssoId(String activityAssoId) {
		this.activityAssoId = activityAssoId;
	}
	public String getActivityAssoName() {
		return activityAssoName;
	}
	public void setActivityAssoName(String activityAssoName) {
		this.activityAssoName = activityAssoName;
	}
	public String getActivityOrganizerId() {
		return activityOrganizerId;
	}
	public void setActivityOrganizerId(String activityOrganizerId) {
		this.activityOrganizerId = activityOrganizerId;
	}
	public String getActivityOrganizerName() {
		return activityOrganizerName;
	}
	public void setActivityOrganizerName(String activityOrganizerName) {
		this.activityOrganizerName = activityOrganizerName;
	}
	public Integer getActivityNum() {
		return activityNum;
	}
	public void setActivityNum(Integer activityNum) {
		this.activityNum = activityNum;
	}
	public Integer getActivityPartNum() {
		return activityPartNum;
	}
	public void setActivityPartNum(Integer activityPartNum) {
		this.activityPartNum = activityPartNum;
	}
	public Date getActivityStartTime() {
		return activityStartTime;
	}
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	public Date getActivityFinishTime() {
		return activityFinishTime;
	}
	public void setActivityFinishTime(Date activityFinishTime) {
		this.activityFinishTime = activityFinishTime;
	}
	public String getActivityIntro() {
		return activityIntro;
	}
	public void setActivityIntro(String activityIntro) {
		this.activityIntro = activityIntro;
	}
	public List<CspAssoStudent> getAssoStuList() {
		return assoStuList;
	}
	public void setAssoStuList(List<CspAssoStudent> assoStuList) {
		this.assoStuList = assoStuList;
	}
	public List<CspAssoManagement> getAssoList() {
		return assoList;
	}
	public void setAssoList(List<CspAssoManagement> assoList) {
		this.assoList = assoList;
	}



	@Override
	public String toString() {
		return "AssoActivityFormDto [id=" + id + ", activityId=" + activityId + ", activityName=" + activityName
				+ ", activityStatus=" + activityStatus + ", activityAssoId=" + activityAssoId + ", activityAssoName="
				+ activityAssoName + ", activityOrganizerId=" + activityOrganizerId + ", activityOrganizerName="
				+ activityOrganizerName + ", activityNum=" + activityNum + ", activityPartNum=" + activityPartNum
				+ ", activityStartTime=" + activityStartTime + ", activityFinishTime=" + activityFinishTime
				+ ", activityIntro=" + activityIntro + ", assoStuList=" + assoStuList + ", assoList=" + assoList + "]";
	}
    
    
}
