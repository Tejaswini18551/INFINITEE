package com.java.test;

public class Alpha {

	private int ch;
	
	void uppercaseAlphabets()
	{
		for (char c = 'A' ; c <= 'Z'; ++c)
			System.out.print("" + c);
		System.out.print("\n");
	}
	void lowercaseAlphabets()
	{
		for (char c = 'a' ; c <= 'z'; ++c)
			System.out.print("" + c);
		System.out.print("\n");
	}
	
	public static void main (String[] args)
	{
		System.out.println("uppercase Alphabets");
		Alpha ob = new Alpha();
		ob.uppercaseAlphabets();
		
		System.out.println("lowercase Alphabets");
		ob.lowercaseAlphabets();
		
		
	}
}
