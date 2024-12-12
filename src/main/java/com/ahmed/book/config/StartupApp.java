package com.ahmed.book.config;

import com.ahmed.book.entity.Auther;
import com.ahmed.book.entity.Book;
import com.ahmed.book.service.AutherService;
import com.ahmed.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

	@Autowired
	private AutherService autherService;

	@Autowired
	private BookService bookService;

	@Override
	public void run(String... args) throws Exception {

		// adding some data for authers
		if (autherService.findAll().isEmpty()) {
		Auther auther1 = new Auther();
		auther1.setFullName("ALi");

		Auther auther2 = new Auther();
		auther2.setFullName("Mohamed");

		Auther auther3 = new Auther();
		auther3.setFullName("Ahmed");

		autherService.insertAll(Arrays.asList(auther1, auther2, auther3));
		}
		// adding some data for books
		if(bookService.findAll().isEmpty()) {
		Book book = new Book();
		book.setName("Java JPA");
		book.setPrice(200);
		book.setAuther(autherService.getById(1L));

		Book book2 = new Book();
		book2.setName("Data Base Mysql");
		book2.setPrice(300);
		book2.setAuther(autherService.getById(1L));

		Book book3 = new Book();
		book3.setName("Python");
		book3.setPrice(120);
		book3.setAuther(autherService.findById(2L));


		bookService.insertAll(Arrays.asList(book,book2, book3));
		}
	}

}
