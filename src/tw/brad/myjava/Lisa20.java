package tw.brad.myjava;

public class Lisa20 { //擲100次骰子，印出各點出現幾次<用switch>

	public static void main(String[] args) {
		int p0,p1,p2,p3,p4,p5,p6;
		p0=p1=p2=p3=p4=p5=p6=0; //初始化方式
		
		for(int i=0;i<100;i++) { //for{}，括弧裡面做一串事情:point的值，隨機一直重複100次
			int point=(int)((Math.random()*6)+1);	//0~5.99取整數5 => 出現1~6(case1~6)
			
		switch (point) { //使用switch
		case 1:p1++; break;
		case 2:p2++; break;
		case 3:p3++; break;
		case 4:p4++; break;
		case 5:p5++; break;
		case 6:p6++; break;
		default: p0++;
		}
			}
				System.out.printf("%d出現%d次\n",1,p1);
				System.out.printf("%d出現%d次\n",2,p2);
				System.out.printf("%d出現%d次\n",3,p3);
				System.out.printf("%d出現%d次\n",4,p4);
				System.out.printf("%d出現%d次\n",5,p5);
				System.out.printf("%d出現%d次\n",6,p6);
				System.out.printf("錯誤點出現%d次\n",p0);
	}

}
