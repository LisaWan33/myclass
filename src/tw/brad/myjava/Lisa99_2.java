package tw.brad.myjava;

public class Lisa99_2 {

	public static void main(String[] args) {
		final int ROWS =2; //橫
		final int COLS =4; //列
		final int START=2; //從哪個開始
		
		for(int k=0; k<ROWS; k++) { 
			for(int j=1; j<=9; j++) {         
				for(int i=START; i<START+COLS; i++) {     
				int newi=i+ k * COLS ;                   
				int r=newi*j;                   
					System.out.printf("%d x %d= %d\t",newi,j,r);
				}
				System.out.println(); 
			}	
		System.out.println("---------");	
		}
	}

}
