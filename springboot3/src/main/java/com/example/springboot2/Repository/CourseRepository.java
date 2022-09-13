package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
