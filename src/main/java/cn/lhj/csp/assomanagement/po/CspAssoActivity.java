package cn.lhj.csp.assomanagement.po;

import java.util.Date;

public class CspAssoActivity {
    private Integer id;

    private String activityId;

    private String activityName;

    private Integer activityStatus;

    private String activityAssoId;

    private Integer activityKindId;

    private String activityKindName;

    private String activityAssoName;

    private String activityOrganizerId;

    private String activityOrganizerName;

    private Integer activityPartStatus;

    private Integer activityNum;

    private Integer activityPartNum;

    private Date activityStartTime;

    private Date activityFinishTime;

    private String activityIntro;

    private String activityContent;

    private String activityImg;

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
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
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
        this.activityAssoId = activityAssoId == null ? null : activityAssoId.trim();
    }

    public Integer getActivityKindId() {
        return activityKindId;
    }

    public void setActivityKindId(Integer activityKindId) {
        this.activityKindId = activityKindId;
    }

    public String getActivityKindName() {
        return activityKindName;
    }

    public void setActivityKindName(String activityKindName) {
        this.activityKindName = activityKindName == null ? null : activityKindName.trim();
    }

    public String getActivityAssoName() {
        return activityAssoName;
    }

    public void setActivityAssoName(String activityAssoName) {
        this.activityAssoName = activityAssoName == null ? null : activityAssoName.trim();
    }

    public String getActivityOrganizerId() {
        return activityOrganizerId;
    }

    public void setActivityOrganizerId(String activityOrganizerId) {
        this.activityOrganizerId = activityOrganizerId == null ? null : activityOrganizerId.trim();
    }

    public String getActivityOrganizerName() {
        return activityOrganizerName;
    }

    public void setActivityOrganizerName(String activityOrganizerName) {
        this.activityOrganizerName = activityOrganizerName == null ? null : activityOrganizerName.trim();
    }

    public Integer getActivityPartStatus() {
        return activityPartStatus;
    }

    public void setActivityPartStatus(Integer activityPartStatus) {
        this.activityPartStatus = activityPartStatus;
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
        this.activityIntro = activityIntro == null ? null : activityIntro.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg == null ? null : activityImg.trim();
    }
}