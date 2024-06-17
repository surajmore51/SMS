package com.suraj.sms.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

	private Integer schoolId;
	private String schoolName;
	private String schoolAbout;

	private List<StudentDto> studentDtos;
}
