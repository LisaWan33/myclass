package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("keyword= ");
		String key=scanner.next();
		
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn= 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3309/eeit53",prop);
			
			String sql="SELECT*FROM food WHERE name LIKE ? OR addr LIKE ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + key + "%"); //連接第一個 ?，可以得知%key%資料
			pstmt.setString(2, "%" + key + "%");
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");	
				String addr = rs.getString("addr");
				System.out.printf("%s : %s\n", name, addr);
			}
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
		}
	}

}
