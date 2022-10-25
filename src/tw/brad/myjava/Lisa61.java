package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Lisa61 {

	public static void main(String[] args) {
		/*建立插座
		 * 
		 * 
		 */
		String mesg = "Hello, Lisa";
		byte[] mesgData = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = 
				new DatagramPacket(mesgData, mesgData.length, 
					InetAddress.getByName("10.0.102.150"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
