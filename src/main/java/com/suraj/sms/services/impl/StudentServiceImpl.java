package com.suraj.sms.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.suraj.sms.dto.StudentDto;
import com.suraj.sms.entities.Student;
import com.suraj.sms.mappers.AddressMapper;
import com.suraj.sms.mappers.SchoolMapper;
import com.suraj.sms.mappers.StudentMapper;
import com.suraj.sms.repo.AddressRepo;
import com.suraj.sms.repo.StudentRepo;
import com.suraj.sms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired 
	private AddressRepo addressRepo;

	@Override
	public ResponseEntity<Map<String, Object>> getAllStudent() {

		Map<String, Object> map = new HashMap<>();
		map.put("data", studentRepo.findAll().stream().map(e -> StudentMapper.TO_STUDENT_DTO_PRIVIEW.apply(e).get())
				.collect(Collectors.toList()));
		map.put("success", true);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> getStudentById(Integer studentId) {

		Student student = studentRepo.findById(studentId).get();
		Map<String, Object> map = new HashMap<>();
		map.put("data", StudentMapper.TO_STUDENT_DTO_PRIVIEW.apply(student).get());
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> addStudent(StudentDto studentDto) {

		Student student = StudentMapper.TO_STUDENT.apply(studentDto).get();
		student.setSchool(SchoolMapper.TO_SCHOOL.apply(studentDto.getSchoolDto()).get());
		student.setAddresses(AddressMapper.TO_ADDRESSES.apply(studentDto.getAddressDtos()));
		Student save = studentRepo.save(student);
		
		if(Objects.nonNull(student.getAddresses())) {
			student.getAddresses().stream().forEach( e ->{
				e.setStudent(save);
				addressRepo.save(e);
			});
		}
		Map<String, Object> map = new HashMap<>();
		map.put("data", save.getStudentId());
		map.put("success", true);

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
