package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Lisa67 {
	public static void main(String[] args) {
	
		
		try {//66(傳送端)、67(接收端)
			ServerSocket server=new ServerSocket(9487);
			Socket socket=server.accept();
			
			String filename=socket.getInetAddress().getLocalHost()+".jpg";
			
			
			InputStream in= socket.getInputStream() ;
			BufferedInputStream bin=new BufferedInputStream(in);
			
			FileOutputStream fout=new FileOutputStream("dir1/"+filename);
			BufferedOutputStream bout=new BufferedOutputStream(fout);
			
			
			
			
			
			int len; byte[]buf=new byte[16*1024];
			while((len=bin.read(buf))!=-1) {
				bout.write(buf,0,len);
			}
			
			
			bout.close();
			bout.flush();
			
			bin.close();
			server.close();
			System.out.println("recieve Success: "+filename );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
