package com.ahmed.book.mapper;

import com.ahmed.book.dto.AutherDto;
import com.ahmed.book.entity.Auther;
import org.mapstruct.*;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Set;

@Mapper(imports = {LocaleContextHolder.class})

public interface AutherMapper {
	
	@Mappings({
		@Mapping(source = "id" , target = "id"),
		@Mapping(target = "name" , expression = "java(LocaleContextHolder.getLocale().getLanguage() ==\"ar\" ? entity.getFullName() :  entity.getFullName())"),
		@Mapping(target = "ipAddress" , defaultValue = "192.135.125.2"),
	})
	AutherDto map (Auther entity);
	
	List<AutherDto> map (List<Auther> entity);
	
	Set<AutherDto> map (Set<Auther> entity);
	
	@Mapping(target = "fullName" , source = "name")
	Auther unMap (AutherDto dto);
	
	@Mapping(target = "fullName" , source = "name")
	@Mapping(target = "id" , ignore = true)
	@Mapping(target = "imagePath" , ignore = true)
	@Mapping(target = "bookCount" , ignore = true)
	@Mapping(target = "statusCode" , ignore = true)
	@Mapping(target = "deleted" , ignore = true)
	Auther unMap (AutherDto dto, @MappingTarget Auther t);
	
	List<Auther> unMap (List<AutherDto> dto);
	
	
	@AfterMapping
	default void mapName(Auther entity, @MappingTarget AutherDto dto) {

		if (entity.getFullName() != null) {
			String lang = LocaleContextHolder.getLocale().getLanguage();
			dto.setName(lang.equals("ar") ? entity.getFullName() : entity.getFullName());
		}
	}
	

}
