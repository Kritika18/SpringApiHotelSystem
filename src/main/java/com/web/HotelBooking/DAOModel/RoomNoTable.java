package com.web.HotelBooking.DAOModel;

public class RoomNoTable {
	
	Integer id;
	Integer roomtypeid;
	Integer roomno;
	String rate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomtypeid() {
		return roomtypeid;
	}
	public void setRoomtypeid(Integer roomtypeid) {
		this.roomtypeid = roomtypeid;
	}
	public Integer getRoomno() {
		return roomno;
	}
	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}

}
