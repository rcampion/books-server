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

import com.zdslogic.server.plugins.books.domain.CountryEntity;
import com.zdslogic.server.plugins.books.repo.CountryRepository;
import com.zdslogic.server.plugins.books.service.BookCountryService;

@Service("countryService")
@Qualifier("countryService")
public class BookCountryServiceImpl implements BookCountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookCountryServiceImpl.class);
	
	@Autowired
	@Qualifier("booksEntityManager")
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public Page<CountryEntity> findCountries(Pageable pageable) {
		return countryRepo.findAll(pageable);
	}

	@Override
	public CountryEntity getCountry(Integer id) {

		Optional<CountryEntity> countryDTO = countryRepo.findById(id);
		CountryEntity country = null;
		
		if(countryDTO.isPresent()) {
			country = countryDTO.get();
		}
		
		return country;
	}

	@Override
	public CountryEntity saveCountry(CountryEntity country) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;
		
		CountryEntity result = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			result = countryRepo.save(country);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
		return result;
	}

	@Override
	public void updateCountry(CountryEntity country) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			
			countryRepo.saveAndFlush(country);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}		
	}

	@Override
	public void deleteCountry(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();

			countryRepo.deleteById(id);

			tx.commit();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		
	}

/*	
	@Override
	public CountryEntity findCountry(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<CountryEntity> searchCountrys(String name) {
		final PageRequest pageRequest = PageRequest.of(0, 10, sortByNameASC());

		return countryRepo.findByTitleLike(pageRequest, "%" + name + "%");

	}
*/
	@Override
	public Page<CountryEntity> searchCountries(Pageable pageable, Specification<CountryEntity> spec) {

		return countryRepo.findAll(spec, pageable);

	}

	@Override
	public CountryEntity getCountry(int id) {
		Optional<CountryEntity> country = countryRepo.findById(id);

		return country.get();
	}
	
	private Sort sortByNameASC() {
		return Sort.by(Sort.Direction.ASC, "country_id");
	}
	
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
