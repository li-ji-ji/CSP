package cn.lhj.csp.assomanagement.po;

import java.util.Date;

public class CspAssoManagement {
    private Integer id;

    private String assoId;

    private String assoName;

    private Integer assoStatus;

    private String assoAffiliateNo;

    private String assoAffiliateName;

    private Integer assoExamined;

    private Integer assoGuiderId;

    private String assoGuiderName;

    private String assoLeader;

    private Date assoEstablishmentTime;

    private Date assoModifyTime;

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
        this.assoId = assoId == null ? null : assoId.trim();
    }

    public String getAssoName() {
        return assoName;
    }

    public void setAssoName(String assoName) {
        this.assoName = assoName == null ? null : assoName.trim();
    }

    public Integer getAssoStatus() {
        return assoStatus;
    }

    public void setAssoStatus(Integer assoStatus) {
        this.assoStatus = assoStatus;
    }

    public String getAssoAffiliateNo() {
        return assoAffiliateNo;
    }

    public void setAssoAffiliateNo(String assoAffiliateNo) {
        this.assoAffiliateNo = assoAffiliateNo == null ? null : assoAffiliateNo.trim();
    }

    public String getAssoAffiliateName() {
        return assoAffiliateName;
    }

    public void setAssoAffiliateName(String assoAffiliateName) {
        this.assoAffiliateName = assoAffiliateName == null ? null : assoAffiliateName.trim();
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

    public String getAssoGuiderName() {
        return assoGuiderName;
    }

    public void setAssoGuiderName(String assoGuiderName) {
        this.assoGuiderName = assoGuiderName == null ? null : assoGuiderName.trim();
    }

    public String getAssoLeader() {
        return assoLeader;
    }

    public void setAssoLeader(String assoLeader) {
        this.assoLeader = assoLeader == null ? null : assoLeader.trim();
    }

    public Date getAssoEstablishmentTime() {
        return assoEstablishmentTime;
    }

    public void setAssoEstablishmentTime(Date assoEstablishmentTime) {
        this.assoEstablishmentTime = assoEstablishmentTime;
    }

    public Date getAssoModifyTime() {
        return assoModifyTime;
    }

    public void setAssoModifyTime(Date assoModifyTime) {
        this.assoModifyTime = assoModifyTime;
    }
}