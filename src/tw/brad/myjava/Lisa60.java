package tw.brad.myjava;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.UnexpectedException;

public class Lisa60 {

	public static void main(String[] args) {
		try {
			InetAddress ip= InetAddress.getByName("www.yahoo.com.tw"); //主機名稱
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
		
	//TCP/UDP	
	}

}
