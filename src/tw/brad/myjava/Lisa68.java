package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Lisa68 {
	public static void main(String[] args) {
	
		while(true) {   //改版，改Lisa67(接收檔案)
		try {
			ServerSocket server=new ServerSocket(9487);
			Socket socket=server.accept();
			
			String filename=socket.getInetAddress().getHostAddress()+".jpg";
			
			
			InputStream in= socket.getInputStream() ;
			BufferedInputStream bin=new BufferedInputStream(in);
			
			int len; byte[]buf=new byte[1024*1024*1024];
			len=bin.read(buf);
			
			
			
			if(len>0) { //length!=-1
			FileOutputStream fout=new FileOutputStream("dir1/" +filename);
			BufferedOutputStream bout=new BufferedOutputStream(fout);
			bout.write(buf,0,len);
			
			bout.close();
			bout.flush();
			}//大於0做這些事，沒有大於0，甚麼事都不做
			
			bin.close();
			server.close();
			System.out.println("recieve Success: "+filename );
		}catch (IOException e) {
			System.out.println(e);
			}
		
		}
	}

}
