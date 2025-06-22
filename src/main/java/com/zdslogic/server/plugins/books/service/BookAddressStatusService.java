package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.BookAddressStatusEntity;

@Service("addressStatusService")
@Qualifier("addressStatusService")
public interface BookAddressStatusService {

    BookAddressStatusEntity getAddressStatus(Integer id);
    
	public EntityManagerFactory getEntityManagerFactory();
	
	//AddressStatusEntity findAddressStatus(String name);

    Page<BookAddressStatusEntity> findAddressStatuses(Pageable pageable);

    //Page<AddressStatusEntity> searchAddressStatuss(String name);
    
	Page<BookAddressStatusEntity> searchAddressStatuses(Pageable pageable, Specification<BookAddressStatusEntity> spec);

    BookAddressStatusEntity getAddressStatus(int id);    

    //Page<AddressStatusMemberEntity> findAddressStatusMembers(int id); 
    
    public BookAddressStatusEntity saveAddressStatus(BookAddressStatusEntity addressStatus);

    public void updateAddressStatus(BookAddressStatusEntity addressStatus);

	void deleteAddressStatus(int id);    
}
