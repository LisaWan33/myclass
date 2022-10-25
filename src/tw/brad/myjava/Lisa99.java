package tw.brad.myjava;

public class Lisa99 {

	public static void main(String[] args) {
		for(int k=0;k<2;k++) {                //3 k=0,1
			for(int j=1; j<=9; j++) {         //j到9停       2
				for(int i=2; i<6; i++) {      //i到5停(先做i)      1
				int newi=i+k*4;                   //多了下一排的6*1
				int r=newi*j;                    //int r=i*1(原本先考慮i的結果)=>加上列j
					System.out.printf("%d x %d= %d\t",newi,j,r);
				}
				System.out.println(); //換列
			}	//這只能括在下面
		System.out.println("---------");	
		}
		
	/*  System.out.print("2x1=2\t"); //用print，不換行(printIn)
		System.out.print("3x1=3\t");
		System.out.print("4x1=4\t");
		System.out.print("5x1=5\t");   */
	}
}