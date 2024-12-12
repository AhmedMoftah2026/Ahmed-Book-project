package com.ahmed.book.repository;

import com.ahmed.book.entity.Auther;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AutherRepoTest {

	@Autowired
	AutherRepo autherRepo;

	@Test
	void findByEmailNotFoundTest() {

		Optional<Auther> auther = autherRepo.findByEmail("mail@gmail.com");

		assertEquals(false, auther.isPresent());

	}
	
}
