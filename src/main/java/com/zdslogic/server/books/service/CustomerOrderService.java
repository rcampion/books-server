package com.zdslogic.server.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.books.domain.CustomerOrderEntity;

@Service
public interface CustomerOrderService {

	public EntityManagerFactory getEntityManagerFactory();
	
	CustomerOrderEntity findCustomerOrder(String name);

    Page<CustomerOrderEntity> findCustomerOrder(Pageable pageable);

    //Page<CustomerOrderEntity> searchCustomerOrders(String name);
    
	Page<CustomerOrderEntity> searchCustomerOrders(Pageable pageable, Specification<CustomerOrderEntity> spec);

    CustomerOrderEntity getCustomerOrder(int id);    
    
    CustomerOrderEntity getCustomerOrder(Integer id);
    
    //Page<CustomerOrderMemberEntity> findCustomerOrderMembers(int id); 
    
    public CustomerOrderEntity saveCustomerOrder(CustomerOrderEntity customerOrder);

    public void updateCustomerOrder(CustomerOrderEntity customerOrder);

	void deleteCustomerOrder(int id);
	
}
