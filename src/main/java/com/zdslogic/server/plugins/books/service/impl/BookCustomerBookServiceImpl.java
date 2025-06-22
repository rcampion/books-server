package com.zdslogic.server.plugins.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.CustomerBookEntity;
import com.zdslogic.server.plugins.books.repo.CustomerBookRepository;
import com.zdslogic.server.plugins.books.service.BookCustomerBookService;

@Service("customerBookService")
@Qualifier("customerBookService")
public class BookCustomerBookServiceImpl implements BookCustomerBookService {
	
	@Autowired
	private CustomerBookRepository customerBookRepo;

	@Override
	public Page<CustomerBookEntity> findCustomerBooks(Pageable pageable) {
		return customerBookRepo.findAll(pageable);
	}

	@Override
	public Page<CustomerBookEntity> findCustomerBooksByCustomerId(Pageable pageable, int id) {
		return customerBookRepo.findByCustomerId(id, pageable);
	}

	@Override
	public Page<CustomerBookEntity> findCustomerBooksByBookId(Pageable pageable, int id) {
		return customerBookRepo.findByBookId(id, pageable);
	}
	
	@Override
	public CustomerBookEntity getCustomerBook(int id) {
		return customerBookRepo.getOne(id);
	}

	@Override
	public CustomerBookEntity saveCustomerBook(CustomerBookEntity book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomerBook(CustomerBookEntity book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerBook(int id) {
		// TODO Auto-generated method stub
		
	}
}
