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
		try {
			FileOutputStream fout = new FileOutputStream(target);
			
			FileInputStream fin = new FileInputStream(source);
			int c;
			while ( (c = fin.read()) != -1) {
				fout.write(c);
			}
			fin.close();
			
			fout.flush();
			fout.close();
			
			System.out.println("Save as ... OK:" + (System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}