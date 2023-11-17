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

import com.zdslogic.server.books.domain.ShippingMethodEntity;
import com.zdslogic.server.books.repo.ShippingMethodRepository;
import com.zdslogic.server.books.service.ShippingMethodService;

@Service
public class ShippingMethodServiceImpl implements ShippingMethodService {
	
	private static final Logger logger = LoggerFactory.getLogger(ShippingMethodServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private ShippingMethodRepository shippingMethodRepo;
	
	@Override
	public Page<ShippingMethodEntity> findShippingMethods(Pageable pageable) {
		return shippingMethodRepo.findAll(pageable);
	}

	@Override
	public ShippingMethodEntity getShippingMethod(Integer id) {

		Optional<ShippingMethodEntity> shippingMethodDTO = shippingMethodRepo.findById(id);
		ShippingMethodEntity shippingMethod = null;
		
		if(shippingMethodDTO.isPresent()) {
			shippingMethod = shippingMethodDTO.get();
		}
		
		return shippingMethod;
	}

	@Override
	public ShippingMethodEntity saveShippingMethod(ShippingMethodEntity shippingMethod) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		ShippingMethodEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = shippingMethodRepo.save(shippingMethod);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateShippingMethod(ShippingMethodEntity shippingMethod) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			shippingMethodRepo.saveAndFlush(shippingMethod);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteShippingMethod(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			shippingMethodRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*	
	@Override
	public ShippingMethodEntity findShippingMethod(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<ShippingMethodEntity> searchShippingMethods(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());
		return shippingMethodRepo.findByTitleLike(pageRequest, "%" + name + "%");
	}
*/
	
	@Override
	public Page<ShippingMethodEntity> searchShippingMethods(Pageable pageable, Specification<ShippingMethodEntity> spec) {

		return shippingMethodRepo.findAll(spec, pageable);

	}

	@Override
	public ShippingMethodEntity getShippingMethod(int id) {
		Optional<ShippingMethodEntity> shippingMethod = shippingMethodRepo.findById(id);

		return shippingMethod.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "Method_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
