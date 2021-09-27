package com.java.infinite.bank;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class MiniStatementMain {
	 public static void main(String[] args) {
			
   	  int accountNo;
   	  System.out.println("Enter the account NO");
   	  Scanner sc= new Scanner(System.in);
   	  accountNo=sc.nextInt(); 
   	  BankDAO dao= new BankDAO(); 
   	  List<Trans> transList=null;
      try {
    	  transList=dao.miniStatement(accountNo);
    	  for (Trans t : transList) {
			System.out.println(t);
		}
		//System.out.println(dao.miniStatement(AccountNo));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
