package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.OrderLineEntity;

@Repository
@Qualifier("orderLineRepository")
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer>, JpaSpecificationExecutor<OrderLineEntity> {
	 
    Optional<OrderLineEntity> findByLineId(Integer id);
	
    //Page<OrderLineEntity> findByTitleLike(Pageable pageable, String description);
	 
	//OrderLineEntity findByTitle(String name);
	
	//OrderLineEntity findByOrderLine(String key);
	
}
