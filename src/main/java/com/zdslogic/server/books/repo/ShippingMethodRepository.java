package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.ShippingMethodEntity;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethodEntity, Integer>, JpaSpecificationExecutor<ShippingMethodEntity> {
	 
    Optional<ShippingMethodEntity> findByMethodId(Integer id);
	
    //Page<ShippingMethodEntity> findByTitleLike(Pageable pageable, String description);
	 
	//ShippingMethodEntity findByTitle(String name);
	
	//ShippingMethodEntity findByShippingMethod(String key);
	
}
