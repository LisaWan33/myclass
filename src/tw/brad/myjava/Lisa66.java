package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Lisa66 {
	public static void main(String[] args) {
		/*傳送圖檔
		 * 
		 * 
		 */
		try {
			
			Socket socket=
					new Socket(InetAddress.getByName("10.0.102.202"),9487);
			OutputStream out =socket.getOutputStream();
			BufferedOutputStream bout=new BufferedOutputStream(out); 
			
			FileInputStream fin = new FileInputStream("dir1/cat.webp");
			BufferedInputStream bin= new BufferedInputStream(fin);
			
			
			
			//檔案讀進來
			int len;byte[]buf=new byte[16*1024];
			while((len=bin.read(buf))!=-1) {
				bout.write(buf,0,len);
			}
			bin.close();
			bout.close();
			bout.flush();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	
	}

}
