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

public class Lisa70 {
	public static void main(String[] args) {
     /*可以從網路抓照片下來(Lisa70)、可以將網頁轉成PDF
      * URL url = new URL("輸入網站");
      * URL url = new URL("https://pdfmyurl.com/"""?url="""輸入網址");
      * 
      */
		
		try { 
			URL url = new URL("https://pdfmyurl.com/?url=https://www.theguardian.com/commentisfree/2018/apr/11/cats-why-are-kittens-so-cute");
			HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedOutputStream bout
				=new BufferedOutputStream(
						new FileOutputStream("dir1/Lisa.pdf"));
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