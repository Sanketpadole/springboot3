package com.example.springboot2.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Dto.ExcelHelper;
import com.example.springboot2.Entities.Tutorial;
import com.example.springboot2.Repository.TutorialRepository;

//import com.bezkoder.spring.files.excel.helper.ExcelHelper;
//import com.bezkoder.spring.files.excel.model.Tutorial;
//import com.bezkoder.spring.files.excel.repository.TutorialRepository;

@Service
public class ExcelService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
    	System.out.println("gjgyu");
      List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
      System.out.println("gj");
      repository.saveAll(tutorials);
      System.out.println("hjbmm");
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Tutorial> tutorials = repository.findAll();

    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
    return in;
  }

  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}
