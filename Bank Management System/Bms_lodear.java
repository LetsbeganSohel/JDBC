package Com.Bms.Bms_loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Com.Bms.Helper;

public class Bms_lodear {
	 public  static void FetchData(long account_no) throws Exception {  // for fetching data from table 
		 Connection conn=Helper.con();  // craete connection 
		 Statement stmt=conn.createStatement();   // statement 
		 System.out.println(" Your details below :: \n");
		 ResultSet rs=stmt.executeQuery("SELECT * FROM soheldb.bms where account_no="+account_no);
		 //  query taking all details of user 
		 while(rs.next()) {  // loop for taking detalis 
			 System.out.println(" Account  number is :"+rs.getLong(1)+ "\n" + 
		 "Account Holder name  :" +rs.getString(2)+"\n " 
		+ "IFSC code of user : " +rs.getString(3)+"\n "+
		 "Brach name of User :  "+rs.getString(4) +"\n "+
		     "Account Balance :"+rs.getDouble(5) +"\n "+
		 "Pin  of user : "+rs.getInt(6));
		 }
	 }
}
