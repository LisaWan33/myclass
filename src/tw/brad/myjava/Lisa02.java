package tw.brad.myjava;

public class Lisa02 {

	public static void main(String[] args) {
		//整數 byte,short: 2^16 ,int=2^32(最常用) ,long=2^64
		//強型別語言
		byte var1=123; //2^8=>256 =-128 ~ 127
		byte Var1=-123; //[a-zA-Z$_][a-zA-Z0-9$_]*+no keyword
		byte $$$;
		byte $_$;
		$$$=-1; $_$=27;
		System.out.println(var1);
		System.out.println(Var1);
		System.out.println($$$);
		System.out.println($_$);
		
		byte Sho1=2^16;
		byte Int1=2^32;
		byte long1=2^64;
		System.out.println(Sho1);System.out.println(Int1);System.out.println(long1);
		System.out.printf("Sho1: %d  " + "int1: %d  " + "long1: %d  ",Sho1,Int1,long1);
		
	}

}
