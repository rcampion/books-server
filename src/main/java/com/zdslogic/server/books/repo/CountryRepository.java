package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>, JpaSpecificationExecutor<CountryEntity> {
	 
    Optional<CountryEntity> findByCountryId(Integer id);
	
    //Page<CountryEntity> findByTitleLike(Pageable pageable, String description);
	 
	//CountryEntity findByTitle(String name);
	
	//CountryEntity findByCountry(String key);
	
}
