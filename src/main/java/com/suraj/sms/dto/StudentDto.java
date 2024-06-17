package com.suraj.sms.dto;

import java.util.List;

import com.suraj.sms.entities.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Integer studentId;
	private String studentName;
	private String about;

	private SchoolDto schoolDto;
	
	private List<AddressDto> addressDtos;
	
	private List<CourseDto> courses;
}
