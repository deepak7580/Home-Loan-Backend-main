package com.cg.springboot.controller;

import java.time.LocalDate;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	//adding single customer into database
	@PostMapping("/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer)
	{
		System.out.println(customer.getUser());
		customerService.addCustomer(customer);
		return customer;
	}
	
	//viewing all the records from the database
	@GetMapping("/viewCustomer")
		public List<Customer> viewCustomer()
	{
		List<Customer> customer=customerService.viewCustomer();
		return customer;
	}
	
	//view records by id
	
	@GetMapping("/view/{custId}")
	public Customer viewCustomerById(@Valid @PathVariable("custId") int custId)
	{
		Customer customer =  customerService.viewCustomerById(custId);
		return customer;
	}
	
	//updating the record 
	@PutMapping("/update/{custId}")
	public Customer updateCustomer(@Valid @PathVariable("custId") int custId,@Valid @RequestBody Customer customer)
	{
		Customer cust =customerService.updateCustomer(custId,customer);
		return cust;
	}
	
	//deleting the record 
	@DeleteMapping("delete/{custId}")
	public Customer deleteCustomer(@Valid  @PathVariable("custId") int custId)
	{
		return customerService.deleteCustomer(custId);
		
	}
	//view customer list by date
	@GetMapping("viewDate/{date}")
	public List<Customer> findByDate(@Valid @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
	{
		System.out.println("code reached");
		return customerService.findByDate(date);
	}

}
