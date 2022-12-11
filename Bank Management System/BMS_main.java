package Com.Bms.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Scanner;

import Com.Bms.Helper;
import Com.Bms.Bms_loader.Bms_lodear;
import Com.Bms.*;
// to get data 
public class BMS_main {
	Scanner sc= new Scanner(System.in);   //  for take user input 
	long account_no;                                      // decleared variable 
	int pin;                                                            // decleared variable 
	double balance;                                              // decleared variable 
	String account_holdername,ifsc_code,branch;       // decleared variable 
	
	// inserting Data
	public void inseret_data () throws Exception {            // creat a class to take data from user
      System.out.println("Enter account_no");                        // taking  user account number 
	long account_no=sc.nextLong();
	System.out.println("Enter account_holdername");          // taking account holder name 
	String account_holdername=sc.nextLine();
	System.out.println("Enter Ifsc code");                                // taking user ifsc code 
	String ifsc_code=sc.nextLine();
	System.out.println("enter branch name");                        // taking branch name of account holder 
	String branch = sc.nextLine();
	System.out.println("Enter your ammount , not less than 500 \n  Balance should be  Double valued ");                    // taking primary deposit 
	double balance=sc.nextDouble();
	System.out.println("Enter pin");                                             // taking pin 
	int pin=sc.nextInt();
	Connection conn = Helper.con();                                             // create connection help of Helper class
	PreparedStatement stmt=conn.prepareStatement("insert into bms values(?,?,?,?,?,?)");//insert data into database 
	stmt.setLong(1, account_no);                      // input data into database 
	stmt.setString(2, account_holdername);              // input data into database 
	stmt.setString(3,ifsc_code);                    // input data into database 
	stmt.setString(4,branch);                       // input data into database 
	stmt.setDouble(5,balance);                // input data into database 
	stmt.setInt(6, pin);                           // input data into database 
	stmt.executeUpdate();                  // to update table 
	System.out.println("Your account is created ");// 
	 conn.close();                           // close connection 
}
	// Withdraw Amount
	
	 public void Withdrawl() throws Exception {                   // For withdraw money 
		 System.out.println("Enter your account_number");  // enter account number by user 
		 long Acc=sc.nextLong();
		 double bal = 0;     // create variable 
		 int upin = 0;           // create variable 
		 Connection conn=Helper.con();                                 // create connection help of Helper class
		 Statement stmt=conn.createStatement();                // create statement 
		 ResultSet rs=stmt.executeQuery("select *from soheldb.bms;"); // take data from database 
		 if(rs.next()) {                                                                                   // taking data from database 
			 long acc=rs.getLong("account_no");                                    // taking account number from database
			 double Tbal=rs.getDouble("balance");                                   // taking account balance from database
			 int p=rs.getInt("pin");                                                              // taking pin of user  from database
			 if ( Acc==acc){                                                                             // checking account 
				 System.out.println("enter your pin");                               // taking pin from user 
				  upin=sc.nextInt();
				  if(p==upin) {                                                                           // checking pin correct or not 
					  System.out.println("Enter ammount you want");
					  bal=sc.nextDouble();                                                             // asking user for withdraw amount 
					  if(bal<=Tbal) {                                                                         // checking balance is sufficent or not 
							System.out.println("You are withdrawing " +bal);  // show amount which he/she withdraw
							Tbal=Tbal-bal;
							 stmt.executeUpdate("update soheldb.bms set balance="+Tbal+" where account_no="+Acc);// update table after withdraw
							 System.out.println(" Your account balance is " + Tbal);  // showing balance 
					  }
					  else {
						  System.out.println("You have not enough amount in your account");// if amount is insufficient 
					  }
				  }
				  else {
					  System.out.println("Please entered right pin");// if pin  is incorrect 
				  }
			 }
			 else {
				 System.out.println("You entered wrong Account Number " );// if account number is incorrect 
				 }
		 }
		 conn.close(); // close connection 
	 }
	 
