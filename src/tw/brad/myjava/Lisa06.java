package tw.brad.myjava;

import java.util.Scanner;

public class Lisa06 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("x= ");
		int v1=scanner.nextInt();
		System.out.print("y= ");
		int v2=scanner.nextInt();
		
		int result1 =v1 + v2;
		int result2 =v1 - v2;
		int result3 =v1 * v2;
		int result4 =v1 / v2;
		int result5 =v1 % v2;
		
		System.out.printf("%d + %d= %d\n",v1,v2,result1);
		System.out.printf("%d - %d= %d\n",v1,v2,result2); 
		System.out.printf("%d * %d= %d\n",v1,v2,result3); 
		System.out.printf("%d / %d= %d\n",v1,v2,result4); //除法時，為整數除 int=>int
		System.out.printf("%d %% %d= %d\n",v1,v2,result5); //除餘數時，用兩個%%表示
		
		System.out.println("----");
		
		System.out.println(result1);
		System.out.println(result2);
	}
}
