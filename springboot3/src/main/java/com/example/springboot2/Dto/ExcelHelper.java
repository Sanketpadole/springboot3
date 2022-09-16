package com.example.springboot2.Dto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Entities.Tutorial;

//import com.bezkoder.spring.files.excel.model.Tutorial;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  static String SHEET = "Sheet1";
	 

  public static boolean hasExcelFormat(MultipartFile file) {
	  System.out.println("GJD");

    if (!TYPE.equals(file.getContentType())) {
//	  if(!TYPE.equals("xlsx")) {
		  System.out.println("gf"+TYPE);
      return false;
    }

    return true;
  }

  public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);
      System.out.println("jhef");
      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (Tutorial tutorial : tutorials) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(tutorial.getId());
        row.createCell(1).setCellValue(tutorial.getTitle());
        row.createCell(2).setCellValue(tutorial.getDescription());
        row.createCell(3).setCellValue(tutorial.getRole());
      }
      System.out.println("sasfj");
      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

  public static List<Tutorial> excelToTutorials(InputStream is) {
	  System.out.println("jggj"+is);
    try {
    	System.out.println("gyl");
//      Workbook workbook = new XSSFWorkbook(is);
    	Workbook workbook=new XSSFWorkbook(is);
      System.out.println("jgh"+workbook);
      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();
      System.out.println("hj"+sheet);
      List<Tutorial> tutorials = new ArrayList<Tutorial>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }
        System.out.println("ghq");
        Iterator<Cell> cellsInRow = currentRow.iterator();

        Tutorial tutorial = new Tutorial();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          System.out.println("wqhj");
          switch (cellIdx) {
         
          case 1:
            tutorial.setId((long) currentCell.getNumericCellValue());
            break;

          case 2:
            tutorial.setTitle(currentCell.getStringCellValue());
            break;
            

          case 3:
            tutorial.setDescription(currentCell.getStringCellValue());
            break;

          case 4:
            tutorial.setRole(currentCell.getStringCellValue());
            break;

          default:
            break;
          }
          System.out.println("efj");

          cellIdx++;
        }
        System.out.println("kjk");
        tutorials.add(tutorial);
        System.out.println("gkkglk"+tutorials);
      }

      workbook.close();

      return tutorials;
      
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}