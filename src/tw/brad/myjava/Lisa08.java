package tw.brad.myjava;

public class Lisa08 {

	public static void main(String[] args) {
		double a=10,b=3;
		double c=a/b;
		System.out.println(c);
		
		int n=3,m=2;
	    double o=n/m;
	    int u=n/m;
		System.out.println(o);
		System.out.println(u);
		
		double d=10,e=0;
		double g=d/e;
		System.out.println(g); //infinity 無限大
		
		double l=0,t=10;
		double j=l/t;
		System.out.println(j);
		
		double h=0,i=0;
		double k=h/i;
		System.out.println(k); //NaN 無意義
	}
}
