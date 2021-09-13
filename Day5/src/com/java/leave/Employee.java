package com.java.leave;

import java.util.Date;

public class Employee {
	
	private int leaveId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private int empId;
	private int noofDays;
	private Date leaveAppliedOn;
	private String leaveReason;
	
	public Employee() {
		
	}

	public Employee(int leaveId, Date leaveStartDate, Date leaveEndDate, int empId, int noofDays, Date leaveAppliedOn,
			String leaveReason) {
	
		this.leaveId = leaveId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.empId = empId;
		this.noofDays = noofDays;
		this.leaveAppliedOn = leaveAppliedOn;
		this.leaveReason = leaveReason;
	}
	

	

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getNoofDays() {
		return noofDays;
	}

	public void setNoofDays(int noofDays) {
		this.noofDays = noofDays;
	}

	public Date getLeaveAppliedOn() {
		return leaveAppliedOn;
	}

	public void setLeaveAppliedOn(Date leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	@Override
	public String toString() {
		
				return String.format("%10s %10s %10s %10s %10s %10s %10s",leaveId,leaveStartDate,leaveEndDate,empId,noofDays,leaveAppliedOn,leaveReason);
	}
	
	
}
