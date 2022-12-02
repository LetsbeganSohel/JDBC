package com.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insertjdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");   // load driver
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/soheldb","root","Sohel9733@"); // to give the connection
				Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Teacher");  
			if(rs.isClosed()) {
				System.out.println("connection is closed");
			}
			else {
				System.out.println("Connection is given");
				
			}
			//stmt.executeUpdate("insert into Teacher  values(8,'Totan',45,499,9875432)");
			//stmt.executeUpdate("insert into Teacher  values(9,'Saurav',48,503,876543421)");
			stmt.executeUpdate("insert into Teacher  values(10,'Anirban',47,567,87540987)");
			System.out.println("Inserted");
		}

		catch(Exception e) {
			e.getStackTrace();
		}
	}

}
