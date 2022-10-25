package tw.brad.myjava;

import java.io.FileOutputStream;

public class Lisa51 {

	public static void main(String[] args) {
		String data="hi";
		try {
		FileOutputStream fout= 
				new FileOutputStream("dir1/file2.txt",true);
			
		
		/*寫入file2，且從字串轉byte
		 * 但一改寫，就會改掉
		 * 加上true就會增加到後面
		 */
			fout.write(data.getBytes());
			
			fout.flush();
			fout.close();
			System.out.println("ok");
			}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}
