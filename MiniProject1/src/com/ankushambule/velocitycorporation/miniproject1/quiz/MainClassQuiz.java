package com.ankushambule.velocitycorporation.miniproject1.quiz;

import java.util.*;

public class MainClassQuiz {

	public static void main(String[] args) {
		System.out.println("Enter Username(1996) and Password(1996) for Login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Username : ");
		int username = scanner.nextInt();
		System.out.println("Enter Password : ");
		int password = scanner.nextInt();
		if(username==1996 && password==1996) {
			System.out.println("Login Successfull....");
			try {
				StudentDetails studentdetails=new StudentDetails();
				studentdetails.getStudentDetails();
				
			}catch(Exception e) {
				System.out.println(e+" Run again with correct username and password");
			}
		}
		else {
			System.out.println("Invalid Username or Password......Run Again ");
			System.out.println("Enter Username = 1996 ");
			System.out.println("Enter Password = 1996 ");
		}
		scanner.close();	    
			
	}

}
