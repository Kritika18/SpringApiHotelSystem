package com.web.HotelBooking.DAO;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.HotelBooking.DAOModel.Bookings;
import com.web.HotelBooking.DAOModel.RegisterModel;
import com.web.HotelBooking.DAOModel.RoomBooked;
import com.web.HotelBooking.DAOModel.RoomNoTable;
import com.web.HotelBooking.DAOModel.RoomType;

@Repository
public class RoomTypeDAO {
	
	private JdbcTemplate jdbc;

	@Autowired
	public RoomTypeDAO(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	

	public void registertype(@Valid RoomType u) {
		// TODO Auto-generated method stub
		
		String sql = "insert into roomtype(id ,noofrooms , rate , roomtype ) values(?,?,?,?)";
		
		try {
			jdbc.update(sql , u.getId(), u.getNoofrooms() , u.getRate() ,u.getRoomtype() );
		}
		catch(Exception e) {
			
			System.out.println(e);
		
		
		}	
		
	}


	public void updatetype(@Valid RoomType u) {
		// TODO Auto-generated method stub
      String sql = "update roomtype SET noofrooms = ? where roomtype = ? ";


		try {
			jdbc.update(sql , u.getNoofrooms() , u.getRoomtype());
		}
		catch(Exception e) {
			
			System.out.println(e);
		
		
		}	
		
	}


	public List<RoomNoTable> searchrooms(Date idate , Date odate) {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM roomno WHERE roomnoid NOT IN (SELECT roomnoid FROM roombooked where checkin < '"+date+"' and checkout <= '"+date+"' or  checkout <= '"+date+"' or checkin <= '"+date+"' )";
		// and checkinDate >= date and checkoutdate < date
			//	 NOT checkindate= '"+date+"' or not in between checkindate and checkoutdate 
		// requireddate BETWEEN 
	    // CAST('2003-01-01' AS DATE) AND 
	    // CAST('2003-01-31' AS DATE);
		//working String sql = "Select * from roomno where id not in ( select roomnoid from roombooked where checkin ='"+date+"' or checkin < '"+date+"' and checkout > '"+date+"' )";
		String sql = "select * from roomno where id not in(select roomnoid from roombooked where (checkin BETWEEN '"+idate+"' AND '"+odate+"') OR (checkout BETWEEN '"+idate+"' AND '"+odate+"'))";
			//	+ "and checkin >'\"+odate+\"' or checkout <'\"+idate+\"' and checkout >'\"+odate+\"'\"
		//checkin> idate and checkin<odate or 
		System.out.println("here");
		List<RoomNoTable> results = jdbc.query(sql, new BeanPropertyRowMapper<>(RoomNoTable.class));

       return results; // we are getting display in postman 
	}


	public void bookroom(@Valid RoomBooked u) {
		// TODO Auto-generated method stub
String sql = "insert into roombooked(id , roomnoid , bookingid , rate ,checkin ,checkout) values(?,?,?,?,?,?)";
		
		try {
			jdbc.update(sql , u.getId(), u.getRoomnoid() , u.getBookingid() ,u.getRate() , u.getCheckin() , u.getCheckout() );
		}
		catch(Exception e) {
			
			System.out.println(e);
		
		
		}	
		
	}


	public Object paymentfor(Integer id) {
		// TODO Auto-generated method stub
		
		
		String sql = "select * from booking where userid = '" + id + "'";
		 // list of how many users will be displayed in postman
		//LOG.debug("Fetching user's emaildetails");
		Bookings getuser= jdbc.queryForObject(sql,new BeanPropertyRowMapper<>(Bookings.class) );
		return getuser ; // we are getting display in postman 
	}


	public Object roomtypes() {
		// TODO Auto-generated method stub
		String sql = "select * from roomtype ";
		 // list of how many users will be displayed in postman
		//LOG.debug("Fetching user's emaildetails");
		RoomType getuser= jdbc.queryForObject(sql,new BeanPropertyRowMapper<>(RoomType.class) );
		return getuser ; // we are getting display in postman 
		
	}

//	public void updatetype(@Valid RoomType u) {
//		// TODO Auto-generated method stub
//		
//		String sql = "UPDATE roomtype SET noofrooms =  '" '" WHERE CustomerID = 1";
//		
//	}

}
