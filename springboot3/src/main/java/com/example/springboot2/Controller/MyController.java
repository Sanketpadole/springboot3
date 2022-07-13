package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.CourseService;
import com.example.springboot2.entities.Course;



@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	public String home() {
		return "this is home page";
		
	}
	@GetMapping("/courses")
	
	public List<Course>getCourses()
	{
		return this.courseService.getCourses();
		
	}
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	
		public Course updateCourse(@RequestBody Course course) {
			return this.courseService.updateCourse(course);
		}
	

	}