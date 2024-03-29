package myDB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import tw.brad.myclass.BCrypt;
import tw.brad.myclass.Bike;

public class JDBC15 { //從java匯入照片至資料庫，但是是以id的方式辨別放入位置

	public static void main(String[] args) { //18
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());

		String sql = "UPDATE member SET icon = ?, bike = ? WHERE id = ?";
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			FileInputStream fin = new FileInputStream("dir1/ball0.png");
			
			pstmt.setBinaryStream(1, fin);
			pstmt.setObject(2, b1);
			pstmt.setInt(3, 4);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
			fin.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}