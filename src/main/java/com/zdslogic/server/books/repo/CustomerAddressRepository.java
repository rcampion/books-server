package com.zdslogic.server.books.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.CustomerAddressEntity;
import com.zdslogic.server.books.domain.CustomerBookEntity;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity, Integer>, JpaSpecificationExecutor<CustomerAddressEntity> {
	 
    Optional<CustomerAddressEntity> findByAddressId(int id);

	Page<CustomerAddressEntity> findByAddressId(int id, Pageable pageable);

    //Page<CustomerAddressEntity> findByTitleLike(Pageable pageable, String description);
	 
	//CustomerAddressEntity findByTitle(String name);
	
	//CustomerAddressEntity findByCustomerAddress(String key);
	
}
