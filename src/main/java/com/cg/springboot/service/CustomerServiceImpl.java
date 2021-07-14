package com.cg.springboot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.springboot.dao.CustomerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;
import com.cg.springboot.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	LoanRepo loanRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public void addCustomer(Customer customer) throws CustomerNotFoundException{

		//userRepo.save(customer.getUser());
		String user = customer.getUser().getUserId();
		String role =customer.getUser().getRole();
		customer.setUser(null);
		User u=userRepo.getById(user);
		Customer c=customerRepo.findByUser(u);
		if(c!=null)
		{
			throw new CustomerNotFoundException("user Already registered");
		}
		if(u!=null && !(u.getRole().equalsIgnoreCase("customer")))
		{
			throw new CustomerNotFoundException("role doen't match with user id!!!");
		}
		if(u==null)
		{
			throw new CustomerNotFoundException("user not exist please register!!!");
		}
		if(role.equalsIgnoreCase("customer"))
		{
		customer.setUser(u);
		customerRepo.save(customer);
		}
		else
		{
			throw new CustomerNotFoundException("role doesn't match with userid");
		}
		
	//	customerRepo.updateUser(u, customer.getCustomerId());

	}

	@Override
	public List<Customer> viewCustomer() throws CustomerNotFoundException {
		
		List<Customer> customer = customerRepo.findAll();
		if(customer==null)
		{
			throw new CustomerNotFoundException("no customer found");
		}
		return customer;

	}

	@Override
	public Customer viewCustomerById(int custId) throws CustomerNotFoundException {
		try {
			Optional<Customer> customer = customerRepo.findById(custId);
			if (customer.isPresent()) {
				return customer.get();
			} else {
				throw new CustomerNotFoundException("Customer not found with matching id");
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer not found with matching id");
		}

	}

	@Override
	public Customer updateCustomer(int custId, Customer customer) {
		Optional<Customer> cust = customerRepo.findById(custId);
		if (cust.isPresent()) {
			cust.get().setAadharNumber(customer.getAadharNumber());
			cust.get().setCustomerId(custId);
			cust.get().setCustomerName(customer.getCustomerName());
			cust.get().setDateOfBirth(customer.getDateOfBirth());
			cust.get().setEmail(customer.getEmail());
			cust.get().setGender(customer.getGender());
			cust.get().setMobileNumber(customer.getMobileNumber());
			cust.get().setNationality(customer.getNationality());
			cust.get().setPanNumber(customer.getPanNumber());
			cust.get().setUser(customer.getUser());

			customerRepo.save(cust.get());
			userRepo.save(cust.get().getUser());
			return cust.get();
		} else {
			throw new CustomerNotFoundException("Customer not found with matching id");
		}

//		Optional<Customer> optional = customerRepo.findById(customer.getCustomerId());
//		if (optional.isPresent()) {
//			customerRepo.save(customer);
//			return optional.get();
//		} else {
//			throw new RuntimeException("not found");// returns updated loan
//																								// application
//
//		}

	}

	@Override
	public Customer deleteCustomer(int custId) {
		Optional<Customer> cust1 = customerRepo.findById(custId);
		if (cust1.isPresent()) {
			Customer cust = customerRepo.getById(custId);
			LoanApplication loan = loanRepo.getByCustomer(cust);
			customerRepo.deleteById(cust.getCustomerId());
			loanRepo.deleteById(loan.getApplicationId());

			return cust;
		} else {
			throw new CustomerNotFoundException("Customer not found with matching id");
		}

	}

	@Override
	public List<Customer> findByDate(LocalDate date) {
		List<Customer> c1 = loanRepo.getByDate(date);
		if (c1.isEmpty()) {
			throw new CustomerNotFoundException("No Matching Records Found With Entered Date");
		} else {
			// List<LoanApplication> loan= loanRepo.getByDate(date);
			System.out.println(c1);

			return c1;
		}
	}

}
