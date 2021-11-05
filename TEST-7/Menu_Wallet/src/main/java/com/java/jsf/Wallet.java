package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="wallet")
@Entity
@Table(name="Wallet")
public class Wallet {
	
	private int cusId;
	private int walId;
	private double walAmount;
	private String walSource;
	
	@Id
	@Column(name="cus_Id")
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	
	@Column(name="wal_Id")
	public int getWalId() {
		return walId;
	}
	public void setWalId(int walId) {
		this.walId = walId;
	}
	
	@Column(name="wal_Amount")
	public double getWalAmount() {
		return walAmount;
	}
	public void setWalAmount(double walAmount) {
		this.walAmount = walAmount;
	}
	
	@Column(name="wal_Source")
	public String getWalSource() {
		return walSource;
	}
	public void setWalSource(String walSource) {
		this.walSource = walSource;
	}
	
	
	public Wallet(int cusId, int walId, double walAmount, String walSource) {
		
		this.cusId = cusId;
		this.walId = walId;
		this.walAmount = walAmount;
		this.walSource = walSource;
	}
	public Wallet() {
		
		// TODO Auto-generated constructor stub
		
	}
	
}
