package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.Tutorial;
//
//import com.bezkoder.spring.files.excel.model.Tutorial;
@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
