package com.example.springboot2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.CourseService;
import com.example.springboot2.dao.CourseRepository;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.entities.Course;
import com.example.springboot2.exception.ErrorDetails;
import com.example.springboot2.exception.ResourceNotFoundException;












@RestController


@RequestMapping("/courses")
public class MyController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepository;

	

    @GetMapping("jj")
    public List<Course> getCourse(){
        return courseService.getCourseList();
    }
    

    

	
	
	
	

	
	

	
    @GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable(value = "id") int courseId) {
    	
    	return courseService.getCourse(courseId);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?>put(@RequestBody Course course,@PathVariable int courseId){
    	return courseService.put(course, courseId);
    }
    
    
//    @PutMapping("/{courseId}")
//    public ResponseEntity<?> updatethecourse(@RequestBody Course course,@PathVariable Integer courseId)
//    {
//    	
//    
//    	
//    	
//		return new ResponseEntity<>(c,HttpStatus.OK);
//    
//    }


		

	

	
	@GetMapping("oo")
	public List<Course> getCourseo() {
		return this.courseService.getCourseo();
	}
	
	@GetMapping
    public List<Course> getCountries(@RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestParam(required = false,defaultValue = "5") Integer pageSize)
    {


        return courseService.getCourses(pageNum,pageSize);
    }
	
	@PostMapping()
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	

	

	
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> changePasswords(@RequestBody Course course,@PathVariable(value = "id") int courseId){
//
//		Course course2=this.courseService.updateById(course, courseId);
//		return ResponseEntity.ok(course2);
//
//	}


	
	 @DeleteMapping("/{id}")
	    public void deleteCourse(@PathVariable int id) {
	    courseService.deleteCourse(id);
	 }
}
