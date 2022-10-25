package tw.brad.myjava;

import java.io.File;

public class Lisa47 {
 /* 電腦先建test
  * 也可以寫成D:\\test，可找到在電腦裡的檔案
  * 但裡面寫 D:/test/okok.txt找不到
  * 所以要先建f1.mkdir();
  * 就會出現在電腦檔案中
  */
	public static void main(String[] args) {
		File f1= new File("D:/test/dir1");
		if(f1.exists()) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
			f1.mkdir();  //第一次，會先呈現"xx"，因為還未建立，但經過這條之後，就會建立成功，在run結果就會是"ok"
		}
		System.out.println("-------");
		
		
		//路徑(./可以省略) 是否存在?
		File dir1=new File("dir1");
		if(dir1.exists()) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}
		
		
		/* 找尋本路徑方式=>>>用here
		 * 
		 * 
		 * File here=new File(".");
		 * System.out.println(here.getAbsolutePath());
		 */
		
		
		
	}

}
