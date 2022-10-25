package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;

public class Lisa56 {

	public static void main(String[] args) {
		try(FileReader reader=new FileReader("dir1/sieve.csv") ; //網路載快篩地圖的csv資料
			BufferedReader br =new BufferedReader(reader) //可自動換列方法
		   ){
			
			String line; int i=1; 
			
			//想要第一列資料(第二排:醫事機構名稱)、第七列資料(第八排:快篩試劑截至目前結餘存貨數量)
			br.readLine();
			while( (line=br.readLine() )!=null ){
				String[]data=line.split(",");
				System.out.printf( "%s:%s\n",data[1],data[7]);
							}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
