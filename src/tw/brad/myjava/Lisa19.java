package tw.brad.myjava;

public class Lisa19 {

	public static void main(String[] args) {
		//陣列Array
		int b; b=3;
		int[] a;
		a= new int[3]; 
		//a完成初始化(創建在記憶體中的三個int空間)，已可以用，預設值0
		
		System.out.println(a[0]);  //0:偏移量
		System.out.println(a[1]);
		System.out.println(a[2]);
		//System.out.println(a[3]); 超過
		
		
		
		System.out.println("-------");
		
		a[1]=123;a[2]=777; //改換值
		for(int i=0; i<a.length; i++ ) { //i:只是隨便給定一個變數
			System.out.println(a[i]);
		}
	}
}
