package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.ClientPreparedStatement;

public class JDBC04 {

	public static void main(String[] args) {
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
		Connection conn= DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53",prop);
			
		//3. SQL statement	
		String sql1="INSERT INTO cust(cname,tel,birthday)VALUES"+
		"('TONY','111','1999-01-01'),"+
		"('TONY','111','1999-01-01'),"+
		"('BRAD','333','1968-04-01') ";
		
		String sql2="SELECT*FROM cust";
		String sql3="DELETE FROM cust WHERE id>=4";
		String sql4="UPDATE cust SET cname='Eric',tel='888',birthday='1997-10-06' WHERE id='3' ";
		
		Statement stmt =conn.createStatement();
		int count =stmt.executeUpdate(sql4);
		System.out.println(count); //得知更改了幾筆資料
		
			conn.close();
			System.out.println("ok2");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

}