	  // Diposite Amount
	 public void Deposit() throws Exception {      // for deposite amount 
		 Connection conn=Helper.con();                      // give the connection help of Helper class 
		 Statement stmt=conn.createStatement();    // create statement 
		 System.out.println("Enter your account_number");  // asking account number 
		 long Acc=sc.nextLong();
		 ResultSet rs=stmt.executeQuery("select *from soheldb.bms;");   // taking data from database 
		 if(rs.next()) {                                                                         // for taking data from table 
				long acc=rs.getLong("account_no");                        // asking user account number 
				if( acc==Acc) {                                                                    // checking account number 
					double dip=rs.getDouble("balance");                      // taking balance from table 
					 System.out.println("Enter Your ammount");     // asking user for deposit  amount 
					double val = sc.nextDouble();
					double amount=dip+val;                                            // after deposite 
					 stmt.executeUpdate("update soheldb.bms set balance="+amount+" where account_no="+Acc);// update table after deposite 
					System.out.println("Your current balance is : " +amount);  //showing current balance 
				}
				else {
					System.out.println("Choose correct account number");// if give wrong account number 
				}
	 }
		 conn.close();  // connection close 
	 }
	 // Close Account
	 public void CloseAccount() throws Exception {                     // for closeing account 
		 Connection conn=Helper.con(); 
		 Statement stmt=conn.createStatement();
		 System.out.println("Enter your account_number");           // asking account number 
		 long Acc=sc.nextLong();
		 ResultSet rs=stmt.executeQuery("select *from soheldb.bms;"); // taking data from table 
		 if(rs.next()) {
			 long acc=rs.getLong("account_no");                          // account numbers of table 
			 if(acc==Acc) {                                                             // matching account number 
				 stmt.executeUpdate("delete from soheldb.bms where account_no="+Acc);   // query to delet account 
				 System.out.println("Your account is deleted");
				 }
			 else {
					 System.out.println("Sorry! \n  try again");   // if account doesnot match 
					 }
			 }
		 conn.close(); // connection close 
	 }
	 
	 
	 
	 // Showing Balance 
	 public void Display_details() throws Exception { // for display account details 
		 Connection conn=Helper.con();
		 Statement stmt=conn.createStatement();
		 System.out.println("Enter your account_number");  //asking account  number 
		 long Acc=sc.nextLong();
		 ResultSet rs=stmt.executeQuery("select *from soheldb.bms;");// take data from table 
		 if(rs.next()) {
			 long acc=rs.getLong("account_no"); // taking all details from table 
			 if(Acc==acc) {                                           // checking match account details 
				  stmt.executeQuery("select *from soheldb.bms where account_no="+Acc);//query to take details of user  
				 Bms_lodear.FetchData(acc);    // calling methode to show details 
			 }
			 else {
				 System.out.println("Enter correct Account number!!\nPlease try again");  // if account number doesnot match 
                System.out.println(" Create Account ");  // asking user to creste account 
              System.out.println("Enter your choise  . Press   '1'  for yes \n  '2'  for no"); // for switch case
              int a=sc.nextInt();  // taking input from user 
              switch(a){
              case 1:
            	  inseret_data ();   // if yes  to call insert methode 
            	  break;
              case 2:
            	 System.out.println("Thank you for visiting");// if no 
            	 break;
            	 default :
            		 System.out.println("Insert a valid choise");  // if choise does not match 
              }
              
                }
		 }
	 }

	 
	 
// creating Account 
public void Create_account() throws Exception {  // create account class 
	 Connection conn=Helper.con();
	 Statement stmt=conn.createStatement();
	 System.out.println("Enter your account_number");   // Asking account number 
	 long Acc=sc.nextLong();
	 ResultSet rs=stmt.executeQuery("select *from soheldb.bms ;"); // taking data from table 
	 if(rs.next()) {                                            // taking data from table 
		 long acc=rs.getLong("account_no");     // taking account number from table 
		 if(acc==Acc) {                                                // checking accounyt number 
			  stmt.executeQuery("select *from soheldb.bms where account_no="+Acc);// quere  if present 
			 Bms_lodear.FetchData(Acc);  //   for fetching   data  call methode 
			 } 
		 else {
				 System.out.println("Create your account"); // if account number does not match 
				 inseret_data ();                       // for creating account call methode 
				 }	
}
	 conn.close();  // close conection 
}
}

