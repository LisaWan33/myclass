package tw.brad.myjava;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import tw.brad.myclass.Bike;

public class Lisa42 {

	public static void main(String[] args) {
		/*Map:K-V (key對應Value)無順序、無重複
		 * HashMap 是一個散列表，它存儲的内容是鍵值對(key-value)映射。
		 * HashMap 的 key 與 value 類型可以相同也可以不同
		 * 可以是字串（String）類型的 key 和 value，
		   也可是整數（Integer）的 key 和字串（String）類型的 value。
		   
		   
		 * HashMap 位於 java.util 包中，使用前需引入它
		 * 需要建構式，如:HashMap<Integer, String> Sites = new HashMap<Integer, String>();
		 * 可以添加元素，用put()方法
		 * 
		 */
		HashMap<String, Object> person=new HashMap<>();
		person.put("name","Lisa");
		person.put("height", "160");
		person.put("weight", "45");
		person.put("gender", true);
		System.out.println("gender:" +person.get("gender")); //可以使用 get(key)方法獲取key對應的value。
		System.out.println("------------");
		
		/*可以使用 for-each 来迭代 HashMap 中的元素。
		 * 若只想獲取 key，可以使用 keySet() 方法，然後可以通過 get(key)獲取對應的 value
		 * 若只想獲取 value，可以使用 values() 方法。
		 * 
		 */
		Set<String> keys = person.keySet();
		for(String key :keys) {
			System.out.println(key+":"+person.get(key));
		}
		System.out.println("------------");
		
		
		//可以另外再多做樂透
		TreeSet<Integer> lotters=new TreeSet<>();
		while(lotters.size()<6) {
		lotters.add((int)(Math.random()*49+1));
		person.put("lottery", lotters);  //添加键值對(key-value)可以使用 put() 方法:person.put()
		}
		TreeSet<Integer> temp=(TreeSet<Integer>)person.get("lottery");
		
		
		for(Integer v : temp) {
		System.out.println(v);
		}
		System.out.println("-----------------");
		
		
		
		
		//也可以再匯入腳踏車
		Bike bike=new Bike();
		person.put("bike", bike);
		Bike myBike=(Bike)person.get("bike");
		myBike.upSpeed();myBike.upSpeed();
		System.out.println(myBike.getSpeed());
		
	
	}
}
