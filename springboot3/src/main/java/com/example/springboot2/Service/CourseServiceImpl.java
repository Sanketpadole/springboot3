package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.CourseDao;
import com.example.springboot2.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
//	List<Course>list;
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(145,"java core course","this course contains basics of java"));
//		list.add(new Course(4343,"spring boot course","creating rest api using spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
//		return list;
		return courseDao.findAll();
		
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
//		return course;
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if (e.getId()==course.getId()) {
//				e.setTitle (course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
//	}
		courseDao.save(course);
		return course;
}
}