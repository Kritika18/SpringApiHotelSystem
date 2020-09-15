package com.web.HotelBooking.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HotelBooking.DAO.bookingDetailsDAO;
import com.web.HotelBooking.DAOModel.Bookings;

@Service
public class BookingService {
	
	@Autowired
	bookingDetailsDAO bookingDao;
	
	

	public List<Bookings> bookings() {
		// TODO Auto-generated method stub
		return  bookingDao.bookings();
	}

}
