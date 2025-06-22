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

import com.zdslogic.server.plugins.books.domain.OrderStatusEntity;
import com.zdslogic.server.plugins.books.repo.OrderStatusRepository;
import com.zdslogic.server.plugins.books.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderStatusServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private OrderStatusRepository orderStatusRepo;
	
	@Override
	public Page<OrderStatusEntity> findOrderStatus(Pageable pageable) {
		return orderStatusRepo.findAll(pageable);
	}

	@Override
	public OrderStatusEntity getOrderStatus(Integer id) {

		Optional<OrderStatusEntity> orderStatusDTO = orderStatusRepo.findById(id);
		OrderStatusEntity orderStatus = null;
		
		if(orderStatusDTO.isPresent()) {
			orderStatus = orderStatusDTO.get();
		}
		
		return orderStatus;
	}

	@Override
	public OrderStatusEntity saveOrderStatus(OrderStatusEntity orderStatus) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		OrderStatusEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = orderStatusRepo.save(orderStatus);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateOrderStatus(OrderStatusEntity orderStatus) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			orderStatusRepo.saveAndFlush(orderStatus);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteOrderStatus(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			orderStatusRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*
	@Override
	public OrderStatusEntity findOrderStatus(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<OrderStatusEntity> searchOrderStatuss(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return orderStatusRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	
	@Override
	public Page<OrderStatusEntity> searchOrderStatuss(Pageable pageable, Specification<OrderStatusEntity> spec) {

		return orderStatusRepo.findAll(spec, pageable);

	}

	@Override
	public OrderStatusEntity getOrderStatus(int id) {
		Optional<OrderStatusEntity> orderStatus = orderStatusRepo.findById(id);

		return orderStatus.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "status_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
