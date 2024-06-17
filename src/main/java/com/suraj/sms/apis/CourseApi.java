package com.suraj.sms.apis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.sms.dto.CourseDto;
import com.suraj.sms.entities.Course;
import com.suraj.sms.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseApi {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> getAllCourse(){
		return courseService.getAllCourse();
	}
	
	@GetMapping("{courseId}")
	public ResponseEntity<Map<String, Object>> getCourse(@PathVariable Integer courseId){
		return courseService.getCourse(courseId);
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> saveCourse(@RequestBody CourseDto course){
		return courseService.saveCourse(course);
	}

}
