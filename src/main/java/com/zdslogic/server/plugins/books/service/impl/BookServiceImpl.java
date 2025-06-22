package com.zdslogic.server.plugins.books.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.BookEntity;
import com.zdslogic.server.plugins.books.domain.CustomerBookEntity;
import com.zdslogic.server.plugins.books.repo.BookRepository;
import com.zdslogic.server.plugins.books.repo.CustomerBookRepository;
import com.zdslogic.server.plugins.books.service.BookService;

@Service("bookService")
@Qualifier("bookService")
public class BookServiceImpl implements BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private CustomerBookRepository customerBookRepo;
	
	@Override
	public Page<BookEntity> findBooks(Pageable pageable) {
		return bookRepo.findAll(pageable);
	}

	@Override
	public BookEntity getBook(Integer id) {

		Optional<BookEntity> bookDTO = bookRepo.findById(id);
		BookEntity book = null;
		
		if(bookDTO.isPresent()) {
			book = bookDTO.get();
		}
		
		return book;
	}

	@Override
	public BookEntity saveBook(BookEntity book) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		BookEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = bookRepo.save(book);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateBook(BookEntity book) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			bookRepo.saveAndFlush(book);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteBook(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			bookRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}
/*
	@Override
	public BookEntity findBook(int id) {
		Optional<BookEntity> book = bookRepo.findByBookId(id);

		return book.get();
	}
*/
	
	@Override
	public Page<BookEntity> searchBooks(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return bookRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}

	@Override
	public Page<BookEntity> searchBooks(Pageable pageable, Specification<BookEntity> spec) {

		return bookRepo.findAll(spec, pageable);

	}

	@Override
	public BookEntity getBook(int id) {
		Optional<BookEntity> book = bookRepo.findById(id);

		return book.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "bookName");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
