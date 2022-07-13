package com.example.springboot2.Service;

import java.util.List;

import com.example.springboot2.entities.Course;



public interface CourseService {
	
	

	public List<Course> getCourses();
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);
}