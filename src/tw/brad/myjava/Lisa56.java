package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;

public class Lisa56 {

	public static void main(String[] args) {
		try(FileReader reader=new FileReader("dir1/sieve.csv") ;
			BufferedReader br =new BufferedReader(reader)
		) {
			
			
			String line;int i=1;
			br.readLine();
			while((line=br.readLine())!=null){
				String[]data=line.split(",");
				
				System.out.printf( "%s:%s\n",data[1],data[7]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
