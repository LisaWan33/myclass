package tw.brad.myjava;

public class Lisa21_2 {
	public static void main(String[] args) {
		int[] p=new int[7]; 
		
		for(int i=0;i<100000;i++) {
			int point=(int)(Math.random()*9)+1;	//1~9:可能骰9次，每次機率1/9，但累加到其他的6點機率中
			p[point<=6? point:point-3]++; 
			/*三元運算式 :分號代表"或是"，若是point<=6，true，不改變   ;若>6，False。
			 * 所以，若point=7，則累加到7-3=4的點數裡面
			 * 若point=8，則累加到8-3=5的點數裡面
			 * 若point=9，則累加到9-3=6的點數裡面
			 */
			
		}
		for(int i=1;i<=6;i++) {
			System.out.printf("%d出現%d次\n",i,p[i]);
		}
		
		int total=0;
		for(int i=1;i<=6;i++) {
		total+=p[i];
		}System.out.println("總共試驗次數:"+total);
}
}