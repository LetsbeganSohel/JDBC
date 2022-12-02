package com.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class ScannerInsert {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("  enter T_id");
			int T_id=sc.nextInt();
			System.out.println("  enter T_Name");
			String T_Name=sc.next();
			System.out.println("  enter T_gender");
			String T_gender=sc.next();
			System.out.println("  enter T_age");
			int T_age=sc.nextInt();
			System.out.println("  enter T_Marks");
			int T_Marks=sc.nextInt();
			System.out.println("  enter T_Phone");
			int T_Phone=sc.nextInt();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");   // load driver
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/soheldb","root","Sohel9733@"); // to give the connection
				//Statement stmt=con.createStatement();  
				//ResultSet rs=stmt.executeQuery("select * from Teacher");  
				// inserting data in Database table 
				PreparedStatement stmt =con.prepareStatement("insert into soheldb.Teacher values(?,?,?,?,?,?) ");
				stmt.setInt(1, T_id);
				stmt.setString(2,T_Name);
				stmt.setString(3,T_gender);
				stmt.setInt(4,T_age);
				stmt.setInt(5,T_Marks);
				stmt.setInt(6,T_Phone);
				stmt.executeUpdate();
				System.out.println("Inserted");
				con.close();
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
