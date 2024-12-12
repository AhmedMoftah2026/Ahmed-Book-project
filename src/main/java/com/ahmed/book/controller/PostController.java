package com.ahmed.book.controller;

import com.ahmed.book.dto.PostDto;
import com.ahmed.book.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById (@PathVariable Long id) {
	
		return ResponseEntity.ok(postService.getPostById(id));
	}
	
	
	@GetMapping("")
	public ResponseEntity<?> getAllPost () {
	
		return ResponseEntity.ok(postService.getAllPost());
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addPost (@RequestBody PostDto dto) {
	
		return ResponseEntity.ok(postService.addPost(dto));
	}

}
