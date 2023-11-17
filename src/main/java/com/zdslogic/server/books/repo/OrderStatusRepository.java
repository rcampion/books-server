package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Integer>, JpaSpecificationExecutor<OrderStatusEntity> {
	 
    Optional<OrderStatusEntity> findByStatusId(Integer id);
	
    //Page<OrderStatusEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderStatusEntity findByTitle(String name);
	
	//OrderStatusEntity findByOrderStatus(String key);
	
}
