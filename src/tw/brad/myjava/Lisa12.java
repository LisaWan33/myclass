package tw.brad.myjava;

public class Lisa12 {

	public static void main(String[] args) {
     /*Score=> 0~100(int) 
      * Math.random() 產生一個[0，1)之間的隨機數，若要1~3 n=1,m=3
      * 公式：(Math.random()*(n-m)+m)
      * double score=Math.random();  [0.0 <= score <1.0] 隨機數值 
      * double score2= score* 101;  [0.0 <= scroe2 <101.0]
      * int score3= (int)score2;  [0.0 <= scroe3 <=100] 
      * int沒有四捨五入的方法，所以在double score2的時候100.99、98..都是算在100 
      * 要記住，解釋為何是要乘101，因為0~100是101個數字
      *	若是要求1.0~100.0，則就是要乘以100才對
      */

	
    int score= (int)(Math.random()*101); //求乘以101的整數值
	System.out.println(score);
	
	 //pass //down
	if (score>=60) {
		System.out.println("pass");
	}else {
		   System.out.println("down");
	}
	}
}

    