package com.example.springboot2.Dto;

public class ListResponseDto {

	public ListResponseDto() {

	}

	public ListResponseDto(Object data, Integer count) {

		super();
		this.data = data;
		this.count = count;

	}

	public ListResponseDto(Integer count) {

		super();
		this.count = count;

	}

	private Object data;

	private Integer count;

	public Object getData() {

		return data;

	}

	public void setData(Object data) {

		this.data = data;

	}

	public Integer getCount() {

		return count;

	}

	public void setCount(Integer count) {

		this.count = count;

	}

}