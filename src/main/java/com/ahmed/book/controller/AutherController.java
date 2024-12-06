package com.ahmed.book.controller;

import com.ahmed.book.model.Auther;
import com.ahmed.book.service.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auther")
public class AutherController {
    @Autowired
    private AutherService autherservice;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id){
        return ResponseEntity.ok(autherservice.findByid(id)) ;
    }
    @GetMapping("/findByAll")
    public ResponseEntity<?> findByAll(){
        return ResponseEntity.ok(autherservice.findByAll());
    }
    @PostMapping("/Insert")
    public ResponseEntity<?> Insert(@RequestBody Auther auther){

        return ResponseEntity.ok( autherservice.Insert(auther));
    }
    @PostMapping("/update")
    public ResponseEntity<?> udate(@RequestBody Auther auther){

        return ResponseEntity.ok(autherservice.udate(auther));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable Long id) {

        autherservice.deleteByid(id);
        return ResponseEntity.ok(null);
    }
}
