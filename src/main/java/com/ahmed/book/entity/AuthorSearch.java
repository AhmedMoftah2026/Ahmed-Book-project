package com.ahmed.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSearch {
	
	private String authorName;
	
	private String email ;
	
	private String ipAddress;
	
	private String bookName ;
	
	private Double price;

	
}
