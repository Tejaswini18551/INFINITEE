package com.java;



	
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table (name="Billing")
	public class Billing {

		   private String bookid;
		   private String roomid;
		   private int noofdays;
		   private int billamt;
		   
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
		@Column(name="noofdays")
		public int getNoofdays() {
			return noofdays;
		}
		public void setNoofdays(int noofdays) {
			this.noofdays = noofdays;
		}
		@Column(name="billamt")
		public int getBillamt() {
			return billamt;
		}
		public void setBillamt(int billamt) {
			this.billamt = billamt;
		}
		   
}
