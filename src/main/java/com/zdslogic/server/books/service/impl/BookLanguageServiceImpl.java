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

import com.zdslogic.server.books.domain.BookLanguageEntity;
import com.zdslogic.server.books.repo.BookLanguageRepository;
import com.zdslogic.server.books.service.BookLanguageService;

@Service
public class BookLanguageServiceImpl implements BookLanguageService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookLanguageServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private BookLanguageRepository bookLanguageRepo;
	
	@Override
	public Page<BookLanguageEntity> findBookLanguages(Pageable pageable) {
		return bookLanguageRepo.findAll(pageable);
	}

	@Override
	public BookLanguageEntity getBookLanguage(Integer id) {

		Optional<BookLanguageEntity> addressDTO = bookLanguageRepo.findById(id);
		BookLanguageEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public BookLanguageEntity saveBookLanguage(BookLanguageEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		BookLanguageEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = bookLanguageRepo.save(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateBookLanguage(BookLanguageEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			bookLanguageRepo.saveAndFlush(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteBookLanguage(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			bookLanguageRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*	
	@Override
	public BookLanguageEntity findBookLanguage(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<BookLanguageEntity> searchBookLanguages(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<BookLanguageEntity> searchBookLanguages(Pageable pageable, Specification<BookLanguageEntity> spec) {

		return bookLanguageRepo.findAll(spec, pageable);

	}

	@Override
	public BookLanguageEntity getBookLanguage(int id) {
		Optional<BookLanguageEntity> address = bookLanguageRepo.findById(id);

		return address.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "address_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
