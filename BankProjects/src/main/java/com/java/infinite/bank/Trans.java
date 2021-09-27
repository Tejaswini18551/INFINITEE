package com.java.infinite.bank;

import java.util.Date;

public class Trans {
 private int AccountNo;
 private int TransAmount;
 private String TransType;
 private Date TransDate;
 
@Override
public String toString() {
	return "Trans [AccountNo=" + AccountNo + ", TransAmount=" + TransAmount + ", TransType=" + TransType
			+ ", TransDate=" + TransDate + "]";
}
public int getAccountNo() {
	return AccountNo;
}
public void setAccountNo(int accountNo) {
	AccountNo = accountNo;
}
public int getTransAmount() {
	return TransAmount;
}
public void setTransAmount(int transAmount) {
	TransAmount = transAmount;
}
public String getTransType() {
	return TransType;
}
public void setTransType(String transType) {
	TransType = transType;
}
public Date getTransDate() {
	return TransDate;
}
public void setTransDate(Date transDate) {
	TransDate = transDate;
}
}