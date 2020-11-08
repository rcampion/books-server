package com.rkc.zds.books.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkc.zds.books.dto.BookDTO;
import com.rkc.zds.books.dto.CustomerBookDTO;
import com.rkc.zds.books.dto.CustomerDTO;
import com.rkc.zds.books.service.BookService;
import com.rkc.zds.books.service.CustomerBookService;
import com.rkc.zds.books.service.CustomerService;

@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping(value = "/api/books")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerBookService customerBookService;

//Book
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<BookDTO>> findAllBooks(Pageable pageable, HttpServletRequest req) {
		Page<BookDTO> page = bookService.findBooks(pageable);
		ResponseEntity<Page<BookDTO>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDTO> getBook(@PathVariable Integer id, HttpServletRequest req) {
		BookDTO book = bookService.getBook(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public BookDTO createBook(@RequestBody String jsonString) {

		ObjectMapper mapper = new ObjectMapper();

		BookDTO bookDTO = new BookDTO();
		try {
			bookDTO = mapper.readValue(jsonString, BookDTO.class);
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

		BookDTO dto = bookService.saveBook(bookDTO);

		return dto;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public void updateBook(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		BookDTO book = new BookDTO();
		try {
			book = mapper.readValue(jsonString, BookDTO.class);
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

		bookService.updateBook(book);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return Integer.toString(id);
	}

//Customer
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerDTO>> findAllCustomers(Pageable pageable, HttpServletRequest req) {
		Page<CustomerDTO> page = customerService.findCustomers(pageable);
		ResponseEntity<Page<CustomerDTO>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id, HttpServletRequest req) {
		CustomerDTO customer = customerService.getCustomer(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public CustomerDTO createCustomer(@RequestBody String jsonString) {

		ObjectMapper mapper = new ObjectMapper();

		CustomerDTO customerDTO = new CustomerDTO();
		try {
			customerDTO = mapper.readValue(jsonString, CustomerDTO.class);
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

		CustomerDTO dto = customerService.saveCustomer(customerDTO);

		return dto;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public void updateCustomer(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		CustomerDTO customer = new CustomerDTO();
		try {
			customer = mapper.readValue(jsonString, CustomerDTO.class);
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
	public ResponseEntity<Page<CustomerBookDTO>> findAllCustomerBooks(Pageable pageable, HttpServletRequest req) {
		Page<CustomerBookDTO> page = customerBookService.findCustomerBooks(pageable);
		ResponseEntity<Page<CustomerBookDTO>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/customer/book/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerBookDTO>> findAllCustomerBooksByCustomer(Pageable pageable,@PathVariable int id, HttpServletRequest req) {
		Page<CustomerBookDTO> page = customerBookService.findCustomerBooksByCustomerId(pageable, id);
		ResponseEntity<Page<CustomerBookDTO>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/customer/book/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CustomerBookDTO>> findAllCustomerBooksByBook(Pageable pageable,@PathVariable int id, HttpServletRequest req) {
		Page<CustomerBookDTO> page = customerBookService.findCustomerBooksByBookId(pageable, id);
		ResponseEntity<Page<CustomerBookDTO>> response = new ResponseEntity<>(page, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/customer//book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBookDTO> getCustomerBook(@PathVariable int id, HttpServletRequest req) {
		CustomerBookDTO customerBook = customerBookService.getCustomerBook(id);
		return new ResponseEntity<>(customerBook, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/book", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public CustomerBookDTO createCustomerBook(@RequestBody String jsonString) {

		ObjectMapper mapper = new ObjectMapper();

		CustomerBookDTO customerBookDTO = new CustomerBookDTO();
		try {
			customerBookDTO = mapper.readValue(jsonString, CustomerBookDTO.class);
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

		CustomerBookDTO dto = customerBookService.saveCustomerBook(customerBookDTO);

		return dto;
	}

	@RequestMapping(value = "/customer/book", method = RequestMethod.PUT, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public void updateCustomerBook(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		CustomerBookDTO customerBook = new CustomerBookDTO();
		try {
			customerBook = mapper.readValue(jsonString, CustomerBookDTO.class);
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
}
