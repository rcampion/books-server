package com.zdslogic.server.plugins.books.web;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdslogic.server.plugins.books.domain.BookEntity;
import com.zdslogic.server.plugins.books.domain.CustomerBookEntity;
import com.zdslogic.server.plugins.books.domain.CustomerEntity;
import com.zdslogic.server.util.rsql.CustomRsqlVisitor;
import com.zdslogic.server.plugins.books.service.BookService;
import com.zdslogic.server.plugins.books.service.BookCustomerBookService;
import com.zdslogic.server.plugins.books.service.BookCustomerService;
import com.zdslogic.server.plugins.books.system.utils.SystemUtils;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@CrossOrigin(origins = { "", "https://www.zdslogic.com", "http://www.richardcampion.com", "http://www.brentfisher.me", "http://www.paulfredette.me", "http://www.monicaconnors.com", "http://localhost:8089", "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/books")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookCustomerService customerService;

	@Autowired
	BookCustomerBookService customerBookService;

//Book
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<BookEntity>> findAllBooks(@RequestHeader("apikey") String apiKey, Pageable pageable, HttpServletRequest req) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		Page<BookEntity> page = bookService.findBooks(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookEntity> getBook(@RequestHeader("apikey") String apiKey, @PathVariable int id, HttpServletRequest req) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		BookEntity bookEntity = bookService.getBook(id);
		return new ResponseEntity<>(bookEntity, HttpStatus.OK);
	}	

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createBook(@RequestHeader("apikey") String apiKey, @RequestBody String jsonString) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
					
		ObjectMapper mapper = new ObjectMapper();

		BookEntity bookEntity = new BookEntity();
		try {
			bookEntity = mapper.readValue(jsonString, BookEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bookEntity = bookService.saveBook(bookEntity);
		
		return new ResponseEntity<>(bookEntity, HttpStatus.OK);

	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<Object> updateBook(@RequestHeader("apikey") String apiKey, @RequestBody String jsonString) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}	
		
		ObjectMapper mapper = new ObjectMapper();

		BookEntity bookEntity = new BookEntity();
		try {
			bookEntity = mapper.readValue(jsonString, BookEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bookService.updateBook(bookEntity);
		return new ResponseEntity<>(null, HttpStatus.OK);

	}

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteBook(@RequestHeader("apikey") String apiKey, @PathVariable int id) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}  		
		
		bookService.deleteBook(id);
		return new ResponseEntity<>(Integer.toString(id), HttpStatus.OK);
	}

//Customer
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerEntity>> findAllCustomers(Pageable pageable, HttpServletRequest req) {
		Page<CustomerEntity> page = customerService.findCustomers(pageable);
		ResponseEntity<Page<CustomerEntity>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable int id, HttpServletRequest req) {
		CustomerEntity customer = customerService.getCustomer(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public CustomerEntity createCustomer(@RequestBody String jsonString) {

		ObjectMapper mapper = new ObjectMapper();

		CustomerEntity customerDTO = new CustomerEntity();
		try {
			customerDTO = mapper.readValue(jsonString, CustomerEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustomerEntity dto = customerService.saveCustomer(customerDTO);

		return dto;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public void updateCustomer(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		CustomerEntity customer = new CustomerEntity();
		try {
			customer = mapper.readValue(jsonString, CustomerEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customerService.updateCustomer(customer);

	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return Integer.toString(id);
	}

// CustomerBook
	
	@RequestMapping(value = "/customer/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerBookEntity>> findAllCustomerBooks(Pageable pageable, HttpServletRequest req) {
		Page<CustomerBookEntity> page = customerBookService.findCustomerBooks(pageable);
		ResponseEntity<Page<CustomerBookEntity>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/customer/book/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerBookEntity>> findAllCustomerBooksByCustomer(Pageable pageable,@PathVariable int id, HttpServletRequest req) {
		Page<CustomerBookEntity> page = customerBookService.findCustomerBooksByCustomerId(pageable, id);
		ResponseEntity<Page<CustomerBookEntity>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/customer/book/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerBookEntity>> findAllCustomerBooksByBook(Pageable pageable,@PathVariable int id, HttpServletRequest req) {
		Page<CustomerBookEntity> page = customerBookService.findCustomerBooksByBookId(pageable, id);
		ResponseEntity<Page<CustomerBookEntity>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/customer/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBookEntity> getCustomerBook(@PathVariable int id, HttpServletRequest req) {
		CustomerBookEntity customerBook = customerBookService.getCustomerBook(id);
		return new ResponseEntity<>(customerBook, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/book", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public CustomerBookEntity createCustomerBook(@RequestBody String jsonString) {

		ObjectMapper mapper = new ObjectMapper();

		CustomerBookEntity customerBookEntity = new CustomerBookEntity();
		try {
			customerBookEntity = mapper.readValue(jsonString, CustomerBookEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustomerBookEntity dto = customerBookService.saveCustomerBook(customerBookEntity);

		return dto;
	}

	@RequestMapping(value = "/customer/book", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public void updateCustomerBook(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		CustomerBookEntity customerBook = new CustomerBookEntity();
		try {
			customerBook = mapper.readValue(jsonString, CustomerBookEntity.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customerBookService.updateCustomerBook(customerBook);

	}

	@RequestMapping(value = "/customer/book/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomerBook(@PathVariable int id) {
		customerBookService.deleteCustomerBook(id);
		return Integer.toString(id);
	}
	
//-------------
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<BookEntity>> findAllByRsql(@RequestHeader("apikey") String apiKey, Pageable pageable,
			@RequestParam(value = "search") String search) {
		
		SystemUtils utils = SystemUtils.getInstance();
		boolean isApiKeyValid = utils.isApiKeyValid(apiKey);
		
		if(!isApiKeyValid) {
			System.out.println("Book:"+ apiKey + " isValid:"+ isApiKeyValid);
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		Node rootNode = new RSQLParser().parse(search);
		Specification<BookEntity> spec = rootNode.accept(new CustomRsqlVisitor<BookEntity>());
		Page<BookEntity> page = bookService.searchBooks(pageable, spec);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}
	
}
