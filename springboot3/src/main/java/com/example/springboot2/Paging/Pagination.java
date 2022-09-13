package com.example.springboot2.Paging;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination {
	public Pagination() {
		super();
	}

	public Pageable getpage(String pageNumber, String pageSize) {
		return PageRequest.of(Integer.parseInt(pageNumber) - 1, Integer.parseInt(pageSize));
	}

}
