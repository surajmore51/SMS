package com.suraj.sms.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.suraj.sms.dto.CourseDto;
import com.suraj.sms.entities.Course;

public interface CourseService {

	public ResponseEntity<Map<String,Object >> getAllCourse();
	
	public ResponseEntity<Map<String, Object>> getCourse( Integer courseId);
	
	public ResponseEntity<Map<String, Object>> saveCourse( CourseDto course);

}
