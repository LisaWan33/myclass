package tw.brad.myjava;

public class Lisa30 { //講解String

	public static void main(String[] args) {
		String s1="Lisa"; //看到雙引號，已經建構了記憶體，指派給s1
		System.out.println("Lisa".charAt(2)); //傳回第二位字
		System.out.println("---------------");
		
		
		String s2=new String();//ASCII
		byte[] b1= {97,98,99,100,101,102};
		
		String s3=new String(b1);
		System.out.println(s3);
		System.out.println("---------------");
		
		
		
		String s4 = new String(b1, 2, 4); 
		// 從2開始，持續4個字
		System.out.println(s4);
		
		String s5=s4.concat("ghijk");
		System.out.println(s4); //s4往後加
		System.out.println(s5);
		
	}

}
