package com.ahmed.book.repository;

import com.ahmed.book.entity.Auther;
import com.ahmed.book.entity.AuthorSearch;
import com.ahmed.book.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AutherSpec implements Specification<Auther> {

	private AuthorSearch search;

	public AutherSpec(AuthorSearch search) {
		super();
		this.search = search;
	}

	@Override
	public Predicate toPredicate(Root<Auther> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		List<Predicate> predicates = new ArrayList<>();
		
		Join<Auther, Book> bookJoin = root.join("books", JoinType.LEFT);

		// auther name
		if (search.getAuthorName() != null && !search.getAuthorName().isEmpty()) {

			predicates.add(cb.like(root.get("name"), search.getAuthorName()));
		}

		// email
		if (search.getEmail() != null && !search.getEmail().isEmpty()) {

			predicates.add(cb.like(root.get("email"), search.getEmail()));
		}

		// email
		if (search.getIpAddress() != null && !search.getIpAddress().isEmpty()) {

			predicates.add(cb.like(root.get("ipAddress"), "%" + search.getIpAddress() + "%" ));
		}
		
		if (search.getBookName()!=null && !search.getBookName().isEmpty()) {
			predicates.add(cb.like(bookJoin.get("name"), "%" + search.getBookName()+ "%" ));
		}
		
		if (search.getPrice()!=null) {
			predicates.add(cb.greaterThanOrEqualTo(bookJoin.get("price"), search.getPrice()));
		}
		
		query.orderBy(cb.desc(root.get("id")));

		return cb.and(predicates.toArray(new Predicate[0]));

	}

}
