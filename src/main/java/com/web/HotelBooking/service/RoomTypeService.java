package com.web.HotelBooking.service;


import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HotelBooking.DAO.RoomTypeDAO;
import com.web.HotelBooking.DAOModel.RegisterModel;
import com.web.HotelBooking.DAOModel.RoomBooked;
import com.web.HotelBooking.DAOModel.RoomNoTable;
import com.web.HotelBooking.DAOModel.RoomType;

@Service
public class RoomTypeService {
	@Autowired
	private RoomTypeDAO repo;
	
	

	public void save(@Valid RoomType u) {
		// TODO Auto-generated method stub
		 repo.registertype(u);  
	}


	public void update(@Valid RoomType u) {
		// TODO Auto-generated method stub
		repo.updatetype( u);
	}


	public Object searchbydata(Date idate , Date odate) {
		// TODO Auto-generated method stub
		return repo.searchrooms(idate , odate);
	}


	public void bookroom(@Valid RoomBooked u) {
		// TODO Auto-generated method stub
		repo.bookroom(u);
	}


	public Object paymentfor(Integer id) {
		// TODO Auto-generated method stub
		return repo.paymentfor(id);
	}


	public Object showAllUsers() {
		// TODO Auto-generated method stub
		return repo.roomtypes();
	}

//	public void update(@Valid RoomType u) {
//		// TODO Auto-generated method stub
//		repo.updatetype(u);  
//	}
//
//	public List<Bookings> loadBookingDetails() {
//		return bookingDAO.getBookingDetails();
//	}

}
