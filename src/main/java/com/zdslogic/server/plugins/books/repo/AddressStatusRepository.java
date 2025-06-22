package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.BookAddressStatusEntity;

@Repository
@Qualifier("addressStatusRepository")
public interface AddressStatusRepository extends JpaRepository<BookAddressStatusEntity, Integer>, JpaSpecificationExecutor<BookAddressStatusEntity> {
	 
    Optional<BookAddressStatusEntity> findByStatusId(Integer id);
	
    //Page<AddressStatusEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AddressStatusEntity findByTitle(String name);
	
	//AddressStatusEntity findByAddressStatus(String key);
	
}
