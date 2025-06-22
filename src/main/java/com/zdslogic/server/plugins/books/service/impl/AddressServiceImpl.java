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

import com.zdslogic.server.plugins.books.domain.AddressEntity;
import com.zdslogic.server.plugins.books.domain.CustomerAddressEntity;
import com.zdslogic.server.plugins.books.repo.AddressRepository;
import com.zdslogic.server.plugins.books.repo.CustomerAddressRepository;
import com.zdslogic.server.plugins.books.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepo;
	
	@Override
	public Page<AddressEntity> findAddresses(Pageable pageable) {
		return addressRepo.findAll(pageable);
	}

	@Override
	public AddressEntity getAddress(Integer id) {

		Optional<AddressEntity> addressDTO = addressRepo.findById(id);
		AddressEntity address = null;
		
		if(addressDTO.isPresent()) {
			address = addressDTO.get();
		}
		
		return address;
	}

	@Override
	public AddressEntity saveAddress(AddressEntity address) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		AddressEntity result = null;

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
	public void updateAddress(AddressEntity address) {

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
	public void deleteAddress(int id) {
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
	public AddressEntity findAddress(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Page<AddressEntity> searchAddresss(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return addressRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<AddressEntity> searchAddresses(Pageable pageable, Specification<AddressEntity> spec) {

		return addressRepo.findAll(spec, pageable);

	}

	@Override
	public AddressEntity getAddress(int id) {
		Optional<AddressEntity> address = addressRepo.findById(id);

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
