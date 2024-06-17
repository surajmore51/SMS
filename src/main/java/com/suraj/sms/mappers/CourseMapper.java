package com.suraj.sms.mappers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.suraj.sms.dto.CourseDto;
import com.suraj.sms.entities.Course;
import com.suraj.sms.util.FunctionUtil;

public class CourseMapper {
	
	private CourseMapper() {
		
	}
	
	public static final Function<Course, Optional<CourseDto>> TO_COURSE_DTO = e-> FunctionUtil.evalMapper(e, CourseDto.class);
	
	public static final Function<CourseDto, Optional<Course>> TO_COURSE = e-> FunctionUtil.evalMapper(e, Course.class);
	 
	public static final Function<Collection<Course>, List<CourseDto>> TO_COURSE_DTOS = e ->{
		return e.stream().map(s -> TO_COURSE_DTO.apply(s).get()).collect(Collectors.toList());
	};


}
