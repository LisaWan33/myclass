package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.myclass.Member;
public class JDBC10 { //JDBC09=>>創帳號(但不安全)

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Account:"); 
		String account =scanner.next();
		
		System.out.println("Password:"); 
		String password =scanner.next();
		
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String url="jdbc:mysql://localhost:3309/eeit53";
		String sql="SELECT* FROM member WHERE account=? AND password=?";
		
		try (
		Connection conn= DriverManager.getConnection(url,prop);
		PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				Member member =new Member(rs.getInt("id"),
						rs.getString("account"),
						rs.getString("password"),
						rs.getString("realname"));
				System.out.printf("welcome ,%s",member.getRealname());
			}else {
				System.out.println("get out here!");
			}
			rs.close();
			
			
			
		}catch(Exception e) {
			
		}
	}

}
