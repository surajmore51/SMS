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

import com.suraj.sms.dto.StudentDto;
import com.suraj.sms.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentApis {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllStudent() {

		return studentService.getAllStudent();
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable Integer studentId) {

		return studentService.getStudentById(studentId);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> addStudent(@RequestBody StudentDto studentDto) {

		return studentService.addStudent(studentDto);
	}
}
