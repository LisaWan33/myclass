package tw.brad.myjava;

import java.util.LinkedList;

public class Lisa40 {

	public static void main(String[] args) {
		/* 鍊錶（Linked list）是一種常見的基礎數據結構，是一種線性表，
		   但不會按線性的順序存儲數據，而是在每一個節點中存儲到下一個節點的地址。
		 * Java LinkedList（鍊錶）類似於ArrayList，是一種常用的數據容器。
		 * 與 ArrayList 相比，LinkedList 的增加和刪除的效率更高，而查找和修改的操作效率更低。
		 */
		
		
		LinkedList<String> list=new LinkedList<>();
		list.add(0,"A");
		list.add(0,"B");
		list.add(0,"C");
		list.add(0,"D");
		list.add(0,"E");
		 for(String v:list) {
			 System.out.println(v); //都從0開始遞換
		 }
		System.out.println("----");
		
		
		list.add(1,"F");
		for(String v:list) {
			System.out.println(v);
		}
		
	}

}
