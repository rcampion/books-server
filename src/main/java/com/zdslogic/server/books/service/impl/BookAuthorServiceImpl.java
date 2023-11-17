package com.zdslogic.server.books.service.impl;

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

import com.zdslogic.server.books.domain.BookAuthorEntity;
import com.zdslogic.server.books.repo.BookAuthorRepository;
import com.zdslogic.server.books.service.BookAuthorService;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookAuthorServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private BookAuthorRepository addressStatusRepo;
	
	@Override
	public Page<BookAuthorEntity> findBookAuthors(Pageable pageable) {
		return addressStatusRepo.findAll(pageable);
	}

	@Override
	public BookAuthorEntity getBookAuthor(Integer id) {

		Optional<BookAuthorEntity> addressDTO = addressStatusRepo.findById(id);
		BookAuthorEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public BookAuthorEntity saveBookAuthor(BookAuthorEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		BookAuthorEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = addressStatusRepo.save(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateBookAuthor(BookAuthorEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			addressStatusRepo.saveAndFlush(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteBookAuthor(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			addressStatusRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}
	
/*
	@Override
	public BookAuthorEntity findBookAuthor(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<BookAuthorEntity> searchBookAuthors(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<BookAuthorEntity> searchBookAuthors(Pageable pageable, Specification<BookAuthorEntity> spec) {

		return addressStatusRepo.findAll(spec, pageable);

	}

	@Override
	public BookAuthorEntity getBookAuthor(int id) {
		Optional<BookAuthorEntity> address = addressStatusRepo.findById(id);

		return address.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "addressName");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
