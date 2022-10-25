package tw.brad.myjava;

public class Lisa36 {

	public static void main(String[] args) {
		/*interface(介面、規格)
		 * 無任何需要的存取修飾字，無寫就是public，任何的方法都是public 功能
		 * 與Object無關
		 * 放在介面一定抽象，無實作implements，要自己新增一個類別
		 * 也在實踐多型
		 * 介面可以多重實作，可以介面1、介面2
		 * Lisa361 obj1= new Lisa361();介面沒有建構式，這條是錯的;
		 * 要後面是new Lisa362()才可以
		 * 介面可以多重繼承 (41)
		 */
		
		Lisa362 obj1=new Lisa362();
		Lisa363 obj2=new Lisa362();
		
		Lisa361 obj3=new Lisa362() {
		
			
		};
	}

}
interface Lisa361{
	void m1();
	void m2();
}
class Lisa362 implements Lisa361,Lisa363{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
interface Lisa363{
	void m3();
	void m4();
}
interface Lisa364 extends Lisa361,Lisa363{
	void m5(); //有m1,m2,m3,m4,m5
}