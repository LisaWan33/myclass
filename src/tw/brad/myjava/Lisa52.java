package tw.brad.myjava;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Source;

public class Lisa52 {

	public static void main(String[] args) {
		//1:複製貼上改名字
		String source = "dir1/file1.txt";
		String target = "dir2/file3.txt";
		long start = System.currentTimeMillis();
		
		
		
		/*檔案輸出: FileOutputStream
		 *檔案輸入: FileInputStream
		 * 
		 * 檔案的複製到另一空檔案
		 */
		try {
			FileOutputStream fout = new FileOutputStream(target);
			
			FileInputStream fin = new FileInputStream(source);//有資料
			int c;
			while ( (c = fin.read()) != -1) {
				fout.write(c);//寫入
			}
			fin.close();
			
			fout.flush();//沖、更新一下
			fout.close();
			
			System.out.println("Save as ... OK:" + (System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}