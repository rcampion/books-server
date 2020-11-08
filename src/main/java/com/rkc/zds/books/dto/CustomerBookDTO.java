package com.rkc.zds.books.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerBook")
public class CustomerBookDTO {

	@Id
	@Column(name="id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "CustomerID", nullable = true, length = 20)
	private int customerId;
	
	@Column(name = "BookID", nullable = true, length = 20)
	private int bookId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}	
}
