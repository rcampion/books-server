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

import com.zdslogic.server.books.domain.PublisherEntity;
import com.zdslogic.server.books.repo.PublisherRepository;
import com.zdslogic.server.books.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
	
	private static final Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private PublisherRepository publisherRepo;

	@Override
	public Page<PublisherEntity> findPublishers(Pageable pageable) {
		return publisherRepo.findAll(pageable);
	}

	@Override
	public PublisherEntity getPublisher(Integer id) {

		Optional<PublisherEntity> publisherDTO = publisherRepo.findById(id);
		PublisherEntity publisher = null;
		
		if(publisherDTO.isPresent()) {
			publisher = publisherDTO.get();
		}
		
		return publisher;
	}

	@Override
	public PublisherEntity savePublisher(PublisherEntity publisher) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		PublisherEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = publisherRepo.save(publisher);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updatePublisher(PublisherEntity publisher) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			publisherRepo.saveAndFlush(publisher);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deletePublisher(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			publisherRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}
	

/*
	@Override
	public PublisherEntity findPublisher(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<PublisherEntity> searchPublishers(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());
		return publisherRepo.findByTitleLike(pageRequest, "%" + name + "%");
	}
*/
	
	@Override
	public Page<PublisherEntity> searchPublishers(Pageable pageable, Specification<PublisherEntity> spec) {

		return publisherRepo.findAll(spec, pageable);

	}

	@Override
	public PublisherEntity getPublisher(int id) {
		Optional<PublisherEntity> publisher = publisherRepo.findById(id);

		return publisher.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "publisherName");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
