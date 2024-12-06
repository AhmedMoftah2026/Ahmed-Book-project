package com.ahmed.book.service;

import com.ahmed.book.model.Book;
import com.ahmed.book.reposatory.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo Bookrepo;

    public Book findByid(Long id){
        return Bookrepo.findById(id).orElseThrow();
    }
    public List <Book> findByAll(){
        return Bookrepo.findAll();
    }
    public Book Insert(Book Book){
        if (Book.getId()!=null){
            throw new RuntimeException();
        }
        return Bookrepo.save(Book);
    }
    public Book udate(Book Book){
        if (Book.getId()==null){
            throw new RuntimeException();
        }
        return Bookrepo.save(Book);
    }

    public void deleteByid(Long id){
         Bookrepo.deleteById(id);
    }

}
