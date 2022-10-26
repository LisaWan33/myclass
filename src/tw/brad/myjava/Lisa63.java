package tw.brad.myjava;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Lisa63 {

	public static void main(String[] args) { 
		
		/*掃對方的port號
		 * 用戶端
		 * hostname:主機(10.0.102.45)
		 * 會拿到socket的物件實體
		 * 
		 * InetAddress.getByName=>>>unknowhostexception
		 * socket=>>>
		 */
		
		
		try {
			Socket socket=new Socket(
					InetAddress.getByName("10.0.102.45"),3306);
			System.out.println("ok");
		} catch (Exception e) {
				System.out.println(e);
		}

	
	}

}
