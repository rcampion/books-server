package com.zdslogic.server.plugins.books.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "BOOK")
public class BookEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="book_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(name = "isbn13", nullable = true)
	private String isbn13;
	
	@Size(min = 0, max = 255)
	@Column(name = "title", nullable = true, length = 120)
	private String title;
	
	@Column(name = "language_id", nullable = true)
	private Integer languageId;
	
	@Column(name = "num_pages", nullable = true)
	private Integer numPages;

	@Size(min = 0, max = 45)
	@Column(name = "author", nullable = true, length = 120)
	private String author;

	@Column(name = "author_id", nullable = true)
	private Integer authorId;

	@Column(name = "category", nullable = true)
	private Integer category;
	
	@Column(name = "publication_date")
	private Timestamp publicationDate;
	
	@Column(name = "publisher_id", nullable = true)
	private Integer publisherId;
	
	@Column(name = "price", nullable = true)
	private Float price;
	
	@Column(name = "qty", nullable = true)	
	private Integer qty;

	@Column(name = "image", nullable = true)
	private String image;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getNumPages() {
		return numPages;
	}

	public void setNumPages(Integer numPages) {
		this.numPages = numPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Timestamp getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Timestamp publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
