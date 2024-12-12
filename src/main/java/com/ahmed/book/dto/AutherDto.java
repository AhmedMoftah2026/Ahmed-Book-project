package com.ahmed.book.dto;

import com.ahmed.book.base.BaseDto;
import com.ahmed.book.validator.IpAddress;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
//@Builder
public class AutherDto extends BaseDto<Long> {
	
	@NotBlank
	private String name;
	
	@IpAddress()
	private String ipAddress;
	
	@Email(message = "{validation.constraints.email.message}")
	private String email;

	private long bookCount;

	private String imagePath;
	
	private Date createdDate;

}
