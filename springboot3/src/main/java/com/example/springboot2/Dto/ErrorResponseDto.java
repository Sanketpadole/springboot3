package com.example.springboot2.Dto;

public class ErrorResponseDto {

	private String message;
	private String msgkey;
	private Object Data;

	public ErrorResponseDto() {
		super();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgkey() {
		return msgkey;
	}

	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}

	public Object getData() {
		return Data;
	}

	public ErrorResponseDto(String message, String msgkey, Object data) {
		super();
		this.message = message;
		this.msgkey = msgkey;
		Data = data;
	}

	public void setData(Object data) {
		Data = data;
	}

}
