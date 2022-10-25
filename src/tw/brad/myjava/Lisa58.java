package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Lisa58 {
	public static void main(String[] args) {
		try {
			ObjectInputStream oin=
					new ObjectInputStream(
							new FileInputStream("dir1/brad.score")); 
					
			
			
					Object obj1 =oin.readObject();
					student s1 =(student)obj1;
					System.out.printf("%s:%d:%f\n",s1.getname(),s1.score(),s1.average());
					
					
					Object obj2 =oin.readObject();
					student s2 =(student)obj2;
					System.out.printf("%s:%d:%f\n",s2.getname(),s2.score(),s2.average());
					
					
					System.out.println("=>"+ oin.available()); //仍可使用的obj數量
					
					
					
					oin.close();
						System.out.println("ok");
		
					} catch (Exception e) {
						System.out.println(e);
					}
	}

}
