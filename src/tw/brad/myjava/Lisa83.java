package tw.brad.myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class Lisa83 {//(第三招:把一個檔案轉成base64的一個字串，再透過base64在轉換回來成一個檔案<常用>)

	public static void main(String[] args) {
		
		try {
			File file =new File("dir1/cat2.png");
			FileInputStream fin=new FileInputStream(file);
			byte[]buf=new byte[(int)file.length()];
			fin.read(buf);
			fin.close();
			
			byte[] base64=Base64.getEncoder().encode(buf);
			System.out.println("soruce byte len = " + buf.length);
			System.out.println("BASE64 byte len = " + base64.length);
			
			String base64String = new String(base64, "UTF-8");
			System.out.println("str = " + base64String.length());
			System.out.println(base64String);	// data:image/png;base64,iV......
			System.out.println("---------------------------------------------------");
			
			byte[] debase64 = Base64.getDecoder().decode(base64String);
			System.out.println("soruce byte len = " + debase64.length);
			FileOutputStream fout = new FileOutputStream("dir2/test.png");
			fout.write(debase64);
			fout.flush();
			fout.close();
			
			System.out.println("OK");
			
			
		} catch (Exception e) {

		}
	}

}
