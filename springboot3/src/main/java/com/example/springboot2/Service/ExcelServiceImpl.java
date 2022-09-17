package com.example.springboot2.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Dto.ExcelHelper;
import com.example.springboot2.Entities.Excel;
import com.example.springboot2.Repository.ExcelRepository;

@Service
public class ExcelServiceImpl {
	@Autowired
	ExcelRepository repository;

	public void save(MultipartFile file) {
		try {

			List<Excel> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());

			repository.saveAll(tutorials);

		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public ByteArrayInputStream load() {
		List<Excel> tutorials = repository.findAll();

		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
		return in;
	}

	public List<Excel> getAllTutorials() {
		return repository.findAll();
	}
}
