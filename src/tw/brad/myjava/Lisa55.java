package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Lisa55 {

	public static void main(String[] args) {
		
		
//		try (FileInputStream fin= new FileInputStream("dir1/file1.txt");
//				InputStreamReader isr= new InputStreamReader(fin);
//				BufferedReader br=new BufferedReader(isr) 
//		){
//			String line;int i=1;
//			while((line=br.readLine())!=null){
//				System.out.println(i++ +":"+line);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
						
		
		/* 用BufferedReader，獲得換列 
		 * windows:\r\n
		 * Mac:\n */
			
		
		try (FileReader reader= new FileReader("dir1/file1.txt");
				BufferedReader br=new BufferedReader(reader)
		){
			String line;int i=1;
			while( (line=br.readLine() )!=null ) {
				System.out.println(i++ +":"+line);
						}
		}catch (Exception e) {
			System.out.println(e);
						}
	}

}
