package com.example.springboot2.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.entities.Course;
import com.example.springboot2.exception.ResourceNotFoundException;


@Service
public interface CourseService {
	
	
	

	
	public ResponseEntity<?> addCourse(int courseId);

	public void deleteCourse();

	public Course changePasswords(Course course,int id);
	
	public void deleteCourse(int id);


	public List<Course> getCourses(Integer pageNum, Integer pageSize);

	public ResponseEntity<?> getCourse(int id);

	public List<Course> getCourseList();

	public List<Course> getCourseo();

	ResponseEntity<?> getCourseById(int courseId);

	Course addCourse(Course course);

	Course updateById(Course course,int courseId) throws ResourceNotFoundException;

	public Course updateco(Course course,int courseId);

	public ResponseEntity<?> put(Course course,int courseId);
}