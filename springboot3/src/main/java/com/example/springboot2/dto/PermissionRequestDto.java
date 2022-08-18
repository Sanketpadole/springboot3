package com.example.springboot2.dto;

public class PermissionRequestDto {
	
	public String actionName;
	
	
	public String baseUrl;
	
	
	public String description;
	
	
	public String method;
	
	
	public String path;
	
	
	
	public PermissionRequestDto() {
		super();
		
	}



	public PermissionRequestDto(String actionName, String baseUrl, String description, String method, String path,
			Long entityId) {
		super();
		this.actionName = actionName;
		this.baseUrl = baseUrl;
		this.description = description;
		this.method = method;
		this.path = path;
		this.entityId = entityId;
	}



	public String getActionName() {
		return actionName;
	}



	public void setActionName(String actionName) {
		this.actionName = actionName;
	}



	public String getBaseUrl() {
		return baseUrl;
	}



	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getMethod() {
		return method;
	}



	public void setMethod(String method) {
		this.method = method;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public Long getEntityId() {
		return entityId;
	}



	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}



	public Long entityId;

}
