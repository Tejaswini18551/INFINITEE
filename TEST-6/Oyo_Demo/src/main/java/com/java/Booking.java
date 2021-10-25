package com.java;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Booking")
public class Booking {
	
	  private String bookid ;
	  private String roomid;
	  private String custname;
	  private String city;
	  private Date bookdate;
	  private Date chkindate;
	  private Date chkoutdate;
	  
		@Id
		@Column(name="bookid")  
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	@Column(name="roomid") 
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	@Column(name="custname") 
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	@Column(name="city") 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="bookdate") 
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	@Column(name="chkindate") 
	public Date getChkindate() {
		return chkindate;
	}
	public void setChkindate(Date chkindate) {
		this.chkindate = chkindate;
	}
	@Column(name="chkoutdate") 
	public Date getChkoutdate() {
		return chkoutdate;
	}
	public void setChkoutdate(Date chkoutdate) {
		this.chkoutdate = chkoutdate;
	}
	 
}
