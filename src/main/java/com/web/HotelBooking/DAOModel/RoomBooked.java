package com.web.HotelBooking.DAOModel;
import java.sql.Date;

public class RoomBooked {
	
	Integer id;
	Integer roomnoid;
	Integer bookingid;
	String rate;
	Date checkin ;
	Date checkout;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomnoid() {
		return roomnoid;
	}
	public void setRoomnoid(Integer roomnoid) {
		this.roomnoid = roomnoid;
	}
	public Integer getBookingid() {
		return bookingid;
	}
	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
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
