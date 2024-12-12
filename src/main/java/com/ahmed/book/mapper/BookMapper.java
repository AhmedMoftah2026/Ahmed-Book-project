package com.ahmed.book.mapper;

import com.ahmed.book.dto.BookDto;
import com.ahmed.book.entity.Book;
import com.ahmed.book.mapper.qualifier.BookFavorateFlagQualifierImpl;
import com.ahmed.book.mapper.qualifier.BookFavorateQualifier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AutherMapper.class, BookFavorateFlagQualifierImpl.class})
public interface BookMapper {

	@Mapping(target = "auther" , ignore = true)
	@Mapping(target = "autherName" , source = "auther.fullName")
	@Mapping(target = "autherEmail" , source = "auther.email")
	@Mapping(source = "." , target = "isFavorate" , qualifiedBy = {BookFavorateQualifier.class, BookFavorateQualifier.BookFavorateFlagMethodQualifier.class})
	BookDto map(Book entity);

	@Mapping(source = "autherName" , target = "auther.fullName")
	@Mapping(source = "autherEmail" , target = "auther.email")
	Book unMap(BookDto dto);
	
	

}
