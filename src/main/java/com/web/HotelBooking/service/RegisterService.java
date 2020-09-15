package com.web.HotelBooking.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HotelBooking.DAO.RegisterDAO;
import com.web.HotelBooking.DAOModel.RegisterModel;






@Service
public class RegisterService  {
	
	@Autowired
	private RegisterDAO repo;
	
	
	public void saveOrUpdate(RegisterModel user)   
	{  
		
		if((repo.isemail(user.getEmail())).isEmpty() && (repo.ismobile(user.getMobile())).isEmpty() )
		{
	
	      repo.registeruser(user);  
		}
		else
		{
			System.out.print("User present");
		}
	}  
	
	
	public List<RegisterModel> emaildata(String email)
	{
		return repo.isemail(email);
	}
	public List<RegisterModel> mobiledata(String mobile)
	{
		return repo.ismobile(mobile);
	}
	
	public Object isemaildata(String email)
	{
		return repo.isemail2(email);
	}


	public List<RegisterModel> findByUsernameAndPassword(String email, String password) {
		// TODO Auto-generated method stub
	System.out.print("in service");
		return repo.isuser(email,password);
	}


	
}
