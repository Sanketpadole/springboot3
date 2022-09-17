package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.Excel;

@Repository
public interface ExcelRepository extends JpaRepository<Excel, Long> {

}
