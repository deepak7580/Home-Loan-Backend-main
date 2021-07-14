
package com.cg.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.Admins;
import com.cg.springboot.entity.User;
import com.cg.springboot.exception.UserAdminNotFoundException;
import com.cg.springboot.dao.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminrepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public void addNewUser(Admins admin) throws UserAdminNotFoundException{
		
		String user = admin.getUser().getUserId();
		String role= admin.getUser().getRole();
		admin.setUser(null);
		User u= userRepo.getById(user);
		Admins a=adminrepo.findByUser(u);
		
		if(a!=null)
		{
			throw new UserAdminNotFoundException("User Already registered");
		}
		if(u!=null && !(u.getRole().equals("admin"))) {
			
			throw new UserAdminNotFoundException("role doesn't match with user id");
		}
		if(u==null)
		{
			throw new UserAdminNotFoundException("User not exist please register!!!");
		}
		if(role.equalsIgnoreCase("admin")) 
		{
			admin.setUser(u);
			adminrepo.save(admin);
		}
		else 
		{
			throw new UserAdminNotFoundException("Role doesn't match with user id");
		}

	}
}
