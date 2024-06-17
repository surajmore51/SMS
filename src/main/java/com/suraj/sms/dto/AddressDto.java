package com.suraj.sms.dto;

import com.suraj.sms.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	
	private Integer addressId;
	
	private String street;
	
	private String cityName;
	
	private String country;
	
	private StudentDto studentDto;
}
