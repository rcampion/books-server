package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.CustomerAddressEntity;

@Repository
@Qualifier("customerAddressRepository")
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity, Integer>, JpaSpecificationExecutor<CustomerAddressEntity> {
	 
    Optional<CustomerAddressEntity> findByAddressId(int id);

	Page<CustomerAddressEntity> findByAddressId(int id, Pageable pageable);

    //Page<CustomerAddressEntity> findByTitleLike(Pageable pageable, String description);
	 
	//CustomerAddressEntity findByTitle(String name);
	
	//CustomerAddressEntity findByCustomerAddress(String key);
	
}
