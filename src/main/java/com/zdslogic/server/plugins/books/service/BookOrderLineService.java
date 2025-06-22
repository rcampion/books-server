package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.OrderLineEntity;

@Service
public interface BookOrderLineService {
 
	public EntityManagerFactory getEntityManagerFactory();
	
	//OrderLineEntity findOrderLine(String name);

    Page<OrderLineEntity> findOrderLines(Pageable pageable);

    //Page<OrderLineEntity> searchOrderLines(String name);
    
	Page<OrderLineEntity> searchOrderLines(Pageable pageable, Specification<OrderLineEntity> spec);

    OrderLineEntity getOrderLine(int id);
    
    OrderLineEntity getOrderLine(Integer id);

    //Page<OrderLineMemberEntity> findOrderLineMembers(int id); 
    
    public OrderLineEntity saveOrderLine(OrderLineEntity orderLine);

    public void updateOrderLine(OrderLineEntity orderLine);

	void deleteOrderLine(int id);    
}
