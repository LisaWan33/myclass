package tw.brad.myjava;

import java.util.Arrays;

public class PokerV2 {

	public static void main(String[] args) {
		//1.  52張洗牌
		int[] poker=new int[52];  //index:0-51=>0
		long start=System.currentTimeMillis();
		
		boolean isDup; int rand;
		for(int i=0; i<poker.length; i++) {    //注意用{
			do {
				rand=(int)(Math.random()*52);  //0~51
	
				// 檢查機制
				    isDup = false;
				    for(int j=0; j<i;j++) {
					if(poker[j]==rand) {
						// 重複了
						isDup =true;
						break;
						}
				 	}
			}while(isDup);
			
			poker[i]=rand;
			System.out.println(poker[i]);
		
		}
	System.out.println("-----");
	System.out.println(System.currentTimeMillis()-start); //千分之秒
	System.out.println("-----");
	
	
	//2.  發牌，給四個人，每人拿13張
	int[][] players=new int[4][13];
	for(int i=0;i<poker.length;i++) {
		players[i% 4][i/4]=poker[i]; //players[?][?] 第一個括號
	}
	//A,2,3,4,...,J,Q,K,  A,2,3,...,J,Q,K, 
	//0,1,2,3,...,12,13,  14,15,...,25,26, 27,....
	//黑桃            紅心             方塊             梅花
	String[] symbols=new String[] {"黑桃","紅心","方塊","梅花"};
	String[] values= {"A","1","2","3","4","5","6","7",
		"8","9","10","J","Q","K"}; //只能宣告的時候給值
			
	for(int p:players[0]) {
		System.out.println(p);
		
	}
	System.out.println("-----");
	//3.  攤牌	
	for(int[]cards:players) {
		Arrays.sort(cards); //排列整理
		for(int card:cards) {
			System.out.print(symbols[card/13]+values[card % 13]+" ");
		}
		System.out.println();
	}
	}
}
	