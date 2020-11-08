package com.rkc.zds.books.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rkc.zds.books.dto.CustomerDTO;

@Service
public interface CustomerService {

    Page<CustomerDTO> findCustomers(Pageable pageable);

    CustomerDTO getCustomer(Integer id);
    
    CustomerDTO saveCustomer(CustomerDTO Customer);
    
    void updateCustomer(CustomerDTO Customer);

	void deleteCustomer(int id);
    
}
