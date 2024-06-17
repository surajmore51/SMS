package com.suraj.sms.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.suraj.sms.dto.CourseDto;
import com.suraj.sms.entities.Course;
import com.suraj.sms.mappers.CourseMapper;
import com.suraj.sms.repo.CourseRepo;
import com.suraj.sms.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public ResponseEntity<Map<String, Object>> getAllCourse() {
		List<Course> findAll = courseRepo.findAll();
		Map<String, Object>  map = new HashMap<>();
		map.put("data", CourseMapper.TO_COURSE_DTOS.apply(findAll));
		map.put("Success", true);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> getCourse(Integer courseId) {
		Course course = courseRepo.findById(courseId).get();
		Map<String, Object> map = new HashMap<>();
		map.put("data", CourseMapper.TO_COURSE_DTO.apply(course).get());
		map.put("Success", true);
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveCourse(CourseDto courseDto) {
		Course course = CourseMapper.TO_COURSE.apply(courseDto).get();
		Course save = courseRepo.save(course);
		Map<String, Object> map = new HashMap<>();
		map.put("data", save);
		map.put("Success", true);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	
	

}
