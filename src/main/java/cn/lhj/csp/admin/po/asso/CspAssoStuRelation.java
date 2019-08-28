package cn.lhj.csp.admin.po.asso;

public class CspAssoStuRelation {
    private Integer id;

    private String assoId;

    private String assoName;

    private String stuId;

    private String stuName;

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

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }
}