package tw.brad.myjava;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Lisa54 {

	public static void main(String[] args) {
		try (FileReader reader =new FileReader("dir1/file1.txt")) { 
			/* 自動關閉語法!!，不須加reader.close();
			 * ，且將建構式，放入try_catch裡:try(){}
			 * 不過裡面就無法放入其他的邏輯
			 * 未來想要讀字眼的東西，其實不太多
			 */
		
		int c;
		while(	(c=reader.read())!=-1) {
			System.out.print((char)c); //INT=>CHAR
		}
			
		} catch (Exception e) {
		}
	}

}
