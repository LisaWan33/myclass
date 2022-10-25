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
			while ( (len = fin.read(buf)) != -1 ) {
				System.out.print(new String(buf,0,len));
			}
			 
			 
			 fin.close();
				System.out.println("OK");
			}catch(Exception fe) {
				System.out.println("XX");
	      	
	              
//	      		}catch(FileNotFoundException fe) {
//	  					System.out.println("XX2");
//	  		    }catch(IOException fe) {
//	  					System.out.println("XX1");
	  		}
			 
	}
}
