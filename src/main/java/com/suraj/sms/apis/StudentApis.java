package com.suraj.sms.apis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("uploadFile")
	public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		System.out.println("File name"+multipartFile.getOriginalFilename());
		Map<String, Object> map = new HashMap<>();
		map.put("fie name:", multipartFile.getOriginalFilename());	
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
