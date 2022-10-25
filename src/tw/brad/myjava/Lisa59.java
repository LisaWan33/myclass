package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.brad.myclass.Bike;

public class Lisa59 {
	/* 輸出、輸入比較(序列化)
	 * 但implements Serializable，宣告在哪一代，會有關系
	 * 在父類別上，若已經實作可序列化，則孫子就一定已經序列化
	 * 但若是，孫子做了序列化，阿公、爸爸就不會有
	 */
	public static void main(String[] args) {
		Lisa583 obj = new Lisa583();
		try {
			ObjectOutputStream oout=
					new ObjectOutputStream(new FileOutputStream("dir1/b.obj"));
			oout.close();
			oout.flush();
			System.out.println("ok1");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("-------------------");

		
		try {
			ObjectInputStream ion=
					new ObjectInputStream(new FileInputStream("dir1/b.obj"));
			ion.close();
			System.out.println("ok2");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
class Lisa581{
	Lisa581(){
		System.out.println("Lisa581()");
	}
}
class Lisa582 extends Lisa581{
	Lisa582(){
		System.out.println("Lisa582()");
	}
}
class Lisa583 extends Lisa582 implements Serializable{
	//implements Serializable，可放上面任何位置，不出錯;但是，說實話，會有解序列化(ObjectInputStream)的影響
	
	private Bike bike; 
	Lisa583(){
	System.out.println("Lisa583()"); bike=new Bike();
	}
}
