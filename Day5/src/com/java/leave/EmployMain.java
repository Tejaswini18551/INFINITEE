package com.java.leave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployMain {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void deleteEmployee(){
		System.out.println("Enter empId");
		int empId=sc.nextInt();
		System.out.println(new EmployeeBAL().deleteEmployeeBal(empId));
	}
	public static void searchEmployee(){
		System.out.println("Enter empId ");
		int empId=sc.nextInt();
		Employee employee=new EmployeeBAL().searchEmployeeBal(empId);
		if(employee!=null){
			System.out.println(employee);
		}else{
			System.out.println("****Record Not Found***");
		}
		}
	
	public static void showEmployee(){
		List<Employee> employeeList=new EmployeeBAL().showEmployeeBal();
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
	
	
	public static void addEmployee()throws EmployException, ParseException{
		Employee employee=new Employee();
		System.out.println("Enter the leaveId  ");
		employee.setLeaveId(sc.nextInt());
		
		System.out.println("Enter The Empid");
		employee.setEmpId(sc.nextInt());
		
		System.out.println("Enter the reason for leave ");
		employee.setLeaveReason(sc.next());
		
		System.out.println("Enter Leave Start Date  ");
		String startDate=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date date=sdf.parse(startDate);
		
		employee.setLeaveStartDate(date);
		
		System.out.println("Enter Leave End Date  ");
		String endDate=sc.next();
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		Date date1=sdf1.parse(endDate);
		
		employee.setLeaveEndDate(date1);
		
		EmployeeBAL bal=new EmployeeBAL();
		System.out.println(bal.addEmployeeBal(employee));
		
	}
	public static void main(String[] args) throws ParseException {
		int ch;
		do{
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. AddLeave");
			System.out.println("2. Show Leave");
			System.out.println("3. Search Leave");
			System.out.println("4. Delete Leave");
			System.out.println("Enter Your Choice ");
			ch=sc.nextInt();
			switch(ch){
			case 1:
				try{
					addEmployee();
				}catch(EmployException e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				showEmployee();
				break;
			case 3:searchEmployee();
			break;
			case 4:deleteEmployee();
			break;
			
				
			case 5:
				return;
			}
			
	}while(ch!=6);
		
		}
}




