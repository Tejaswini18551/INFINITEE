package com.java.test;

import java.util.Scanner;

public class Time {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h1,h2,m1,m2;
		System.out.println("Enter hour and minutes(<60) of Time Zone    ");
		h1=sc.nextInt();
		m1=sc.nextInt();
		System.out.println("Enter hour and minutes(<60) of Time Zone    ");
		h2=sc.nextInt();
		m2=sc.nextInt();
		if(m1>=60 || m2>=60) {
			System.out.println("Minutes can't be greater than 59");
		} else {
			int m = m1+m2;
			int h = h1+h2;
			if(m>60) {
				h +=1;
				m -=60;
			}
			System.out.println(h+" hrs "+m+" mins");
		}
	}
}
