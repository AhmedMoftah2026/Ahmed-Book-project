package com.ahmed.book.controller;

import com.ahmed.book.model.Book;
import com.ahmed.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findByid(id)) ;
    }
    @GetMapping("/findByAll")
    public ResponseEntity<?> findByAll(){
        return ResponseEntity.ok(bookService.findByAll());
    }
    @PostMapping("/Insert")
    public ResponseEntity<?> Insert(@RequestBody Book book){

        return ResponseEntity.ok( bookService.Insert(book));
    }
    @PostMapping("/update")
    public ResponseEntity<?> udate(@RequestBody Book book){

        return ResponseEntity.ok(bookService.udate(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable Long id) {

        bookService.deleteByid(id);
        return ResponseEntity.ok(null);
    }
}
