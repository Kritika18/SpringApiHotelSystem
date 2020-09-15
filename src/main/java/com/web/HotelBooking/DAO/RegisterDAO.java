package com.web.HotelBooking.DAO;

import java.util.List;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.web.HotelBooking.DAOModel.RegisterModel;




@Repository
public class RegisterDAO {
	private static Logger LOG = LoggerFactory.getLogger(RegisterDAO.class);

	
	private JdbcTemplate jdbc;

	@Autowired
	public RegisterDAO(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	
	public List<RegisterModel> isemail(String email) {
		String sql = "select * from person where email = '" + email + "'";
		LOG.debug("Fetching user's emaildetails");
		List<RegisterModel> results = jdbc.query(sql, new BeanPropertyRowMapper<>(RegisterModel.class));

       return results; // we are getting display in postman 
   }
	public List<RegisterModel> ismobile(String mobile) {
		String sql = "select * from person where mobile = '" + mobile + "'";
		LOG.debug("Fetching user's mobiledetails");
		List<RegisterModel> m =jdbc.query(sql, new BeanPropertyRowMapper<>(RegisterModel.class));
       return m; // we are getting display in postman 
   }
	

	
	public RegisterModel isemail2(String email) {
		String sql = "select * from person where email = '" + email + "'";
		 // list of how many users will be displayed in postman
		LOG.debug("Fetching user's emaildetails");
		RegisterModel getuser= jdbc.queryForObject(sql,new BeanPropertyRowMapper<>(RegisterModel.class) );
		return getuser ; // we are getting display in postman 
   }
	
	public void registeruser(RegisterModel u) {
		// TODO Auto-generated method stub
		String sql = "insert into person(id , firstname , lastname , email ,mobile,password) values(?,?,?,?,?,?)";
		LOG.debug("Updating user's Data");
		try {
			jdbc.update(sql , u.getId(), u.getFirstName() , u.getLastName(),u.getEmail(),u.getMobile(),u.getPassword() );
		}
		catch(Exception e) {
			
			System.out.println(e);
		
		
		}	
	}


	public List<RegisterModel> isuser(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println(email);
		System.out.println(password);
		String sql = "select * from person where email = '" + email + "' and password = '"+password +"' " ;
		 // list of how many users will be displayed in postman
		LOG.debug("Fetching user's emaildetails");
		List<RegisterModel> getuser= jdbc.query(sql, new BeanPropertyRowMapper<>(RegisterModel.class));
		System.out.print(getuser );
		return getuser ; // we are get
	}	

}
