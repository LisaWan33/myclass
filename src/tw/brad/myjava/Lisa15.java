package tw.brad.myjava;

public class Lisa15 {

	public static void main(String[] args) {
		int a=10, b=3;
		
		//System.out.println(a++); a++=10(先不會變)
		//System.out.println(a); a=11
		                      //(放在後面的，一開始不會變，到之後才會變)
		
		//System.out.println(b--); b--=3
		//System.out.println(b); b=2
		//System.out.println(--b); --b=2(放在前面的會馬上變)
		
		
		if(++a >10 || --b<3) {
		System.out.printf("ok: a = %d ,b = %d ",a,b);
		//++a>10:對。||(or):前面若對，後面就不用再管了，所以不變。
	}else {
		System.out.printf("xx: a = %d ,b = %d ",a,b);
		//--a>10:錯。||:前面錯，後面要再看，--b<3:對。
		}
	}
}
