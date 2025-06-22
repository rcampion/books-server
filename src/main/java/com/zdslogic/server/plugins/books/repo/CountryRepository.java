package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.CountryEntity;

@Repository
@Qualifier("countryRepository")
public interface CountryRepository extends JpaRepository<CountryEntity, Integer>, JpaSpecificationExecutor<CountryEntity> {
	 
    Optional<CountryEntity> findByCountryId(Integer id);
	
    //Page<CountryEntity> findByTitleLike(Pageable pageable, String description);
	 
	//CountryEntity findByTitle(String name);
	
	//CountryEntity findByCountry(String key);
	
}
