package com.ahmed.book.service;

import com.ahmed.book.base.BaseService;
import com.ahmed.book.entity.BookFavorate;
import com.ahmed.book.repository.BookFavorateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookFavorateService extends BaseService<BookFavorate, Long> {
	
	
	private final BookFavorateRepo bookFavorateRepo;
	
	public Optional<BookFavorate> findByAutherIdAndBookId (Long autherId , Long bookId){
		
		return bookFavorateRepo.findByAutherIdAndBookId(autherId, bookId);
	}

}
