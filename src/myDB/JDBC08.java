package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 { //16

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("page="); //可以直接選定要翻到第幾頁
		int page=scanner.nextInt();
		
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		int rpp=10; //row per page(一頁有10筆資料，共139筆資料)
		int start=(page-1)*rpp; //(page)共需14頁，但要如何做呢?
		
		try {
			Connection conn= 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3309/eeit53",prop);
			
			String sql0="SELECT count (*) AS count FROM food";
			//sql語法: AS 定義便名，所以之後都需要用count來表示
			Statement stmt=conn.createStatement();
			ResultSet rs0=stmt.executeQuery(sql0);
			rs0.next(); //next:接著
			
			int total = rs0.getInt("count"); //共幾筆
			int totalPage = (int)Math.ceil(total*1.0/ rpp ) ;//Lisa78(Math.ceil)
			
			if(page>totalPage)throw new MyException();
			
			//LIMIT:限制幾筆
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
			} catch (MyException e) {
			} catch (Exception e) {
			}
	}	
}
class MyException extends Exception{
	public MyException() {
		super("Lisa Exception");
	}
}

