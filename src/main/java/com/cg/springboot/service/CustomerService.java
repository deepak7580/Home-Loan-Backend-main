package com.cg.springboot.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.springboot.entity.Customer;

@Service
public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> viewCustomer();

	Customer viewCustomerById(int custId);

	Customer updateCustomer(int custId, Customer customer);

	Customer deleteCustomer(int custId);

	List<Customer> findByDate(LocalDate date);

	



}
