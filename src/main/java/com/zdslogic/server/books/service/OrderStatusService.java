package com.zdslogic.server.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.books.domain.OrderStatusEntity;

@Service
public interface OrderStatusService {

	public EntityManagerFactory getEntityManagerFactory();
	
	//OrderStatusEntity findOrderStatus(String name);

    Page<OrderStatusEntity> findOrderStatus(Pageable pageable);

    //Page<OrderStatusEntity> searchOrderStatuss(String name);
    
	Page<OrderStatusEntity> searchOrderStatuss(Pageable pageable, Specification<OrderStatusEntity> spec);

    OrderStatusEntity getOrderStatus(int id);    
    
    OrderStatusEntity getOrderStatus(Integer id);
    
    //Page<OrderStatusMemberEntity> findOrderStatusMembers(int id); 
    
    public OrderStatusEntity saveOrderStatus(OrderStatusEntity orderStatus);

    public void updateOrderStatus(OrderStatusEntity orderStatus);

	void deleteOrderStatus(int id);    
}
