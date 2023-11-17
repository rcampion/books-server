package com.zdslogic.server.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.books.domain.OrderHistoryEntity;

@Service
public interface OrderHistoryService {

	public EntityManagerFactory getEntityManagerFactory();
	
	//OrderHistoryEntity findOrderHistory(String name);

    Page<OrderHistoryEntity> findOrderHistory(Pageable pageable);

    //Page<OrderHistoryEntity> searchOrderHistorys(String name);
    
	Page<OrderHistoryEntity> searchOrderHistorys(Pageable pageable, Specification<OrderHistoryEntity> spec);

    OrderHistoryEntity getOrderHistory(int id);    
    
    OrderHistoryEntity getOrderHistory(Integer id);
    
    //Page<OrderHistoryMemberEntity> findOrderHistoryMembers(int id); 
    
    public OrderHistoryEntity saveOrderHistory(OrderHistoryEntity orderHistory);

    public void updateOrderHistory(OrderHistoryEntity orderHistory);

	void deleteOrderHistory(int id);    
}
