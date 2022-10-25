package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Lisa61 {

	public static void main(String[] args) {
		/*建立插座
		 * UDP重要的兩個類別：DatagramSocket、DatagramPacket。
		 * 提供接收端與傳送端調用API
		 * UDP傳輸量較大，相較TCP迅速。
		 * 缺點是不可靠，程式需自行建立可靠機制。
		 * 
		 * 
		 * DatagramSocket:
		 * 提供UDP通訊的介面，沒有連線的概念。
		 * 表示為發送端與接收端的連線接口
		 * 
		 * 1.DatagramSocket()
		 * 2.DatagramSocket(int port)
		 * 3.DatagramSocket(int port, InetAddress laddr)
		 * 
		 * 第一個建構式沒有參數，用來為client綁定隨機的port做使用。
		   第二個建構式可建立server綁定固定的port。
		   第三個架構式可以綁定server固定的IP address。
		 * 
		 * DatagramPacket:
		 * 在資料傳輸過程中，使用DatagramPacket 作為資料容器傳遞。
		 * UDP因為沒有建立連線，資料容易丟失，不會有重複傳送的機制。
		 * 
		 * 1.DatagramPacket(byte[] buf, int length)
		 * 2.DatagramPacket(byte[] buf, int length, InetAddress address, int port)：
		 * 
		 * 第一建構式建立的DatagramPacket提供DatagramSocket的receive()方法使用。
		   第二建構式建立的DatagramPacket提供DatagramSocket的send()方法使用。
		   需要指定destination的address與port。
		 * 
		 */
		String mesg = "Hello, Lisa";
		byte[] mesgData = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = 
				new DatagramPacket(mesgData, mesgData.length, 
					InetAddress.getByName("10.0.102.150"), 8888);
					 /*傳給自己資料(ip位置)，但我們自己看不到
					  * DatagramPacket(byte[] buf, int length, InetAddress addr, int port)：
					  * 以一個包含資料的陣列來建立DatagramPacket物件，建立該
					  * DatagramPacket物件時還指定了
					  * IP地址和埠(通訊埠（英語：port），又稱為連接埠、埠、協定埠（protocol port）)
					  * 這就決定了該資料報的目的地。
					  * 
					  */
			
			
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
