package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {

	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sql = "SELECT * FROM food";
		
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53", prop);
			
			PreparedStatement pstmt=conn.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				System.out.println(name);
			}
			System.out.println("-------------------");
			
//			rs.previous();
			rs.first();
			String name=rs.getString("name");
			System.out.println(name);
			System.out.println("-------------------");
			
//			rs.absolute(5);
//			name=rs.getString("name");
//			System.out.println(name);
//			rs.deleteRow();//刪除
//			
			rs.absolute(1);
			name=rs.getString("name");
			System.out.println(name);
 
			//注意:連線關閉即無效，所以conn不能關閉
			
			rs.updateString("name", "LISA大酒店");
			rs.updateString("tel", "777");
			rs.updateRow();
			System.out.println("---");
			
			rs.moveToInsertRow();
			rs.updateString("name", "Brad大酒店V2");
			rs.updateString("tel", "9999");
			rs.updateString("addr", "");
			rs.updateString("city", "");
			rs.updateString("town", "");
			rs.updateString("picurl", "");
			rs.updateDouble("lat", 0);
			rs.updateDouble("lng",0);
			rs.insertRow();
			
			
			}catch(Exception e){
				System.out.println(e);			
			//TYPE_FORWARD_ONLY:不能做previous、first....的例外狀況	(往上做preparestatment)
			}
		
	}
}