package tw.brad.myjava;

public class Lisa22 {

	public static void main(String[] args) {
		int[][]a=new int[3][];
		a[0]=new int[2];
		a[1]=new int[3];
		a[2]=new int[4];
		
		a[0][1]=123;  //[0][0]=>0
		a[1][2]=333;  //[1][0]、[1][1]=>0
		a[2][1]=121;  //[2][0]、[2][2]、[2][3]=>0
		
		for (int i=0; i<a[2].length;i++) {
		System.out.print(a[2][i]+"  ");
		}
		
		System.out.println("\n");
		System.out.println("-----------");
		
		
		
		// for-each:透過訪問的方式
		for(int v:a[2]) {
			System.out.println(v);
		}
		System.out.println("-----------");
		
		
		//全部叫出
		for(int[]v:a) { 
			for(int vv:v) {
				System.out.print(vv+"   ");
			}
			System.out.println();
		}
		
		
	}
}
