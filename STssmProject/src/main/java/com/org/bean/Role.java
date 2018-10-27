package com.org.bean;

public class Role {
	
	private int roleId;
	
	private String roleName;
	
	private String roleDesc;
	
	private String roleMark;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleMark() {
		return roleMark;
	}

	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleMark=" + roleMark
				+ "]";
	}

}
