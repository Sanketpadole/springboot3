package com.example.springboot2.Dto;

public class UserRoleEntityDto {
	private Integer id;
	private Integer Roleid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return Roleid;
	}

	public void setRoleid(Integer roleid) {
		Roleid = roleid;
	}

	public UserRoleEntityDto(Integer id, Integer roleid) {
		super();
		this.id = id;
		Roleid = roleid;
	}

	public UserRoleEntityDto() {
		super();

	}

	@Override
	public String toString() {
		return "UserRoleEntityDto [id=" + id + ", Roleid=" + Roleid + "]";
	}

}
