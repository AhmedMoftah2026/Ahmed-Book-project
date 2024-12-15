package com.ahmed.book.dto;

import com.ahmed.book.base.BaseDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class BookDto extends BaseDto<Long> {
		
	@NotBlank
	private String name ;
	
	@Min(value = 5)
	@Max(value = 5000)
	private double price;
	
	@NotNull
	private AutherDto auther;
	
	private String autherName;
	
	private String autherEmail;
	
	private Boolean isFavorate;

	private int x , y;
}
