package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.myclass.BCrypt;
import tw.brad.myclass.Member;



public class JDBC12 { //登入機制 //處理
	
	private final static String url = "jdbc:mysql://localhost:3309/eeit53";
	private final static String sql = "SELECT * FROM member WHERE account = ?";
	private final static String sqlUpdate = 
		"UPDATE member SET password = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String password = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(password, rs.getString("password"))) {
					Member member = new Member(rs.getInt("id"), 
							rs.getString("account"), 
							rs.getString("password"),
							rs.getString("realname"));
					System.out.printf("Welcome, %s", member.getRealname());
					
					System.out.println("Change Password...");
					
					System.out.print("Old Password: ");
					String oldPassword = scanner.next();
					// check oldPassword
					if (BCrypt.checkpw(oldPassword, member.getPassword())) {
						System.out.print("New Password: ");
						String newPassword = scanner.next();
						
						// change newPassword
						PreparedStatement pstmt2 = conn.prepareStatement(sqlUpdate);
						pstmt2.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
						pstmt2.setInt(2, member.getId());
						
						
						
						if (pstmt2.executeUpdate() != 0 ) {
							System.out.println("Change password success");
						}else {
							System.out.println("Change password failure");
						}
					}else {
						System.out.println("Password not match!");
					}
					
				}else {
					System.out.println("XX");
				}
			}else {
				System.out.println("get out here");
			}
			
			rs.close();
			
		}catch(Exception e) {
			
		}
	}
	
}