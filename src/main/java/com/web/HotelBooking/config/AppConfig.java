package com.web.HotelBooking.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.web.HotelBooking")
public class AppConfig {



	private final String URL = "jdbc:mysql://localhost:3306/hotel_booking_system?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
	private final String USER = "root";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String PASSWORD = "root";
     
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(URL);
		driverManagerDataSource.setUsername(USER);
		driverManagerDataSource.setPassword(PASSWORD);
		driverManagerDataSource.setDriverClassName(DRIVER);
		return driverManagerDataSource;
	}
}