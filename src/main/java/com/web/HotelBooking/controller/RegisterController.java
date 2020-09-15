package com.web.HotelBooking.controller;

	import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.web.HotelBooking.DAOModel.RegisterModel;
import com.web.HotelBooking.service.RegisterService;
import com.web.HotelBooking.service.RoomTypeService;




	@Controller
	public class RegisterController {
		private static Logger LOG = LoggerFactory.getLogger("RegisterController");
		
		@Autowired
		RegisterService registerservice;
		
		@Autowired
		RoomTypeService RoomtypeService;
		
//		@RequestMapping("/Hi")
//		public String Hi()
//		{
//		   return "homepage.jsp" ;	
//		}
		
		
		
		@PostMapping("/register")  
		private int save(@Valid @RequestBody RegisterModel u)   
		{  
			registerservice.saveOrUpdate(u);  
		return u.getId();  
		}  
		
		
		
		@GetMapping(path = "emailaddress/{email}")
		public ResponseEntity<?>  customeremail(@PathVariable("email") String emailaddress) {
			LOG.info("Loading email Details");
	        return new ResponseEntity<>(registerservice.emaildata(emailaddress), HttpStatus.OK);
		}
	        
	        @GetMapping(path = "mobile/{mobile}")
	    	public ResponseEntity<?> customermobile(@PathVariable("mobile") String mobileno) {
	            
	        	LOG.info("Loading mobile Details");
	            return new ResponseEntity<>(registerservice.mobiledata(mobileno), HttpStatus.OK);
	        }
	        
	        
	        @GetMapping(path = "details/{email}")
	    	public ResponseEntity<?> customername(@PathVariable("email") String email) {
	        	LOG.info("Loading email2 Details");
	            return new ResponseEntity<>(registerservice.isemaildata(email), HttpStatus.OK);
	        }
	        
	        
	        // from here 
	        
	        @RequestMapping("/loginadmin")  //starting point
	    	public String login(HttpServletRequest request) {
	    		request.setAttribute("mode", "MODE_LOGIN");
	    		return "welcomepageadmin.jsp";
	    	}
	        
	        
	        @RequestMapping ("/login-admin")
	    	public String loginUser(@ModelAttribute RegisterModel user, HttpServletRequest request) {
	        	if(registerservice.findByUsernameAndPassword(user.getFirstName(), user.getPassword())!=null) {
	    			return "homepageadmin.jsp";
	    		}
	    		else {
	    			request.setAttribute("error", "Invalid Username or Password");
	    			request.setAttribute("mode", "MODE_LOGIN");
	    			return "welcomepageadmin.jsp";
	    		}
	    	}
	        
	        @GetMapping("/show-users")
	    	public String showAllUsers(HttpServletRequest request) {
	    		request.setAttribute("users", RoomtypeService.showAllUsers());
	    		request.setAttribute("mode", "ALL_USERS");
	    		return "welcomepageadmin.jsp";
	    	}
	    	
	}
