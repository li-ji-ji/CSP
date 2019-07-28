package cn.lhj.csp.admin.po.asso;

public class CspAssoStuRelation {
    private Integer id;

    private String assoId;

    private String stuId;

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

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }
}