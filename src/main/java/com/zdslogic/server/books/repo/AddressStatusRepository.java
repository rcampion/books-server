package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.AddressStatusEntity;

public interface AddressStatusRepository extends JpaRepository<AddressStatusEntity, Integer>, JpaSpecificationExecutor<AddressStatusEntity> {
	 
    Optional<AddressStatusEntity> findByStatusId(Integer id);
	
    //Page<AddressStatusEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AddressStatusEntity findByTitle(String name);
	
	//AddressStatusEntity findByAddressStatus(String key);
	
}
