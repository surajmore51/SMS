package com.suraj.sms.dto;

import java.util.List;

import com.suraj.sms.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	
	private Integer courseId;
	
	private String courseName;
	
	private String description;
	
	private List<StudentDto> studentsDtos;

}
