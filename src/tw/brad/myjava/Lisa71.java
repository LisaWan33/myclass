package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Lisa71 {
	public static void main(String[] args) {
     /*承襲Lisa70
      * 
      * 
      * 
      */
		
		try { //可以從網路抓照片下來
			URL url = new URL("https://pawsworld.net/wp-content/uploads/2021/04/37d598e5a04344da81c76621ba273915.jpg");
			HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedOutputStream bout
				=new BufferedOutputStream(
						new FileOutputStream("dir1/newcat.jpg"));
			BufferedInputStream bin=new BufferedInputStream(conn.getInputStream());
			int len;byte[]buf=new byte[16*1024];
			
			
			while((len=bin.read(buf))!=-1 ){
				bout.write(buf,0,len);
			}
			bin.close();
			bout.flush();
			System.out.println("ok");
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
	
}
}