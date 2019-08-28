package cn.lhj.csp.assomanagement.po.student;

public class SysStudentRole {
    private Integer id;

    private Integer sn;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	@Override
	public String toString() {
		return "SysStudentRole [id=" + id + ", sn=" + sn + ", roleId=" + roleId + "]";
	}
    
}