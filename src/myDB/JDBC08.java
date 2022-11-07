package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("page=");
		int page=scanner.nextInt();
		
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		int rpp=14; //row per page
		int start=(page-1)*rpp;
		
		try {
			Connection conn= 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3309/eeit53",prop);
			
			String sql1="SELECT count (*) AS count FROM food";
			Statement stmt=conn.createStatement();
			ResultSet rs1=stmt.executeQuery(sql1);
			rs1.next();
			int total=re1.ge
			
			String sql=String.format("SELECT*FROM food LIMIT %d,%d",start,rpp);
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id=rs.getString("id");
				String name=rs.getString("name");	
				String addr = rs.getString("addr");
				System.out.printf("%s:%s:%s\n",id, name, addr);
						}
						rs.close();
						conn.close();
					} catch (SQLException e) {
			}
	
		}
	
	}
