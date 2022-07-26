package com.example.springboot2.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot2.Paging.Pagination;
import com.example.springboot2.dao.CourseRepository;
import com.example.springboot2.dto.ErrorResponseDto;
//
//import com.example.springboot2.dao.CourseRepository;
//import com.example.springboot2.dao.CourseRepository;
import com.example.springboot2.entities.Course;
import com.example.springboot2.exception.ResourceNotFoundException;
//import com.example.springboot2.page.paginatina;



@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private  CourseRepository courseRepository;
	

	public CourseServiceImpl() {

	}


	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub

		
		return courseRepository.save(course);
		
	}


	public void deleteCourse(int id){
        courseRepository.deleteById(id);

    }



@Override
public void deleteCourse() {
	// TODO Auto-generated method stub
	
}

@Override
public List<Course> getCourses(Integer pageNum, Integer pageSize) {
	// TODO Auto-generated method stub
	
	    PageRequest pages= PageRequest.of(pageNum,pageSize);
	    Page<Course> result= courseRepository.findAll(pages);
	    if(result.hasContent()){
	        return result.getContent();
	    }
	    else {
	        return new ArrayList<>();
	    }
	}


@Override
public List<Course> getCourseList(){
    return courseRepository.findAll();
}


@Override
public List<Course> getCourseo() {
	// TODO Auto-generated method stub
	return courseRepository.findAll();
}




	@Override
	public ResponseEntity<?> getCourse(@PathVariable(value = "id") int courseId) {
		 return new ResponseEntity<ErrorResponseDto>(new ErrorResponseDto("succes", "succes", courseRepository.findById(courseId).orElseThrow(() ->new ResourceNotFoundException("user not found with id:" +courseId))), HttpStatus.ACCEPTED);
	}


@Override
public ResponseEntity<?> getCourseById(int courseId) {
	// TODO Auto-generated method stub
	return null;
}





@Override
public ResponseEntity<?> addCourse(int courseId) {
	// TODO Auto-generated method stub
	return null;
}


//@Override
//public Course changePasswords(Course course, int id) {
//	// TODO Auto-generated method stub
//	{
//
//		Course course1 = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
//		this.courseRepository.save(course);
//		return course;
//}
//}


@Override
public Course updateById(Course course, int courseId) throws ResourceNotFoundException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Course updateco(Course course, int courseId) {
	// TODO Auto-generated method stub
	return null;
}


public ResponseEntity<Course> put(@RequestBody Course course,@PathVariable int courseId) {
	Course c=this.courseRepository.findById(courseId).orElseThrow(() ->new ResourceNotFoundException("user not found"));
//	this.courseRepository.save(course);
//	return c;
		
	 Course cour= this.courseRepository.save(c);

	return new ResponseEntity<Course>(HttpStatus.ACCEPTED);
}



@Override
public Course changePasswords(Course course, int id) {
	// TODO Auto-generated method stub
	return null;
}


//@Override
//public Course updateco(Course course, int courseId) {
//	Course c=this.courseRepository.findById(courseId).orElseThrow();
//	
//	c.setTitle(courseId.ge);
//
//	return null;
//}



}










