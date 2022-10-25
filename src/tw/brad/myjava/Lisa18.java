package tw.brad.myjava;

public class Lisa18 {

	public static void main(String[] args) {
		
		for (int t=1; t<=7 ; t++) {   
			System.out.println(t);
			}
		System.out.println("-----");
		
		
		/* for() 給後面的一個狀態。
		 * (;;=>無窮迴圈，一定會做，第一次要做的事)
		 * (; 區隔三段給定)
		 * 要先宣告i，再去判斷是不是i<=7 若是(true)，就執行 
		 * 但i++ 自行累加，到8就不行了 
		 *   
		 *  
		 *  
		 *  
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);*/

		
		int i=1;
		for (printLisa(); i<=7 ;	printLine() ) {
			System.out.println(i++);
		}
			System.out.println("=>" + i); //也可以寫成i++，累加後的i
			
	}
	
	
		static void printLisa() {
			System.out.println("Lisa");
		}
		static void printLine() {
			System.out.println("------------------");
		}
	
}