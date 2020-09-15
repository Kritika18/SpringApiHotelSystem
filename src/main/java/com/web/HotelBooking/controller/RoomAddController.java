package com.web.HotelBooking.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.HotelBooking.DAOModel.RegisterModel;
import com.web.HotelBooking.DAOModel.RoomBooked;
import com.web.HotelBooking.DAOModel.RoomType;
import com.web.HotelBooking.service.BookingService;
import com.web.HotelBooking.service.RoomTypeService;

@Controller
public class RoomAddController {
	
	
	@Autowired
	RoomTypeService roomtypeservice;
	
	@Autowired
	BookingService bookingService;

	
	
	
	@PostMapping("/registeroom")  
	private int addtype(@Valid @RequestBody RoomType u)   
	{  
		roomtypeservice.save(u);  
	return u.getId();  
	}  
	

	@PutMapping("/changecapacity")
	public void updateroomtype( @Valid @RequestBody RoomType u)  {
	
		roomtypeservice.update(u);  
	}
	
	//
	
	@GetMapping("/viewbookingreport")  //here
	public String bookings(HttpServletRequest request) {
		request.setAttribute("booking", bookingService.bookings()); //booking name should be wriiten in jsp "item"
		request.setAttribute("mode", "ALL_BOOKING");
		return "welcomepageadmin.jsp";
	}
	
	@GetMapping(path = "/searchrooms/{checkindate}/{checkoutdate}")
	public ResponseEntity<?>  customeremail(@PathVariable("checkindate") Date checkindate ,@PathVariable("checkoutdate") Date checkoutdate) {
		System.out.println("here c");
        return new ResponseEntity<>(roomtypeservice.searchbydata(checkindate , checkoutdate), HttpStatus.OK);
	}
	
	@RequestMapping("/searchbydate")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_SETDATE");
		return "welcomepageadmin.jsp";
	}
	
	 @GetMapping("/searchroom")
 	public String showAllUsers(@ModelAttribute RoomBooked booked, HttpServletRequest request) {
		 request.setAttribute("sdate", roomtypeservice.searchbydata(booked.getCheckin() ,booked.getCheckout()));
			request.setAttribute("mode", "S_ROOM");
			return "welcomepageadmin.jsp";
	 }

	
	
	@PostMapping("/bookroom")  
	private int bookroom(@Valid @RequestBody RoomBooked u)   
	{  
		roomtypeservice.bookroom(u);  
	return u.getId();  
	} 
	
	
	@GetMapping(path = "/payment/{userid}")
	public ResponseEntity<?>  payment(@PathVariable("userid") Integer id ) {
		System.out.println("here c");
        return new ResponseEntity<>(roomtypeservice.paymentfor(id ), HttpStatus.OK);
	}
	
	

}
