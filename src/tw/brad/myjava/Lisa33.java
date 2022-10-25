package tw.brad.myjava;

public class Lisa33 { //難

	public static void main(String[] args) {
			Brad331 obj1 = new Brad331();
			Brad331 obj2 = new Brad332();
			Brad331 obj3 = new Brad333();
			obj1.m1();
			obj2.m1();
			obj3.m1();
			
			
			Brad333 obj4 = (Brad333)obj3; //強制置換
			obj4.m2();
			//Brad333 obj5 = (Brad333)obj1;
			//Brad333 obj6 = (Brad333)obj2; 
			  Brad332 obj7 = new Brad332();
			//Brad333 obj8 = (Brad333)obj7;
			  Brad333 obj9 = new Brad333();
			System.out.println("-----");
			
			go(obj1);
			go(obj7);
			go(obj9);
			
		}
		/* instanceof(是否等於)
		 * instanceof 是Java 的一個二元操作符，類似於==，>，< 等操作符。
		 * 是Java 的保留關鍵字。
		 * 作用是測試它"左邊的對象是否是它右邊的類的實例"，返回boolean 的數據類型。
		 */
	
		static void go(Brad331 car) {
		car.m1();
		if (car instanceof Brad333) {
			((Brad333) car).m2();
			}
		}
	}

/* 依樣要先在外面做定義，因為是物件
 * void:保持一個對代表 Java 關鍵字 void 的 Class 對象的引用。
 * 如開頭:public static void main(String[] args) {
 * m1(){}:方法
 */

	class Brad331 {
		void m1() {              
		System.out.println("Brad331:m1()");
		}
	}
	class Brad332 extends Brad331 {
		void m1() {
			System.out.println("Brad332:m1()");
		}
	}
	class Brad333 extends Brad331 { //333有兩種方法
		void m1() {
			System.out.println("Brad333:m1()");
		}
		void m2() {
			System.out.println("Brad333:m2()");
		}
}

