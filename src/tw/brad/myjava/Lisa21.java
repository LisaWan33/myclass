package tw.brad.myjava;

public class Lisa21 { //擲100000次骰子，印出各點出現幾次<用陣列>    //難

	public static void main(String[] args) {
		int[] p=new int[7]; //在p的記憶體位置，建立7個空間，可以放0~6
		
		for(int t=0;t<100000;t++) { //實驗100000次，丟點數有1~6的骰子
			int point=(int)((Math.random()*6)+1);	//0~5.99=>>>取整數5  +1 => 1~6
			p[point]++; //會出現p1,p2,p3,p4,p5,p6的各累積值
		}
		for(int i=1;i<=6;i++) { //使用Array
			System.out.printf("%d 出現 %d次\n" ,i ,p[i]);
		}
	}
}
