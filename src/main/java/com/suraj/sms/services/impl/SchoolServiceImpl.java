package com.suraj.sms.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.suraj.sms.dto.SchoolDto;
import com.suraj.sms.entities.School;
import com.suraj.sms.mappers.SchoolMapper;
import com.suraj.sms.repo.SchoolRepo;
import com.suraj.sms.services.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepo schoolRepo;

	@Override
	public ResponseEntity<Map<String, Object>> getAllSchools() {

		Map<String, Object> map = new HashMap<>();
		map.put("data", schoolRepo.findAll().stream().map(e -> SchoolMapper.TO_SCHOOL_DTO.apply(e).get()));
		map.put("success", true);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> getSchool(Integer schoolId) {

		Optional<School> school = schoolRepo.findById(schoolId);
		SchoolDto schoolDto = null;
		if (Objects.nonNull(school)) {
			schoolDto = SchoolMapper.TO_SCHOOL_DTO.apply(school.get()).get();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("data", schoolDto);
		map.put("success", true);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> addShool(SchoolDto schoolDto) {

		School school = SchoolMapper.TO_SCHOOL.apply(schoolDto).get();
		School save = schoolRepo.save(school);
		Map<String, Object> map = new HashMap<>();
		map.put("data", save.getSchoolId());
		map.put("success", true);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
