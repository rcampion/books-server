package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer>, JpaSpecificationExecutor<AddressEntity> {
	 
    //Optional<AddressEntity> findByAddressId(String id);
	
    //Page<AddressEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AddressEntity findByTitle(String name);
	
	//AddressEntity findByAddress(String key);
	
}
