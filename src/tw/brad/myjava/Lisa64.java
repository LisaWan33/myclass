package tw.brad.myjava;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ServerCloneException;

public class Lisa64 {
	public static void main(String[] args) {
		/*TCP
		 * server端，收回來，服務端
		 * ServerSocket(int port)
		 * Lisa64=>>>Lisa65
		 * 64聽65的
		 */
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("listen.....");
			Socket socket=server.accept();
			
			
			InputStream in=socket.getInputStream();
			int c ;
			while((c=in.read())!=-1) {
				System.out.print((char)c);
			}in.close();
			
			server.close();
			
			
			String IP=socket.getInetAddress().getHostAddress();
			
			System.out.println("server ok:"+IP);
			//得到傳過來的ip
		
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
	
	
	
	}

}
