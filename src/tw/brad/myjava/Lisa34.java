package tw.brad.myjava;

public class Lisa34 { //6
	public static void main(String[] args) {
		/*Lisa342 obj1=new Lisa341();
		 * 抽象類別無法實作抽象實體
		 */
		Lisa341 obj1=new Lisa342();
		Lisa341 obj2=new Lisa342();
		obj1.m1();  //Lisa34:m1()
		obj2.m2(null);
		obj2.m2(5);
		
		obj2.m3("apple"); //ple
		System.out.println("----");
		obj2.m3(null);
		
		obj2.m4(obj2);
		//obj1只有m1()方法;但obj2有m1、m2、m3、M4方法
	}

}

	/*多型，接受甚麼資訊，傳遞甚麼東西
	 * 有一inta=>就要有一個int b
	 * 有一String a=>就要有一個String b
	 * 有一Object a=>就要有一個Object b
	 * override現象，參數的部分;方法名稱參數一樣
	 * overload; 方法名稱一樣，但是參數不一樣
	 */


abstract class Lisa341{
	void m1() { System.out.println("Lisa34:m1()");}
	//抽象方法
	abstract void m2(int a);
	abstract protected Object m2(Object a);
	
	
	
	/* 可以傳回值int、String、Object都可以，但下面也要一樣
	 * 不過，要知道某個例外是
	   String是將Object發揚光大的兒子，所以在60要是String; 在37放Object。(繼承)
	 * 不然全部都要上下一樣。
	 * 再來，提到protected，可以在內部直接傳承，
	   所以反映到子類別是可以對外、對內公開的public。
	 * 但是反過來就不行了
	 * 抽象方法也有建構式
	 */
	abstract void m3(String a);
	abstract void m4(Object a);
	}

class Lisa342 extends Lisa341{
	/*有大括號，代表有實作
	 * 八個型別(基本型別)的傳回值，要一樣。
	 * null:空
	 */
	void m2(int b) {}
	public String  m2(Object a) {return null;}
	void m3(String b) {System.out.println("ple");}
	void m4(Object b) {}
}