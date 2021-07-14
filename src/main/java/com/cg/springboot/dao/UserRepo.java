package com.cg.springboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("From User u where u.userId=?1")
	public User getById(String id);

	public Optional<User> findByUserIdAndPassword(String userId, String password);

}
