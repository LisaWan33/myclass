package tw.brad.myjava;

import java.util.Scanner;

public class Lisa17 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Month= ");
		int month=scanner.nextInt();//請隨機給定一值
		int days;
		
		switch(month) { 
		//switch為 JAVA中提供的另一個判斷條件陳述式，只可比較數值、字元
		
		
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			//1,3,5,7,8,10,12:
			days =31;
			break;
		
		case 2:
			days=28;
			break;
		
		case 4,6,9,11:
			days=30;
			break;
			
		default:
			days=0; //(因為days沒有初始化，需加)
		}
		
		System.out.printf("%d月有%d天",month,days);
	}
}
