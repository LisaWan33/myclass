package tw.brad.myjava;

import java.util.HashSet;
import java.util.TreeSet;

public class Lisa39 {
	public static void main(String[] args) {   //出樂透，從50個數字裡抽6個，使用

		/*HashSet，可以另外設置放入的參數型態
		 * HashSet<Integer>，在	(這裡限制放入的只有"整數")

		 */
		
		TreeSet<Integer>lotters= new TreeSet<>();
		while(lotters.size()<6) {
			lotters.add((int)(Math.random()*49+1));
		} System.out.println(lotters);
		
	}

}
