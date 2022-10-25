package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lisa49 {
	public static void main(String[] args) {
		/*每次調用read() 方法，它從輸入流讀取一個字符並把該字符作為整數值返回。
		 * 當流結束的時候返回-1。該方法拋出IOException。
		 * 
		 */
		
		FileInputStream fin = null;		

		try {
			fin = new FileInputStream("dir1/file1.txt");
			
//          int a1;  
//				 while((a1=fin.read())!= -1) {
//				 System.out.print((char)a1);
//			 	}
			 
			int len; byte[] buf = new byte[10];
			
			/* read till the end of the file
			 * 方法解釋中的-1相當於是數據字典告訴調用者文件已到底，
			 * 可以結束讀取了，這裡的-1是Int型
			 * 若不等於-1(!= -1)，代表還未到末尾
			 * 
			 * 我們讀取的字節實際是由8位二進制組成，
			 * 二進製文件不利於直觀查看
			 * 可以轉成常用的十進制進行展示，因此需要把讀取的字節
			 * 從二進制轉成十進制整數，故返回int型
			 */
			
			while ( (len = fin.read(buf)) != -1 ) {
				System.out.print(new String(buf,0,len));
			}
			 
			 fin.close();
				System.out.println("OK");

		}catch(Exception fe) {
				System.out.println("XX");
		}
	      	/*若File類對象的所代表的文件不存在;不是文件是目錄;
	      	 *   或者其他原因不能打開的話，則會拋出FileNotFoundException
	      	 */
				
	              
//	      		}catch(FileNotFoundException fe) {
//	  					System.out.println("XX2");
//	  		    }catch(IOException fe) {
//	  					System.out.println("XX1");
	  	
			 
	}
}
