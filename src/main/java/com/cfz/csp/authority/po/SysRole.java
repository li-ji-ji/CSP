package com.cfz.csp.authority.po;

import java.util.List;


public class SysRole {
    private Integer id;

    private Boolean available;

    private String description;

    private String role;
    
    private List<SysPermission> permissions;//一个角色具有多个权限

    public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", available=" + available + ", description=" + description + ", role=" + role
				+ ", permissions=" + permissions + "]";
	}
    
    
}