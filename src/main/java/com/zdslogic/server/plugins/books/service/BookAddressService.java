package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.BookAddressEntity;

@Service("addressService")
@Qualifier("addressService")
public interface BookAddressService {

    BookAddressEntity getAddress(Integer id);

	@Qualifier("booksEntityManager")
	public EntityManagerFactory getEntityManagerFactory();
	
	//AddressEntity findAddress(String name);

    Page<BookAddressEntity> findAddresses(Pageable pageable);

    //Page<AddressEntity> searchAddresss(String name);
    
	Page<BookAddressEntity> searchAddresses(Pageable pageable, Specification<BookAddressEntity> spec);

    BookAddressEntity getAddress(int id);    

    //Page<AddressMemberEntity> findAddressMembers(int id); 
    
    public BookAddressEntity saveAddress(BookAddressEntity address);

    public void updateAddress(BookAddressEntity address);

	void deleteAddress(int id);    
}
