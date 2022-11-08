package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC09 { //讀帳號

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Account:"); 
		String account =scanner.next();
		
		System.out.println("Password:"); 
		String password =scanner.next();
		
		System.out.println("Realname:"); 
		String realname =scanner.next();
		
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String url="jdbc:mysql://localhost:3309/eeit53";
		String sql="INSERT INTO member(account,password,realname)VALUES(?,?,?)";
		
		try (
		Connection conn= DriverManager.getConnection(url,prop);
		PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			pstmt.setString(3, realname);	
			int n=pstmt.executeUpdate();
			
			if(n>0) {
				System.out.println("Register Sucess!");
			}else {
				System.out.println("Register Failure!");
			}
		}catch(Exception e) {
			
		}
	}

}
