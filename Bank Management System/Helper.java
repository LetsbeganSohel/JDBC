package Com.Bms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Com.Bms.Main.BMS_main;

public class Helper {
	
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
			 
		 }

		public static void main(String...args) throws Exception {
			BMS_main Bm=new BMS_main();
			Scanner sc =new Scanner(System.in); 
			System.out.println("""
					Press 1 for Display_Details : 
					Press 2 for Diposite Amount:
					Press 3 for Withdraw Amount :
					Press 4 for Colse Account :
					Press 5 for Create Account : 
					""");
			int variable = sc.nextInt();
			System.out.println("-------------------------------");
			switch(variable) {
			case 1 : 
			    Bm.Show_balance();
			  break;
			case 2 :  
				Bm.Deposit();
				break;
			case 3 :
				Bm.Withdrawl();
				break;
			case 4 :
				Bm.CloseAccount();
				break;
			case 5 :
			Bm.Create_account();
				break;
			}		
}
		}
