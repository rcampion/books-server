package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.OrderStatusEntity;

@Repository
@Qualifier("orderStatusRepository")
public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Integer>, JpaSpecificationExecutor<OrderStatusEntity> {
	 
    Optional<OrderStatusEntity> findByStatusId(Integer id);
	
    //Page<OrderStatusEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderStatusEntity findByTitle(String name);
	
	//OrderStatusEntity findByOrderStatus(String key);
	
}
