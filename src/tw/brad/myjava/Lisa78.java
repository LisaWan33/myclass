package tw.brad.myjava;

public class Lisa78 {

	public static void main(String[] args) {
		double a=10.3; double b=-10.7;
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(b));
		//(無論小數點幾位，都會直接進位；但負數就會直接取最大的整數走)
		
		double c=10.3;
		double d=-10.7;
		System.out.println(Math.floor(c));
		System.out.println(Math.floor(d));
		//(正數無論小數點幾位，都會直接往最小的整數走；但負數就會直接取最小的整數走)
	}

}
