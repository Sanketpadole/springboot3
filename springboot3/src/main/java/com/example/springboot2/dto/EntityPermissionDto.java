package com.example.springboot2.dto;

public class EntityPermissionDto {
	private Integer id;

	private String actionName;

	private Boolean isSelected;

	public Integer getId() {
		return id;
	}

	public void setId(Integer integer) {
		this.id = integer;
	}

	public String getActionName() {
		return actionName;
	}

	public EntityPermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityPermissionDto(Integer id, String actionName, Boolean isSelected) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.isSelected = isSelected;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

}
