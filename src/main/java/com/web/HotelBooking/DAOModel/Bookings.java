package com.web.HotelBooking.DAOModel;

import java.sql.Date;

public class Bookings {

	
	Integer id;
	String noofroomsbooked;
	Integer userid;
	String totalpay;
	Date checkin;
	Date checkout;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoofroomsbooked() {
		return noofroomsbooked;
	}
	public void setNoofroomsbooked(String noofroomsbooked) {
		this.noofroomsbooked = noofroomsbooked;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTotalpay() {
		return totalpay;
	}
	public void setTotalpay(String totalpay) {
		this.totalpay = totalpay;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	} 
	
}
