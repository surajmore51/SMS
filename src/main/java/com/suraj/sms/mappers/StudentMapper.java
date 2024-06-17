package com.suraj.sms.mappers;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.suraj.sms.dto.StudentDto;
import com.suraj.sms.entities.Student;

import com.suraj.sms.util.FunctionUtil;

public class StudentMapper {

	private StudentMapper() {
	}

	public static final Function<Student, Optional<StudentDto>> TO_STUDENT_DTO = e -> FunctionUtil.evalMapper(e,
			StudentDto.class);

	public static final Function<Collection<Student>, List<StudentDto>> TO_STUDENT_DTOS = e -> {

		return e.stream().map(s -> TO_STUDENT_DTO.apply(s).get()).collect(Collectors.toList());
	};

	public static final Function<Student, Optional<StudentDto>> TO_STUDENT_DTO_PRIVIEW = e -> {

		StudentDto studentDto = FunctionUtil.evalMapper(e, StudentDto.class).get();
		if (Objects.nonNull(e.getSchool())) {
			studentDto.setSchoolDto(SchoolMapper.TO_SCHOOL_DTO_PRIVIEW.apply(e.getSchool()).get());
		}
		if(Objects.nonNull(e.getAddresses())) {
			studentDto.setAddressDtos(AddressMapper.TO_ADDRESS_DTOS.apply(e.getAddresses()));
		}
		if(Objects.nonNull(e.getCourses())) {
			studentDto.setCourses(CourseMapper.TO_COURSE_DTOS.apply(e.getCourses()));
		}
		return Optional.of(studentDto);
	};

	public static final Function<StudentDto, Optional<Student>> TO_STUDENT = e -> FunctionUtil.evalMapper(e,
			Student.class);
}
