package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Lisa62 {

	public static void main(String[] args) {
		while (true) {
			byte[] buf = new byte[1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				/*DatagramPacket(byte[] buf,int length)：
				 * 以一個空陣列來建立DatagramPacket物件，該物件的作用是
				 * 接收DatagramSocket中的資料。
				 * 
				 * 
				 */
				
				
				/* DatagramSocket(int prot)：
				 * 建立一個DatagramSocket例項，並將該"物件"
				 * 繫結到本機預設IP地址、指定埠。
				 * 
				 * receive(DatagramPacket p)：
				 * 從該DatagramSocket中接收資料報。
				 * send(DatagramPacket p)：
				 * 以該DatagramSocket物件向外傳送資料報。
				 * 
				 * DatagramPacket物件，該物件的作用是
				 * 接收DatagramSocket中的資料。
				 * 
				*/
				
				socket.receive(packet);
				socket.close();
				
				String remoteIp =  packet.getAddress().getHostAddress();
				byte[] data = packet.getData();
				int len = packet.getLength();
				
				String mesg = new String(data,0,len);
				System.out.println(remoteIp + ":" + mesg);
				if (mesg.equals("bye")) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
