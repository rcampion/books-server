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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.BookEntity;
import com.zdslogic.server.plugins.books.domain.CustomerEntity;
import com.zdslogic.server.plugins.books.repo.CustomerRepository;
import com.zdslogic.server.plugins.books.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private CustomerRepository addressRepo;
	
	@Override
	public Page<CustomerEntity> findCustomers(Pageable pageable) {
		return addressRepo.findAll(pageable);
	}

	@Override
	public CustomerEntity getCustomer(Integer id) {

		Optional<CustomerEntity> addressDTO = addressRepo.findById(id);
		CustomerEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public CustomerEntity saveCustomer(CustomerEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		CustomerEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = addressRepo.save(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateCustomer(CustomerEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			addressRepo.saveAndFlush(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteCustomer(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			addressRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*	
	@Override
	public CustomerEntity findCustomer(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<CustomerEntity> searchCustomers(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<CustomerEntity> searchCustomers(Pageable pageable, Specification<CustomerEntity> spec) {

		return addressRepo.findAll(spec, pageable);

	}

	@Override
	public CustomerEntity getCustomer(int id) {
		Optional<CustomerEntity> address = addressRepo.findById(id);

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
