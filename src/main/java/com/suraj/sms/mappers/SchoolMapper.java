package com.suraj.sms.mappers;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import com.suraj.sms.dto.SchoolDto;
import com.suraj.sms.entities.School;
import com.suraj.sms.util.FunctionUtil;

public class SchoolMapper {

	private SchoolMapper() {
	}

	public static final Function<School, Optional<SchoolDto>> TO_SCHOOL_DTO = e -> {

		SchoolDto schoolDto = FunctionUtil.evalMapper(e, SchoolDto.class).get();
		if (Objects.nonNull(e.getStudents())) {
			schoolDto.setStudentDtos(StudentMapper.TO_STUDENT_DTOS.apply(e.getStudents()));
		}
		return Optional.of(schoolDto);
	};

	public static final Function<School, Optional<SchoolDto>> TO_SCHOOL_DTO_PRIVIEW = e -> FunctionUtil.evalMapper(e,
			SchoolDto.class);

	public static final Function<SchoolDto, Optional<School>> TO_SCHOOL = e -> FunctionUtil.evalMapper(e, School.class);

}
