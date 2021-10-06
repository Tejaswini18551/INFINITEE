package com.java.test;


import java.util.Scanner;

public class ExceptionDemo {
	
	public void check(String str) throws CustomException {
		String specialCharacters=", # @ $";
		for(int i=0;i<str.length();i++) {
			if(specialCharacters.contains(Character.toString(str.charAt(i)))) {
				throw new CustomException("Invalid Statement");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Statment");
		String str=sc.nextLine();
		try {
			new ExceptionDemo().check(str);
		}catch(CustomException e) {
			e.printStackTrace();
		}
	}
}