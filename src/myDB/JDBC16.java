package myDB;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.myclass.Bike;

public class JDBC16 {
	//從資料庫匯入到電腦(INPUTSTREAM)，在儲存到某個位置(OUTPUTSTREAM):這裡用匯入icon照片的方式。(第二招)
	//但若是要匯檔至網路，就用INPUTSTREAM "in"就好了
	//用腳踏車匯入回來，因為是可序列化<屬性>，所以要使用getbinarystream還原狀態，然後去確認，是不是(instanceof)那個class Bike

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String sql = "SELECT * FROM member WHERE id = ?";
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
//			Object obj = rs.getObject("bike");
//			if (obj instanceof Bike) {
//				System.out.println("bike");
//			}else {
//				System.out.println("non-bike");
//			}
			//傳輸到資料庫1
			InputStream in2 = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in2);
			Object obj = oin.readObject();
			
			//只是在確認
			if (obj instanceof Bike) {
				System.out.println("bike");
			}else {
				System.out.println("non-bike");
			}
			/////////////////////////////////////////////
			Bike b2 = (Bike)obj;
			System.out.println(b2.getSpeed());
			
			in2.close();
			
			FileOutputStream fout = new FileOutputStream("dir2/cat3.png");
			
			//傳輸到資料庫1
			InputStream in = rs.getBinaryStream("icon");
			byte[] buf = new byte[1024]; int len;
			while ( (len = in.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			in.close();
			
			fout.flush();
			fout.close();
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}