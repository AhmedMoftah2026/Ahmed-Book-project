package com.ahmed.book.service;

import com.ahmed.book.base.BaseService;
import com.ahmed.book.entity.Auther;
import com.ahmed.book.entity.AuthorSearch;
import com.ahmed.book.error.DaplicateRecoredException;
import com.ahmed.book.repository.AutherRepo;
import com.ahmed.book.repository.AutherSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AutherService extends BaseService<Auther, Long> {

	private final AutherRepo autherRepo;
	
	@Override
	@Cacheable(value = "auther", key = "#root.methodName")
	public List<Auther> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	
	@Override
	@Cacheable(value = "auther", key = "#id")
//	@CachePut(value = "auther", key = "#id")
	public Auther findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
//	@CacheEvict(value = {"auther"} , key ="#root.methodName", allEntries = true)
	public Auther insert(Auther entity) {
		
	if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
		Optional<Auther> auther = findByEmail(entity.getEmail());
	
		log.info("author name is {} and email is {} " , entity.getFullName() , entity.getEmail());
				
		if(auther.isPresent()) {
			
			log.error("This email already found with anther author");
			throw new DaplicateRecoredException("This email already found with anther author");
		}

	}

		return super.insert(entity);
	}

	@Override
	@CacheEvict(value = {"auther"} , key ="#root.methodName", allEntries = true)
	public Auther update(Auther entity) {
//
//		Auther auther = findById(entity.getId());
//
//		auther.setFullName(entity.getFullName());
		return super.update(entity);
	}

	public List<Auther> findByAutherSpec(AuthorSearch search) {

		AutherSpec spec = new AutherSpec(search);

		return autherRepo.findAll(spec);

	}

//	@Async(value = "threadPoolTaskExecutor")
//	@Cacheable(value = "auther", key = "#email")
	public Optional<Auther> findByEmail(String email) {

		return autherRepo.findByEmail(email);
	}

}
