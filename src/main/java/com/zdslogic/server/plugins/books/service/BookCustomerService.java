package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.CustomerEntity;

@Service
public interface BookCustomerService {

	public EntityManagerFactory getEntityManagerFactory();
	
	//CustomerEntity findCustomer(String name);

    Page<CustomerEntity> findCustomers(Pageable pageable);

    //Page<CustomerEntity> searchCustomers(String name);
    
	Page<CustomerEntity> searchCustomers(Pageable pageable, Specification<CustomerEntity> spec);

    CustomerEntity getCustomer(int id);    

    CustomerEntity getCustomer(Integer id);
    
    //Page<CustomerMemberEntity> findCustomerMembers(int id); 
    
    public CustomerEntity saveCustomer(CustomerEntity customer);

    public void updateCustomer(CustomerEntity customer);

	void deleteCustomer(int id);  
    
}
