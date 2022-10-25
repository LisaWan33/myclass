package tw.brad.myjava;

import java.nio.channels.AlreadyBoundException;

import javax.management.BadAttributeValueExpException;

public class Lisa45 {
	public static void main(String[] args) {
		Lisa451 obj= new Lisa451();
		try {
			obj.m3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
class Lisa451 {
	void m1() throws Exception {
	    //有寫拋出，就要try、catch
		System.out.println("Lisa451:m1()");
	}
	void m2() throws Exception{
		m3();
	}
	
	void m3() throws Exception{
		m4(2);
		
	}
	void m4(int a) throws Exception { //throws Exception:宣告
		if(a<10) {
			System.out.println("ok");
		}else {
			throw new Exception();
		}
	}
}


class Lisa452 extends Lisa451{     //可以多種例外，但一定要記得，要比爸爸小
	void m1() throws AlreadyBoundException,BadAttributeValueExpException{  
		System.out.println("Lisa452:m1()");
	}
}
class Lisa453 extends Lisa452{
	void m1() throws RuntimeException{
		System.out.println("Lisa453:m1()");
	}
}
