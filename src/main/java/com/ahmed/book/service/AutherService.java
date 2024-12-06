package com.ahmed.book.service;

import com.ahmed.book.model.Auther;
import com.ahmed.book.reposatory.AutherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutherService {
    @Autowired
    private AutherRepo autherRepo;

    public Auther findByid(Long id){
        return autherRepo.findById(id).orElseThrow();
    }
    public List <Auther> findByAll(){
        return autherRepo.findAll();
    }
    public Auther Insert(Auther auther){

        return autherRepo.save(auther);
    }
    public Auther udate(Auther auther){

        return autherRepo.save(auther);
    }

    public void deleteByid(Long id){
         autherRepo.deleteById(id);
    }

}
