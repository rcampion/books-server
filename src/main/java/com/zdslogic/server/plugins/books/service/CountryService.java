package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.CountryEntity;

@Service
public interface CountryService {
    
	public EntityManagerFactory getEntityManagerFactory();
	
	//CountryEntity findCountry(String name);

    Page<CountryEntity> findCountries(Pageable pageable);

    //Page<CountryEntity> searchCountries(String name);
    
	Page<CountryEntity> searchCountries(Pageable pageable, Specification<CountryEntity> spec);

    CountryEntity getCountry(int id);
    
    CountryEntity getCountry(Integer id);

    //Page<CountryMemberEntity> findCountryMembers(int id); 
    
    public CountryEntity saveCountry(CountryEntity country);

    public void updateCountry(CountryEntity country);

	void deleteCountry(int id);    
}
