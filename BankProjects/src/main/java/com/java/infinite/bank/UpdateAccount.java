package com.java.infinite.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccount {
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	Bank bank= new Bank();  
	System.out.println("Enter AccountNO");
	bank.setAccountNo(sc.nextInt());
	System.out.println("Enter FirstName   ");
	bank.setFirstName(sc.next());
	System.out.println("Enter LastName  ");
	bank.setLastName(sc.next());
	System.out.println("Enter City  ");
	bank.setCity(sc.next());
	System.out.println("Enter State  ");
	bank.setState(sc.next());
	System.out.println("Enter Amount   ");
	bank.setAmount(sc.nextInt());
	System.out.println("Enter CheqFacil  ");
	bank.setCheqFacil(sc.next());
	System.out.println("Enter AccountType ");
	bank.setAccountType(sc.next()); 
	BankDAO dao= new BankDAO();
	try {
		System.out.println(dao.UpdateAccount(bank));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
