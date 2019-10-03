package cn.lhj.csp.asso.po;

public class CspAssoSchoolUnit {
    private Integer id;

    private String unitNo;

    private String unitName;

    private String pUnitNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getpUnitNo() {
        return pUnitNo;
    }

    public void setpUnitNo(String pUnitNo) {
        this.pUnitNo = pUnitNo == null ? null : pUnitNo.trim();
    }
}