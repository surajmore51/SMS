package com.suraj.sms.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.suraj.sms.dto.SchoolDto;

public interface SchoolService {

	public ResponseEntity<Map<String, Object>> getAllSchools();

	public ResponseEntity<Map<String, Object>> getSchool(Integer schoolId);

	public ResponseEntity<Map<String, Object>> addShool(SchoolDto schoolDto);
}
