package com.rkc.zds.books.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rkc.zds.books.dto.BookDTO;
import com.rkc.zds.books.dto.CustomerDTO;
import com.rkc.zds.books.repository.CustomerRepository;
import com.rkc.zds.books.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Page<CustomerDTO> findCustomers(Pageable pageable) {
		return customerRepo.findAll(pageable);
	}

	@Override
	public CustomerDTO getCustomer(Integer id) {

		Optional<CustomerDTO> customerDTO = customerRepo.findById(id);
		CustomerDTO customer = null;
		
		if(customerDTO.isPresent()) {
			customer = customerDTO.get();
		}
		
		return customer;
	}

	@Override
	public CustomerDTO saveCustomer(CustomerDTO book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(CustomerDTO book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

}
