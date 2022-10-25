package tw.brad.myjava;

public class Lisa43 { //8
	/*多重捕捉(catch)=>>>捕捉例外
	 * exceptions:例外，可以被處理(java.lang-exceptions)
	 * errors:錯誤，不能被處理
	 * 
	 * checked exceptions
	 */

	public static void main(String[] args) {
	int a=10, b=3;
	int c;
	int[]d= {1,2,3,4};
	
	
	
	
	try {
		c=a/b;
		System.out.println(c);    //中間會發生很多事，碰到一件事，就找例外且排除例外
		System.out.println(d[4]);  //而下面的ArithmeticException、ArrayIndexOutOfBoundsException，是旁系，所以不影互相的影響
		
	}catch(ArithmeticException ae) { //若b=0會有的數學例外
		System.out.println("xx1");
	}catch(ArrayIndexOutOfBoundsException ie){  //若d[4]，超過範圍，數學例外
		System.out.println("xx2");
	}catch(RuntimeException re) {
		System.out.println("xx3");   //除了兩個之外的例外，但若放最上面，就會全部處理，不想細分、統一處裡。
	}                                //是兩個的阿公，所以放最上面，另兩個就會出錯。
		System.out.println("ok");


	}
}