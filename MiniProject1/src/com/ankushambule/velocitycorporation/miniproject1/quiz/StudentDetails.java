package com.ankushambule.velocitycorporation.miniproject1.quiz;

import java.sql.*;
import java.util.*;

public class StudentDetails{
	Scanner scanner = new Scanner(System.in);
	static String firstname;
	static String lastname;
	static String city;
	static int score;
	static String Class;
	
	char choice;
	public void getStudentDetails() throws SQLException{
		
		do{
			System.out.println("Enter the no of students eligible for quiz");
			int no = scanner.nextInt();
			for(int i=1; i<=no; i++) {
				System.out.println("To Start the Quiz Enter the Student Details : ");
				
				System.out.println("Enter First Name : ");
				firstname = scanner.next();
				
				System.out.println("Enter Last Name : ");
				lastname = scanner.next();
				
				System.out.println("Enter City : ");
				city = scanner.next();
				
				List<String> linkedlist = new LinkedList<String>();
				linkedlist.add(firstname);
				linkedlist.add(lastname);
				linkedlist.add(city);
				
				StudentDetails studentdetails = new StudentDetails();
				studentdetails.RetrieveQuizdata();
				
				Connection con = null;
				PreparedStatement ps=null;
				try {
					ConnectionTest connectiontest1=new ConnectionTest();
					con = connectiontest1.getConnectionDetails();
	                ps = con.prepareStatement("Insert into students(firstname, lastname, city, score, class) values(?, ?, ?, ?, ?)");
	                ps.setString(1, firstname);
	                ps.setString(2, lastname);
	                ps.setString(3, city);
					ps.setInt(4, score);
					ps.setString(5, Class);
					int b = ps.executeUpdate();
					System.out.println("inserted data in database"+b);
					
					con.close();
					ps.close();
							
				}catch(Exception e) {
					System.out.println(e);
				}
			
			}
							
			System.out.println("Do you want to Continue with Next student: Press y/n ");
			choice = scanner.next().charAt(0);
		}while(choice=='y' || choice=='Y');
		scanner.close();
			
		}
		
	int count;

	public void RetrieveQuizdata() throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		
		System.out.println("Quiz is Starting now.......");
		ConnectionTest connectiontest=new ConnectionTest();
		con = connectiontest.getConnectionDetails();
		ps = con.prepareStatement("Select * from javaquestions");
		
		ResultSet rs=ps.executeQuery();
		count=0;
		
		int ch;
		while(rs.next()) {
			System.out.print("Question No. "+rs.getInt(1)+") ");
			System.out.println(rs.getString(2));
			System.out.println("Option (1) : "+rs.getString(3));
			System.out.println("Option (2) : "+rs.getString(4));
			System.out.println("Option (3) : "+rs.getString(5));
			System.out.println("Option (4) : "+rs.getString(6));
			rs.getInt(7);
			
			
			
			System.out.println(" ");
			System.out.println("Enter your Answere :1/2/3/4");
			ch = scanner.nextInt();
			
			int ans = rs.getInt(7);
			ArrayList<Integer> al=new ArrayList<Integer>();
			al.add(ans);
			for (int i:al) {
				System.out.println("Correct Answere is : "+i);
				if(ch==i) {
					count++;
					System.out.println("Congrats Your Answere is Correct.........");
				}
				else {
					System.out.println("Wrong Answere........");
				}
		
			}	
		
		}
		rs.close();
		con.close();
		
		System.out.println("Your Score is : "+count);
		score=count;
		
		if(count>=8 && count<=10) {
			Class="A";
			System.out.println("Class : "+Class);
		}
		else if(count>=6 && count<8) {
			Class="B";
			System.out.println("Class : "+Class);
		}
		else if(count==5) {
			Class="C";
			System.out.println("Class : "+Class);
		}
		else {
			Class="D";
			System.out.println("Class :"+Class);
			System.out.println("You are fail");
		}
	
	}
	
}
	
	