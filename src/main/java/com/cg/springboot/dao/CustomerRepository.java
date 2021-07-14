package com.cg.springboot.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.User;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

//	@Query("from User where userId=:user AND password=:pwd")
//	User findByIdAndPwd(@Param("user") int user,@Param("pwd") String pwd);
	
	@Query("from Customer c where c.customerId=?1")
	public Customer getById(int id);
	@Transactional
	@Modifying
	@Query("update Customer c set c.user=?1 where c.customerId=?2")
	public void updateUser(User user,int id);
	
	@Query("From Customer c where c.user=?1")
	public Customer findByUser(User user);


//	@Query("SELECT l.Customer FROM  LoanApplication l where l.applicationDate=?1")
//	public List<Customer> getByDate(LocalDate date);

	



}
