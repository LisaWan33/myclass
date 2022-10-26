package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Lisa69 {
	public static void main(String[] args) {
     /*
      * 
      * 
      * 
      */
		
		URL url;
		try {
			url = new URL("https://www.iii.org.tw");
			HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader=
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line=reader.readLine())!=null ){
				System.out.println(line);
			}
			reader.close();	
			System.out.println("-----------");
			System.out.println("ok");
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
	
}
}