package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lisa53 { //9
	public static void main(String[] args) {
		String source = "dir1/file1.txt"; //照片也可以複製寫入另一空檔案
		String target = "dir2/file3.txt";
		long start = System.currentTimeMillis();
		
		
		
		try {
			FileOutputStream fout = new FileOutputStream(target);
			
			FileInputStream fin = new FileInputStream(source);
			int len;  byte[]buf=new byte[16*1024]; 
			
			/*16k
			 * 電腦的最小單位為Bit (位元)
			 *  1 Byte = 8 Bits;(8位元)
			 *  1 Kilobyte (KB) = 1024 Bytes
			 *  16bits(16位元)
			 *  大概2KB=2*1024
			 */
			while ( (len = fin.read()) != -1) {
				fout.write(buf,0,len);
			}
			fin.close();
			
			fout.flush();
			fout.close();
			
			
			
			
			System.out.println("Save as ... OK:" 
							+ (System.currentTimeMillis()- start ) );
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
