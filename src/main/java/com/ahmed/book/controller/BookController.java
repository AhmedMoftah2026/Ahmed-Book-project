package com.ahmed.book.controller;

import com.ahmed.book.dto.BookDto;
import com.ahmed.book.entity.Book;
import com.ahmed.book.mapper.BookMapper;
import com.ahmed.book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final BookMapper bookMapper;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Book book = bookService.findById(id);

		BookDto dto = bookMapper.map(book);

		return ResponseEntity.ok(dto);
	}

	@GetMapping()
	public ResponseEntity<?> findAll() {

		return ResponseEntity.ok(bookService.findAll());
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid BookDto dto) {
		
		Book book = bookMapper.unMap(dto);

		return ResponseEntity.ok(bookService.insert(book));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Book entity) {

		return ResponseEntity.ok(bookService.update(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		bookService.deleteById(id);
		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/auther/{id}")
	public ResponseEntity<?> deleteByAutherId(@PathVariable Long id) {

		return ResponseEntity.ok(bookService.deleteByAutherId(id));
	}

}
