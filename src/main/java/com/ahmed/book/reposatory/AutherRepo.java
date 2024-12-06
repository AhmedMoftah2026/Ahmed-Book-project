package com.ahmed.book.reposatory;

import com.ahmed.book.model.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepo extends JpaRepository<Auther,Long> {
}
