package tw.brad.myjava;

import tw.brad.myclass.Bike;

public class Lisa35 {
	public static void main(String[] args) {
		/*直接在上面大括號，定義、實作出來
		 * 也是多型一種，當場實作出來
		 */
		Lisa351 obj1= new Lisa351() {
			void m2() {
				
			}
		};
		
		m1(new Lisa351() {
			@Override
			void m2() {
			}
		});
		
		
		/*呼叫下方的Lisa351方法
			 * 額外方法
			 * 在m1裡叫出，ALT+/  =>>>>Anonymous Inner types
			 * 可以多增加過來，直接做個客製化的建構式
			 */
		
		
			Bike b1=new Bike() {
				@Override
				public void upSpeed() {
					super.upSpeed();
				}
				
		} ;	
}
		static void m1(Lisa351 obj) {
			
		
	}
}
	

abstract class Lisa351{
 	void m1(){ }
 	abstract void m2();
}