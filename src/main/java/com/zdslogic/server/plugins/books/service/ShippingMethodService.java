package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.ShippingMethodEntity;

@Service
public interface ShippingMethodService {
    
	public EntityManagerFactory getEntityManagerFactory();
	
	//ShippingMethodEntity findShippingMethod(String name);

    Page<ShippingMethodEntity> findShippingMethods(Pageable pageable);

    //Page<ShippingMethodEntity> searchCountries(String name);
    
	Page<ShippingMethodEntity> searchShippingMethods(Pageable pageable, Specification<ShippingMethodEntity> spec);

    ShippingMethodEntity getShippingMethod(int id);    

    ShippingMethodEntity getShippingMethod(Integer id);
    
    //Page<ShippingMethodMemberEntity> findShippingMethodMembers(int id); 
    
    public ShippingMethodEntity saveShippingMethod(ShippingMethodEntity shippingMethod);

    public void updateShippingMethod(ShippingMethodEntity shippingMethod);

	void deleteShippingMethod(int id);    
}
