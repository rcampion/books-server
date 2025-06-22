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

import com.zdslogic.server.plugins.books.domain.BookAddressStatusEntity;
import com.zdslogic.server.plugins.books.repo.AddressStatusRepository;
import com.zdslogic.server.plugins.books.service.BookAddressStatusService;

@Service("addressStatusService")
@Qualifier("addressStatusService")
public class BookAddressStatusServiceImpl implements BookAddressStatusService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookAddressStatusServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private AddressStatusRepository addressStatusRepo;
	
	@Override
	public Page<BookAddressStatusEntity> findAddressStatuses(Pageable pageable) {
		return addressStatusRepo.findAll(pageable);
	}

	@Override
	public BookAddressStatusEntity getAddressStatus(Integer id) {

		Optional<BookAddressStatusEntity> addressDTO = addressStatusRepo.findById(id);
		BookAddressStatusEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public BookAddressStatusEntity saveAddressStatus(BookAddressStatusEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		BookAddressStatusEntity result = null;

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
	public void updateAddressStatus(BookAddressStatusEntity address) {

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
	public void deleteAddressStatus(int id) {
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
	public AddressStatusEntity findAddressStatus(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<AddressStatusEntity> searchAddressStatuss(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<BookAddressStatusEntity> searchAddressStatuses(Pageable pageable, Specification<BookAddressStatusEntity> spec) {

		return addressStatusRepo.findAll(spec, pageable);

	}

	@Override
	public BookAddressStatusEntity getAddressStatus(int id) {
		Optional<BookAddressStatusEntity> address = addressStatusRepo.findById(id);

		return address.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "status_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
