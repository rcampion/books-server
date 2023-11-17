package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.OrderHistoryEntity;

public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity, Integer>, JpaSpecificationExecutor<OrderHistoryEntity> {
	 
    Optional<OrderHistoryEntity> findByHistoryId(Integer id);
	
    //Page<OrderHistoryEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderHistoryEntity findByTitle(String name);
	
	//OrderHistoryEntity findByOrderHistory(String key);
	
}
