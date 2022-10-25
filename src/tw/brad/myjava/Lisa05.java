package tw.brad.myjava;

import java.util.Scanner;

public class Lisa05 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); //scanner 必打 1
		
		System.out.print("x=");
		int v1=scanner.nextInt(); //scanner 必打 2
		System.out.println("y=");
		int v2=scanner.nextInt();
		
		
		int result=v1+v2;
		System.out.printf("%d + %d= %d\n",v1,v2,result); 

		//在底下結果區輸入數字 //注意這裡為了要印出文字，需要用printf
		
		//%d:十進位制整數:按整型資料的實際長度輸出、%c單個字元、%s字串
		System.out.printf("%d + %d=lisa's age",v1,result);
	}
}
