package com.web.HotelBooking.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.HotelBooking.DAOModel.Bookings;


@Repository
public class bookingDetailsDAO {
	
	private JdbcTemplate jdbc;

	@Autowired
	public bookingDetailsDAO(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}

	public List<Bookings> bookings() {
		// TODO Auto-generated method stub
		
		String sql = "select * from booking ";
		List<Bookings> results = jdbc.query(sql, new BeanPropertyRowMapper<>(Bookings.class));

       return results; // we are getting display in postman 
	}

	

}
