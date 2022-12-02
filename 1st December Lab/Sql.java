package Lab1stDecember.com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Lab1stDecember.com.Helper;

public class Sql {
	int Dept_id,e_id,e_sal,e_con,pf;
	String Dept_name, Dept_head,Dept_desc,e_name,e_add;
	
	void Insert_sql() throws SQLException {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter Depertment dept_id");
	int Dept_id=sc.nextInt();
	System.out.println("Enter Employee e_id");
	int e_id=sc.nextInt();
	System.out.println("Enter Employee e_sal");
	int e_sal=sc.nextInt();
	System.out.println("Enter Employee e_con");
	int e_con=sc.nextInt();
	System.out.println("Enter e_name");
	String e_name=sc.next();
	System.out.println("Enter e_add");
	String e_add=sc.next();
	System.out.println("Enter  Dept_name");
	String Dept_name=sc.next();
	System.out.println("Enter Dept_head");
	String Dept_head=sc.next();
	System.out.println("Enter Dept_desc");
	String Dept_desc=sc.next();
	Connection conn=Helper.con();
	PreparedStatement stmt=conn.prepareStatement("insert into soheldb.employee values(?,?,?,?,?)");
	PreparedStatement stmt1=conn.prepareStatement("insert into soheldb.depertment values(?,?,?,?)");
	stmt.setInt(1, e_id);
	stmt.setString(2, e_name);
	stmt.setString(3, e_add);
	stmt.setInt(4, e_sal);
	stmt.setInt(5, e_con);
	stmt1.setInt(1,Dept_id);
	stmt1.setString(2, Dept_name);
	stmt1.setString(3, Dept_head);
	stmt1.setString(4, Dept_desc);
	stmt.executeUpdate();
	stmt1.executeUpdate();
	ResultSet rs=stmt.executeQuery("SELECT * FROM soheldb.depertment ");
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));			
	}	
	ResultSet rs1=stmt1.executeQuery("SELECT * FROM soheldb.employee ");
	while(rs1.next()) {
		System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getInt(4)+" "+rs1.getInt(5)+" " +rs1.getInt(6));			
	}	
	if( e_id == e_sal ||e_add==e_name) {
		System.out.println("Deplicate value Inserted");
	}
	else if( Dept_name==Dept_head || Dept_desc==Dept_head){
		System.out.println("Deplicate value Inserted");
	}
	else if(e_sal>1000 && e_sal<30001) {
		System.out.println("You are not able to do it");
	}
	else {
		System.out.println("You are Allowed  to inseret it");
	}
	if(e_sal>1000 && e_sal<10000) {
		pf=e_sal+(e_sal*(5/100));
		System.out.println("" +pf);
	}
	else if(e_sal>10000 && e_sal<100000) {
		pf=e_sal+(e_sal*(6/100));
		System.out.println(pf);
	}
	else {
		pf=e_sal+(e_sal*(7/100));
		System.out.println(pf);
	}
	conn.close();
}
}
