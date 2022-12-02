package com.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

public class ManuDriver {
	Scanner sc= new Scanner(System.in);
	int e_id,e_age,e_salary;
	String e_name,e_city;
	public void saveManuDriver() throws SQLException{
	//public static void main(String[] args) {
	System.out.println("Enter e_id :");
	e_id=sc.nextInt();
	System.out.println("Enter e_name :");
	e_name=sc.next();
	System.out.println("Enter e_age :");
	e_age=sc.nextInt();
	System.out.println("Enter e_city :");
	e_city=sc.next();
	System.out.println("Enter e_salary :");
	e_salary=sc.nextInt();
	Connection conn=Helper.con();
	//Statement sql=conn.prepareStatement("insert into  soheldb.manuedriven values(?,?,?,?,?,) ");
	PreparedStatement stmt=conn.prepareStatement("insert into manuedriven values(?,?,?,?,?,) ");
	stmt.setInt(1,e_id);
	stmt.setString(2,e_name);
	stmt.setInt(3,e_age);
	stmt.setString(4,e_city);
	stmt.setInt(5,e_salary);
	//stmt.executeUpdate();
	System.out.println("Table is updated");
	conn.close();
	}

	//Display details About Table;
	public void  fetchManudriven()throws SQLException{
		Connection conn= Helper.con();
		Statement stmt= conn.createStatement();
		ResultSet  rs= stmt.executeQuery("SELECT * FROM soheldb.manuedriven ");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" " + rs.getString(2) +" "+ rs.getInt(3) +" "+ rs.getString(4) + "  " +rs.getInt(5)); 
		}
		conn.close();
	}
	public void  updateManudriven()throws SQLException{
		Connection conn= Helper.con();
		Statement stmt= conn.createStatement();
		System.out.println("Enter your city");
		e_city=sc.next();
		 stmt.executeQuery("update soheldb.manuedriven set e_city= ' " +e_city+ " ' where e_id= " + e_id);
		System.out.println("Table is updated succesfully");
		conn.close();
	}
	/*
	public void  deleteManudriven()throws SQLException{
		Connection conn= Helper.con();
		Statement stmt= conn.createStatement();
		ResultSet  rs= stmt.executeQuery("delete from soheldb.manuedriven where e_id=14;");
		System.out.println("Column is deleted from table successfully");
	}*/

}

