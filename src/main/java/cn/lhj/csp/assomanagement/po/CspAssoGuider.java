package cn.lhj.csp.assomanagement.po;

public class CspAssoGuider {
    private Integer id;

    private String tId;

    private String tName;

    private String tDepartment;

    private Integer assoNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettDepartment() {
        return tDepartment;
    }

    public void settDepartment(String tDepartment) {
        this.tDepartment = tDepartment == null ? null : tDepartment.trim();
    }

    public Integer getAssoNumber() {
        return assoNumber;
    }

    public void setAssoNumber(Integer assoNumber) {
        this.assoNumber = assoNumber;
    }
}