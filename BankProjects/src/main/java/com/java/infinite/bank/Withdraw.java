package com.java.infinite.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class Withdraw {
       public static void main(String[] args) throws ClassNotFoundException, SQLException { 
    	   int withdrawAmount;
	  int accountNo; 
	  System.out.println("enter accno");
	  Scanner sc= new Scanner(System.in);
	  accountNo=sc.nextInt(); 
	  System.out.println("enter withdraw amount"); 
	  withdrawAmount=sc.nextInt();
	  BankDAO dao= new BankDAO();
	  System.out.println(dao.withdrawAccount(accountNo, withdrawAmount));
	  
}
}