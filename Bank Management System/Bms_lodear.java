package Com.Bms.Bms_loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Com.Bms.Helper;

public class Bms_lodear {
	 public  static void FetchData(long account_no) throws Exception {
		 Connection conn=Helper.con();
		 Statement stmt=conn.createStatement();
		 System.out.println(" Your details below :: \n");
		 ResultSet rs=stmt.executeQuery("SELECT * FROM soheldb.bms where account_no="+account_no);
		 while(rs.next()) {
			 System.out.println(rs.getLong(1)+" " +rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4) +" "+
		     rs.getDouble(5) +" " +rs.getInt(6));
		 }
	 }
}
