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

import com.zdslogic.server.plugins.books.domain.CustomerAddressEntity;
import com.zdslogic.server.plugins.books.repo.CustomerAddressRepository;
import com.zdslogic.server.plugins.books.service.CustomerAddressService;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerAddressServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private CustomerAddressRepository customerAddressRepo;
	
	@Override
	public Page<CustomerAddressEntity> findCustomerAddresses(Pageable pageable) {
		return customerAddressRepo.findAll(pageable);
	}

	@Override
	public CustomerAddressEntity getCustomerAddress(Integer id) {

		Optional<CustomerAddressEntity> addressDTO = customerAddressRepo.findById(id);
		CustomerAddressEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public CustomerAddressEntity saveCustomerAddress(CustomerAddressEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		CustomerAddressEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = customerAddressRepo.save(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateCustomerAddress(CustomerAddressEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			customerAddressRepo.saveAndFlush(address);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteCustomerAddress(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			customerAddressRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*	
	@Override
	public CustomerAddressEntity findCustomerAddress(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<CustomerAddressEntity> searchCustomerAddresss(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<CustomerAddressEntity> searchCustomerAddress(Pageable pageable, Specification<CustomerAddressEntity> spec) {

		return customerAddressRepo.findAll(spec, pageable);

	}

	@Override
	public CustomerAddressEntity getCustomerAddress(int id) {
		Optional<CustomerAddressEntity> address = customerAddressRepo.findById(id);

		return address.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "customer_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
