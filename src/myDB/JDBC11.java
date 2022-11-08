package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.myclass.BCrypt;

public class JDBC11 {
	private static Connection conn;
	private final static String url = "jdbc:mysql://localhost:3309/eeit53";
	private final static String sqlCheck = "SELECT count(*) count FROM member WHERE account = ?";
	private static final String sqlInsert = "INSERT INTO member (account,password,realname) VALUES (?,?,?)";
	
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
		
		try {
			conn = DriverManager.getConnection(url, prop);
			if (checkAccount(account)) {
				if (addData(account,password,realname)) {
					System.out.println("OK");
				}else {
					System.out.println("Insert XX");
				}
			}else {
				System.out.println("Account XX");
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
	
	static boolean checkAccount(String account) { //確定新增的帳號是否重複的關鍵，若重複即不可做帳號設立。
		boolean ret=false;
		try(
			PreparedStatement pstmt=conn.prepareStatement(sqlCheck)){
				pstmt.setString(1, account);
				ResultSet rs=pstmt.executeQuery();
				rs.next();
				ret = rs.getInt("count") == 0;
				pstmt.close();
		}catch(Exception e) {}
			return ret;
		}
	
	
	static boolean addData(String account,String password,String realname ) {
		boolean ret = false;
		try(
		PreparedStatement pstmt=conn.prepareStatement(sqlInsert)){
			
		
			pstmt.setString(1, account);
			pstmt.setString(2,BCrypt.hashpw(password, BCrypt.gensalt()));
			pstmt.setString(3, realname);
			ret=pstmt.executeUpdate()!=0;
			pstmt.close();
		}catch(Exception e) {
			
		}
		return ret;
		

	}
}
