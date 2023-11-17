package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.OrderLineEntity;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer>, JpaSpecificationExecutor<OrderLineEntity> {
	 
    Optional<OrderLineEntity> findByLineId(Integer id);
	
    //Page<OrderLineEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderLineEntity findByTitle(String name);
	
	//OrderLineEntity findByOrderLine(String key);
	
}
