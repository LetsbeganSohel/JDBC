package Com.Bms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Com.Bms.Main.BMS_main;

public class Helper {              // creating helper class
	
		static {                               
			 try {
			 	Class.forName("com.mysql.cj.jdbc.Driver");//registering my sql driver
		 }
			 catch(Exception e) {
				 e.printStackTrace();
				 }
			 }
		 public static Connection con() throws Exception{
			 return DriverManager.getConnection("jdbc:mysql://localhost:3306/soheldb","root","Sohel9733@");
			 // give connection 
		 }

		public static void main(String...args) throws Exception {         // main methode with exception 
			BMS_main Bm=new BMS_main();           // create object of main class 
			Scanner sc =new Scanner(System.in);      // take user input 
			System.out.println("""
					Press 1 for Display_Details :           
					Press 2 for Diposite Amount:
					Press 3 for Withdraw Amount :
					Press 4 for Colse Account :
					Press 5 for Create Account : 
					""");                                                            // user choise 
			int variable = sc.nextInt();
			System.out.println("-------------------------------");
			switch(variable) {                  // using switch case 
			case 1 : 
			    Bm. Display_details();            // calling methode by the reference 
			  break;
			case 2 :  
				Bm.Deposit();                          // calling methode by the reference 
				break;
			case 3 :
				Bm.Withdrawl();                      // calling methode by the reference 
			break;
			case 4 :
				Bm.CloseAccount();                        //  // calling methode by the reference 
				break;
			case 5 :
			Bm.Create_account();                         // calling methode by the reference 
				break;
				default :
					System.out.println("Take valid choise ");
					
			}		
}
		}
