package tw.brad.myjava;

import java.util.Scanner;

public class Lisa24 {

	public static void main(String[] args) {
		//1+2+3+4+...+n=?
		int i=1;
		int sum=0;
		Scanner scanner=new Scanner(System.in);
		System.out.print("n= ");
		int n=scanner.nextInt();
				
		while(i<=n) {
			sum+=i;         //1,2
			i++;}   
		
//		for(;i<=n;) {
//			sum+=i++; //1,2
//		}
		System.out.println("------");
		int s=sum+=i++;
		System.out.println(s);
		
		
		System.out.printf("1+2+...+%d= %d ",n,sum);
	}

}
