package com.suraj.sms.mappers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.suraj.sms.dto.AddressDto;
import com.suraj.sms.entities.Address;
import com.suraj.sms.util.FunctionUtil;

public class AddressMapper {
	
	public static final Function<Address, Optional<AddressDto>> TO_ADDRESS_DTO = e ->{
		AddressDto addressDto = FunctionUtil.evalMapper( e, AddressDto.class).get();
		/*
		 * if(Objects.nonNull(e.getStudent())) { StudentDto studentDto =
		 * StudentMapper.TO_STUDENT_DTO.apply(e.getStudent()).get();
		 * addressDto.setStudentDto(studentDto); }
		 */
		return Optional.of(addressDto);
	};
	
	public static final Function<Collection<Address> , List<AddressDto>> TO_ADDRESS_DTOS = e ->{
		return e.stream().map(s -> TO_ADDRESS_DTO.apply(s).get()).collect(Collectors.toList());
	};
	
	public static final Function<AddressDto, Optional<Address>> TO_ADDRESS =e -> FunctionUtil.evalMapper(e,Address.class);
	
	public static final Function<Collection<AddressDto> , List<Address>> TO_ADDRESSES = e ->{
		return e.stream().map(s -> TO_ADDRESS.apply(s).get()).collect(Collectors.toList());
	};

}
