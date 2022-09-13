package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Entities.Course;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public CourseServiceImpl() {

	}

	@Override
	public Course addCourse(Course course) {

		return courseRepository.save(course);

	}

	@Override
	public List<Course> getCourses(Integer pageNum, Integer pageSize) {

		PageRequest pages = PageRequest.of(pageNum, pageSize);
		Page<Course> result = courseRepository.findAll(pages);
		if (result.hasContent()) {
			return result.getContent();
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public ResponseEntity<?> getCourse(@PathVariable(value = "id") int courseId) {
		return new ResponseEntity<ErrorResponseDto>(
				new ErrorResponseDto("ErrorResponseDtosucces", "succes",
						courseRepository.findById(courseId).orElseThrow(
								() -> new ResourceNotFoundException("user not found with id:" + courseId))),
				HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> put(@PathVariable(value = "id") int courseId, Course course) {

		courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + courseId));
		course.setId(courseId);

		return new ResponseEntity<>(new ErrorResponseDto("succes", "succes", courseRepository.save(course)),
				HttpStatus.OK);
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);

	}

	@Override
	public Course updateCourse(Course course, int courseId) {

		return null;
	}

}
