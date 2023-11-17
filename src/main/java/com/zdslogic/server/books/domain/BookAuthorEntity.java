package com.zdslogic.server.books.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK_AUTHOR")
@IdClass(BookAuthorEntityKey.class)
public class BookAuthorEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="book_id", unique = true, nullable = false)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;

	@Id
	@Column(name="author_id", unique = true, nullable = false)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer authorId;

	@Column(name="author_name", nullable = true, length = 120)
	private String authorName;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
