package com.suraj.sms.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.suraj.sms.dto.StudentDto;

public interface StudentService {

	public ResponseEntity<Map<String, Object>> getAllStudent();

	public ResponseEntity<Map<String, Object>> getStudentById(Integer studentId);

	public ResponseEntity<Map<String, Object>> addStudent(StudentDto studentDto);
}
