package com.example.springboot2.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.Course;

@Service
public interface CourseService {

	public void deleteCourse(int id);

	public List<Course> getCourses(Integer pageNum, Integer pageSize);

	Course addCourse(Course course);

	public ResponseEntity<?> getCourse(int courseId);

	ResponseEntity<?> put(int courseId, Course course);

	public Course updateCourse(Course course, int courseId);

}