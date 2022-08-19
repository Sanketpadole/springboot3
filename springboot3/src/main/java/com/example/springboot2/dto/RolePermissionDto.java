package com.example.springboot2.dto;

public class RolePermissionDto {
	private Integer Roleid;
	private Integer id;
	public Integer getRoleid() {
		return Roleid;
	}
	public void setRoleid(Integer roleid) {
		Roleid = roleid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RolePermissionDto(Integer roleid, Integer id) {
		super();
		Roleid = roleid;
		this.id = id;
	}
	public RolePermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
