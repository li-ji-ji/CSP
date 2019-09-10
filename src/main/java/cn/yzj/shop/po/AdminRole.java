package cn.yzj.shop.po;

public class AdminRole {
    private Short roleId;

    private String roleName;

    private String roleDesc;

    private String actList;

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getActList() {
        return actList;
    }

    public void setActList(String actList) {
        this.actList = actList == null ? null : actList.trim();
    }
}