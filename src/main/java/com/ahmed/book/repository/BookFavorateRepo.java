package com.ahmed.book.repository;

import com.ahmed.book.base.BaseRepository;
import com.ahmed.book.entity.BookFavorate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookFavorateRepo extends BaseRepository<BookFavorate, Long> {
	
	
	Optional<BookFavorate> findByAutherIdAndBookId (Long autherId , Long bookId);
	
}
