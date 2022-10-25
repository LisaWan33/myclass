package tw.brad.myjava;

import java.util.HashSet;

public class Lisa38 {

	public static void main(String[] args) {
		/*迭代器 iterator 可迭代 interable
		 * 在java在可迭代資料裡面可以使用for-each
		 * set:  1.元素不會重複  2.沒有順序性
		 * list: 1.元素可以重複  2.元素有順序性
		 * 若是需要元素不重複+元素有順序性:
		   用set排除重複性，然後再用List排順序。
		 * HashSet 對象sites，用於保存字符串元素
		 * 參考詳細說明HashSet
		 */
		HashSet set=new HashSet();
		set.add("Lisa");
		set.add(new String("Lisa"));
		set.add("Lisa");
		set.add(123);
		set.add(123.2);
		set.add("iSpan");
		
		/* int=>autoboxing(自動封箱)=>>integer
		 * double=>autoboxing=>>interger
		 * String=>autoboxing=>>interger 
		 * set中，用size判斷出有四個元素
		 */
		
		System.out.println(set.size());
		System.out.println(set);
		System.out.println("-----");
		
		//肚子裡面放物件，set為尋訪對象
		//for-each用法
		//列出一個個物件
		for(Object obj :set){
			System.out.println(obj);
			}
		}

}
