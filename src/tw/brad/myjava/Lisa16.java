package tw.brad.myjava;

public class Lisa16 {  //3

	public static void main(String[] args) {
		int a =10;
		final int b=3; //完全常數
		
		switch(a) {    
		//byte,short,int,char,String,enum 
		//switch:比對值;  switch括號中，置放所需取出的變數
		
			case 1:
				System.out.println("v");
				break;
			case b:
				System.out.println("A");
				break;
			case 10:
				System.out.println("B");
				// break; 
				//本應該在break後脫離整個結構(他所在的程式區塊)，但是因為沒有break就繼續做，"""""直到碰到break為止""""""。
			case 1000:
				System.out.println("C");
				break;	
			default: //可以放其他地方!
				System.out.println("X");
				break;
				
		} //離開的分支線
			System.out.println("End");
	}

}
