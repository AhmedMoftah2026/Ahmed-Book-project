package com.ahmed.book.mapper.qualifier;

import com.ahmed.book.entity.Book;
import com.ahmed.book.entity.BookFavorate;
import com.ahmed.book.service.BookFavorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@BookFavorateQualifier
@Component
public class BookFavorateFlagQualifierImpl {
	
	@Autowired
	private BookFavorateService bookFavorateService;
	

	public Boolean getIsFavorate (Book entity) {
		
		Optional<BookFavorate> bookFavorate = bookFavorateService.findByAutherIdAndBookId(entity.getId(), entity.getAuther().getId());
	
		return bookFavorate.isPresent() ? true : false;
	}

}
