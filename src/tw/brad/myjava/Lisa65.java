package tw.brad.myjava;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Lisa65 {
	/*127.0.0.1(本機迴路)
	 * 用戶端，傳送過去
	 * 
	 */
	
	public static void main(String[] args) {
		try {
			Socket socket=new Socket(
					InetAddress.getByName("10.0.102.150"),7777);
			
			OutputStream out=socket.getOutputStream();
			out.write("Hello,Lisa".getBytes());
			/*可傳送out的資料
			 * 
			 * 
			 */
			out.close();
			out.flush();
			
			System.out.println("Client ok");
		} catch (Exception e) {
				System.out.println(e);
		}
	}

}
