package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.entities.Course;

public interface CourseDao extends JpaRepository<Course,Long>{

}
