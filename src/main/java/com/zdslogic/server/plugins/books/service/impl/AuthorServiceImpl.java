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

import com.zdslogic.server.plugins.books.domain.AuthorEntity;
import com.zdslogic.server.plugins.books.repo.AuthorRepository;
import com.zdslogic.server.plugins.books.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private AuthorRepository addressStatusRepo;
	
	@Override
	public Page<AuthorEntity> findAuthors(Pageable pageable) {
		return addressStatusRepo.findAll(pageable);
	}

	@Override
	public AuthorEntity getAuthor(Integer id) {

		Optional<AuthorEntity> addressDTO = addressStatusRepo.findById(id);
		AuthorEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public AuthorEntity saveAuthor(AuthorEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		AuthorEntity result = null;

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
	public void updateAuthor(AuthorEntity address) {

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
	public void deleteAuthor(int id) {
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
	public AuthorEntity findAuthor(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Page<AuthorEntity> searchAuthors(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<AuthorEntity> searchAuthors(Pageable pageable, Specification<AuthorEntity> spec) {

		return addressStatusRepo.findAll(spec, pageable);

	}

	@Override
	public AuthorEntity getAuthor(int id) {
		Optional<AuthorEntity> address = addressStatusRepo.findById(id);

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
