package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lisa48 {

	public static void main(String[] args) {
		/* Java.io 包幾乎包含了所有操作輸入、輸出需要的類。所有這些流類代表了輸入源和輸出目標。
		 * Java.io 包中的流支持很多種格式，比如：基本類型、對象、本地化字符集等等。
		 * 一個流可以理解為一個數據的序列。輸入流表示從一個源讀取數據，輸出流表示向一個目標寫數據。
		 * Java 為I/O 提供了強大的而靈活的支持，使其更廣泛地應用到文件傳輸和網絡編程中。
		 */
		
		FileInputStream fin=null;
		try{
			 fin =new FileInputStream("dir1/file1.txt");
			 
			 
			 /* FileInputStream是用來讀入(read)文件，而FileOutputStream是用來寫入(write)文件。
			  * FileInputStream與FileOutputStream的特點是，
			    它們是以8-bit 的 bytes 來進行輸入輸出，也就是它無法處理 unicode(16-bit) 的文字。
			  * 測試這個例子前，先要在程式目錄建立一個"input.txt"的文件
			  * 裡面可隨意輸入一些文字。程式會新建一個"output.txt"
			  * 並將"input.txt"裡面的內容全部複製過去。
			  * 
			  */
			 int c1=fin.read();
			 System.out.println(c1);
			 //印出來，是byte，ASCll碼，是資料
			 System.out.println((char)c1);
			 System.out.println("-------");
			 
			 
			 int c2=fin.read();
			 System.out.println((char)c2);
			 // convert integer from character
			 
			 
			 
			 // close file input stream，因這裡設計try_catch不會是自動關閉，所以必須手動加
			 fin.close();
			 System.out.println("ok");
		}
	    catch(Exception e) {   //這裡的try_catch中後段改成exception來更改，可以直接排除所有例外情況，不用再細分
              System.out.println("xx");
		
		
//		catch(FileNotFoundException fe) {
//			System.out.println("xx1");
//		}
//		catch(IOException ie) {
//			System.out.println("xx2");	
//		}
//			
			
			
//			if(fin==null && fin instanceof FileInputStream ) {
//				System.out.println("is null");
//			}else {
//				System.out.println("not null");
//			}
//			=>>>xx
//			    not null
		
			
		}
	}

}
