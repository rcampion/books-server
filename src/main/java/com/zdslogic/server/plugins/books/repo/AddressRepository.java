package com.zdslogic.server.plugins.books.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.BookAddressEntity;

@Repository
@Qualifier("addressRepository")
public interface AddressRepository extends JpaRepository<BookAddressEntity, Integer>, JpaSpecificationExecutor<BookAddressEntity> {
	 
    //Optional<AddressEntity> findByAddressId(String id);
	
    //Page<AddressEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AddressEntity findByTitle(String name);
	
	//AddressEntity findByAddress(String key);
	
}
