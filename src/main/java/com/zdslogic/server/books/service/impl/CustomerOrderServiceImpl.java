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

import com.zdslogic.server.books.domain.CustomerOrderEntity;
import com.zdslogic.server.books.repo.CustomerOrderRepository;
import com.zdslogic.server.books.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerOrderServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private CustomerOrderRepository customerOrderRepo;
	
	@Override
	public Page<CustomerOrderEntity> findCustomerOrder(Pageable pageable) {
		return customerOrderRepo.findAll(pageable);
	}

	@Override
	public CustomerOrderEntity getCustomerOrder(Integer id) {

		Optional<CustomerOrderEntity> customerOrderDTO = customerOrderRepo.findById(id);
		CustomerOrderEntity customerOrder = null;
		
		if(customerOrderDTO.isPresent()) {
			customerOrder = customerOrderDTO.get();
		}
		
		return customerOrder;
	}

	@Override
	public CustomerOrderEntity saveCustomerOrder(CustomerOrderEntity customerOrder) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		CustomerOrderEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = customerOrderRepo.save(customerOrder);

			tx.commit();
			
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateCustomerOrder(CustomerOrderEntity customerOrder) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			customerOrderRepo.saveAndFlush(customerOrder);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteCustomerOrder(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			customerOrderRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

	@Override
	public CustomerOrderEntity findCustomerOrder(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*
	@Override
	public Page<CustomerOrderEntity> searchCustomerOrders(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return customerOrderRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<CustomerOrderEntity> searchCustomerOrders(Pageable pageable, Specification<CustomerOrderEntity> spec) {

		return customerOrderRepo.findAll(spec, pageable);

	}

	@Override
	public CustomerOrderEntity getCustomerOrder(int id) {
		Optional<CustomerOrderEntity> customerOrder = customerOrderRepo.findById(id);

		return customerOrder.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "order_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
