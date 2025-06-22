package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.OrderHistoryEntity;

@Repository
@Qualifier("orderHistoryRepository")
public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity, Integer>, JpaSpecificationExecutor<OrderHistoryEntity> {
	 
    Optional<OrderHistoryEntity> findByHistoryId(Integer id);
	
    //Page<OrderHistoryEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderHistoryEntity findByTitle(String name);
	
	//OrderHistoryEntity findByOrderHistory(String key);
	
}
