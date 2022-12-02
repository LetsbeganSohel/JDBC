package Lab1stDecember.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
	 public static Connection con()throws SQLException{
		 try {
			 	Class.forName("com.mysql.cj.jdbc.Driver");//registering my sql driver
		 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		 return DriverManager.getConnection("jdbc:mysql://localhost:3306/soheldb","root","Sohel9733@");
		 
	 }

	public static void main(String...args) throws Exception {
		Sql sq= new Sql();
		sq.Insert_sql();

}}
