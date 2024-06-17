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

import com.suraj.sms.dto.SchoolDto;
import com.suraj.sms.services.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolsApi {

	@Autowired
	private SchoolService schoolService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllSchools() {

		return schoolService.getAllSchools();
	}

	@GetMapping("/{schoolId}")
	public ResponseEntity<Map<String, Object>> getSchool(@PathVariable Integer schoolId) {

		return schoolService.getSchool(schoolId);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> addShool(@RequestBody SchoolDto schoolDto) {

		return schoolService.addShool(schoolDto);
	}
}
