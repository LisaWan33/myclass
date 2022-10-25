package tw.brad.myjava;

public class Lisa41 {

	public static void main(String[] args) {
		int a=10,b=3;
		Integer c=a+b;
		/*上述，autoboxing(自動封箱)
		 * a 仍是int
		 * c 為integer的物件實體
		 * c可以c.intValue();、但a不行，因為不是物件是整數
		 * 當c要做算術時，會自動unboxing，再去算(19)(自動開箱)
		 * 宣告為何，變數就是為何
		 */
		c.intValue(); //從integer改成int
		System.out.println(c.intValue());
		
		
		int d=c-b;
		System.out.println(d);
		
	}

}
