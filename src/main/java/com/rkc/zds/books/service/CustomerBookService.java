package com.rkc.zds.books.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rkc.zds.books.dto.CustomerBookDTO;

@Service
public interface CustomerBookService {

    Page<CustomerBookDTO> findCustomerBooks(Pageable pageable);

    CustomerBookDTO getCustomerBook(int id);
    
    CustomerBookDTO saveCustomerBook(CustomerBookDTO CustomerBook);
    
    void updateCustomerBook(CustomerBookDTO CustomerBook);

	void deleteCustomerBook(int id);

	Page<CustomerBookDTO> findCustomerBooksByCustomerId(Pageable pageable, int id);

	Page<CustomerBookDTO> findCustomerBooksByBookId(Pageable pageable, int id);
    
}
