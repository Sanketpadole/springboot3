package com.example.springboot2.Dto;

public class RolePermissionDto {
	private Integer roleid;
	private Integer permissionid;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		roleid = roleid;
	}

	public Integer getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}

	public RolePermissionDto(Integer roleid, Integer permissionid) {
		super();
		roleid = roleid;
		this.permissionid = permissionid;
	}

	public RolePermissionDto() {
		super();

	}

}
