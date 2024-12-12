package com.ahmed.book.entity;

import com.ahmed.book.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;




//NamedStoredProcedureQuery
@NamedStoredProcedureQuery(name = "Book.getBookByAuther", 
procedureName = "GET_BOOK_BY_AUTHER", parameters = {
 @StoredProcedureParameter(mode = ParameterMode.IN, name = "auther_id_in", type = String.class),
 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "book_count", type = Integer.class)})

@SQLDelete(sql = "update books set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
@NamedEntityGraph(name = "loadAuther" , attributeNodes = @NamedAttributeNode("auther"))
@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity<Long> {
	
	@NotNull(message = "Should be enter book name")
	private String name ;
	
//	@Pattern(regexp = "")
	private double price;
	
	@Transient
	private double discounted;
	
	@Formula("(select count(*) from books)")
	private long bookCount;
	
	@NotNull
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "auther_id")
	private Auther auther;
	


}
