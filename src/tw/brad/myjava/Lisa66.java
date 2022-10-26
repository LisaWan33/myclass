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
		 * new Socket(InetAddress.getByName("10.0.102.202"),9487) 給對方資料需要用到的ip位置
		 * BufferedOutputStream維護一個8192字節的內部緩衝區。
		 * 使用BufferedOutputStream寫入字節更快
		 * 
		 * write()方法
		 * 1.write() - 將單個字節寫入輸出流的內部緩衝區
		 * 2.write(byte[] array) - 將指定數組中的字節寫入輸出流
		 * 3.write(byte[] arr, int start, int length)- 從位置start開始將等於length的字節數寫入數組的輸出流
		 * 
		 * flush()方法
		 * 要清除內部緩衝區，我們可以使用flush()方法。
		 * 強制輸出流將緩衝區中存在的所有數據寫入目標文件。
		 * 
		 * close()方法
		 * 要關閉緩衝的輸出流，我們可以使用close()方法。
		 * 調用該方法後，我們將無法使用輸出流寫入數據。
		 */

		
		try { //66(傳送端)、67(接收端)
			
			Socket socket=
					new Socket(InetAddress.getByName("10.0.102.202"),9487);
			OutputStream out =socket.getOutputStream();
			BufferedOutputStream bout=new BufferedOutputStream(out); 
			
			FileInputStream fin = new FileInputStream("dir1/cat.webp");
			BufferedInputStream bin= new BufferedInputStream(fin);
			
			
			
			//檔案讀進來(接收時，需要這些code)
			int len; byte[]buf=new byte[16*1024];
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
