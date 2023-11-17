package com.zdslogic.server.books.domain;

import java.io.Serializable;

public class BookAuthorEntityKey implements Serializable {
	
	private Integer bookId;

	private Integer authorId;

    // default constructor

    public BookAuthorEntityKey(Integer bookId, Integer authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

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
 
}

