package com.ahmed.book.entity;

import com.ahmed.book.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class BookFavorate  extends BaseEntity<Long> {
	
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "auther_id")
	private Auther auther;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "book_id")
	private Book book;

}
