package tw.brad.myjava;

import tw.brad.myclass.Bike;

class Lisa321{
	//因為是物件，所以必須要令一個類別，才能叫出obj
}


public class Lisa32 {

	public static void main(String[] args) {
		Lisa321 obj1=new Lisa321();
		Lisa321 obj2=new Lisa321();
		Lisa321 obj3=obj1;
		if(obj1.equals(obj2)) {        //不一樣，因為new。但obj1=obj3。
			System.out.println("ok");
		}else {
			System.out.println("x");
		}                      
		
		/*物件(Obj)比較
		 * 在物件中，已經toString改變為字串，印出記憶體位置
		 * 印物件:只會印出記憶體位置，並不會印出物件
		 */
		System.out.println(obj1);         // tw.brad.myjava.Lisa321@372f7a8d(at 記憶體位置)
		System.out.println(obj2);         // tw.brad.myjava.Lisa321@2f92e0f4
		System.out.println(obj3);         // tw.brad.myjava.Lisa321@372f7a8d 
		System.out.println(obj1==obj2);   //比較物件的記憶體位置
		System.out.println(obj1==obj3);
		System.out.println("------------------------");
		
		
		
		/*字串比較(用==時)，也是比較記憶體位置，而非內容
		 * 但，若比較(用equals)，是比較字串裡面的內容
		 */
		
		String s1="Lisa";                 
		String s2="Lisa";
		String s3=new String("Lisa");
		String s4=new String("Lisa");
		System.out.println(s3);
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println("-------------------------");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
		System.out.println(s2.equals(s4));
		System.out.println(s3.equals(s4));
		System.out.println(s1.equals(s4));
		System.out.println("-------------------------");
		
		
		
		
		
		/*當對字符串進行修改的時候，需要使用StringBuffer 和StringBuilder 類。
		 * 和String 類不同的是，StringBuffer 和StringBuilder 類的對象，
		   能夠被多次的修改，並且不產生新的未使用對象。
		 * 在API中，可以知道StringBuffer中不改變，字串在比較時，也是比較記憶體
		 * 參考StringBuffer
		 */
		StringBuffer sb1=new StringBuffer("Lisa");
		StringBuffer sb2=new StringBuffer("Lisa");
		System.out.println(sb1);
		System.out.println(sb1==sb2);              //false
		System.out.println(sb1.equals(sb2));       //false
		System.out.println("-------------------------");
		
		
		
		
		/*toString() 方法用於返回以一個字符串表示的Number 對象值。
		 * 如果方法使用了原生的數據類型作為參數，返回原生數據類型的String 對象值。
		 * 如果方法有兩個參數， 返回用第二個參數指定基數表示的第一個參數的字符串表示形式。
		 */
		Bike b1=new Bike();         //可從Bike calss 叫出來
		Bike b2=new Bike();
		System.out.println(b1);
		
		/*public String toString() {
		 * return "bike: "+speed;
		 * 從Bike的package中的定義，會在 toString下，印出"bike: "+speed
		 */
		System.out.println(b1.toString());
		
	}

}
