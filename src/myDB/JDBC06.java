package myDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC06 {

	public static void main(String[] args) {
		// URL
		//HttpURLConnection
		//InputStream=>JSON String
		//parse JSON String
		//connection DB=>eeit53=>food table
		//PreparedStatement
		
		 try {
			String json = getJSONString();
			
			parseJSON(json);//直接呼叫
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static String getJSONString()throws Exception {
		URL url=new URL(
				"https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
		
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();//(HttpsURLConnection)url:強制轉型
		conn.connect();
		
		StringBuffer sb= new StringBuffer();
		try(BufferedReader reader=
				new BufferedReader(new InputStreamReader(conn.getInputStream()))){
			String line;
			while ( (line = reader.readLine()) != null) {
				sb.append(line); 
			}
		};
		return sb.toString();
	}

static void parseJSON(String json) throws Exception{
	Properties prop= new Properties();
	prop.put("user", "root");
	prop.put("password", "root");
	
	Connection conn= 
			DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53",prop);
	Statement stmt=conn.createStatement();
	stmt.execute("DELETE FROM food");
	stmt.execute("ALTER TABLE food AUTO_INCREMENT = 1");
	
	String sql="INSERT INTO food(name,addr,tel,city,town,picurl,lat,lng) "
			+ "VALUES (?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt =conn.prepareStatement(sql);
	
	
	JSONArray root =new JSONArray(json);
	
	System.out.println("size:"+root.length());
	for(int i=0;i<root.length();i++) {
		JSONObject row=root.getJSONObject(i);
		
		pstmt.setString(1, row.getString("Name"));
		pstmt.setString(2, row.getString("Address"));
		pstmt.setString(3, row.getString("Tel"));
		pstmt.setString(4, row.getString("City"));
		pstmt.setString(5, row.getString("Town"));
		pstmt.setString(6, row.getString("PicURL"));

		//會發現經、緯度會有空值現象，需處理=>Double.parseDouble()
		try {
			pstmt.setDouble(7, Double.parseDouble(row.getString("Latitude")));
		}catch (Exception e) {
			System.out.println(row.getString("Name") +":error1");
			pstmt.setDouble(7, 0); //將第七筆資料，在例外狀況時，設置成為0的值
		}
		
		try {
			pstmt.setDouble(8, Double.parseDouble(row.getString("Longitude")) );
		}catch(Exception e) {
			System.out.println(row.getString("Name") +":error2");
			pstmt.setDouble(8, 0);
		}
		pstmt.executeUpdate();
	}
	pstmt.close();
	conn.close();
}
}