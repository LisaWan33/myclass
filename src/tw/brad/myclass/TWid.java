package tw.brad.myclass;

import java.util.stream.IntStream;

public class TWid {  //身分證產生器，做出物件//將String letters，設為static，可以直接用
	private String id;  //下列四招:參數型別、個數都不同，但四個都是同樣的邏輯，只是寫越多越複雜
	private static String letters="ABCDEFGH JKLMN PQRSTUV XY WZIO"; 
	public TWid() {   //丟給下一個人
		this((int)Math.random()*2==0); 
		
	}
	public TWid(boolean isMale) { //再丟給下一個 area:0-25
		this(isMale,(int)Math.random()*26);
	}
	public TWid(int area) { //再丟給下一個人處理
		this((int)Math.random()*2==0,area);
	}
	public TWid(boolean isMale,int area) {                //append:傳回自己本身
		StringBuffer sb = new StringBuffer();            
		sb.append(letters.substring(area, area+1))        //1
			.append(isMale?"1":"2")                       //2 :男=>1;女=>2
			.append((int)(Math.random()*10))              //3
			.append((int)(Math.random()*10))              //4
			.append((int)(Math.random()*10))              //5
			.append((int)(Math.random()*10))              //6
			.append((int)(Math.random()*10))              //7
			.append((int)(Math.random()*10))              //8
			.append((int)(Math.random()*10));             //9
		
		String temp=sb.toString();
		for(int i=0;i<10;i++) {
			if(isValidTWid(temp+i));
				id=temp+i;              //10(第10位數字，絕對要思考，是不是符合ret=sum%10==0，下面所做的)
		}
	  }
		public String getid() {
			return id;
		}
		
		
		public boolean isMale() {
			return true; //繼續加
		}
		private TWid(String id) {
			this.id = id;
		}
		public static TWid createTWId(String id) {
			TWid temp = null;
			if (isValidTWid(id)) {
				temp = new TWid(id);
			}
			return temp;
		}
		
	public static boolean isValidTWid(String id) {  //檢查身分證id是否有效 //設計static方法 //參考Lisa012，詳細介紹
		boolean ret=false;
		if(id.matches("[A-Z][1289][0-9]{8}")) {                    //正規表示法，且1+1+8=10
			letters="ABCDEFGH JKLMN PQRSTUV XY WZIO";              //條件:A-O，排序為10-35 
			char c1=id.charAt(0);                                  //A的n1=1,n2=0。o的n1=3,n2=5
			int pos=letters.indexOf(c1);  //0-25                   //indexOf傳回c1在Letters中的位置=0
			int n12=pos+10; //10-35
			int n1=n12/10;
			int n2=n12%10;
			
			String s3=id.substring(1, 2);
			int n3=Integer.parseInt(s3);
			//自行做迴圈
			int n4=Integer.parseInt(id.substring(2, 3));
			int n5=Integer.parseInt(id.substring(3, 4));
			int n6=Integer.parseInt(id.substring(4, 5));
			int n7=Integer.parseInt(id.substring(5, 6));
			int n8=Integer.parseInt(id.substring(6, 7));
			int n9=Integer.parseInt(id.substring(7, 8));
			int n10=Integer.parseInt(id.substring(8, 9));
			int n11=Integer.parseInt(id.substring(9, 10));
			
			int sum= n1 * 1 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 
					+ n7 * 4 + n8 * 3 + n9 * 2 + n10 * 1 + n11 * 1;
			ret=sum % 10 == 0;
			} 
//若=0，為有效身分證。則false；若!=0，則true   
// https://zh.wikipedia.org/zh-tw/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89
		
		
		
		/*
		public static boolean isValidTWid(String id) {
		if(id.length()==10) {                                          //總共10碼
			char c1=id.charAt(0);
			if (Character.isLetter(c1)) {                              //第一碼是英文
			String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			if (letters.indexOf(c1) >= 0) {

			}
			char c2=id.charAt(1);
			if(Character.isLetter(c2)) {
				String c2nd=id.substring(1, 2); 
				String c2nds="1289";   
				if (c2nds.contains(c2nd)) {                           //第二碼:0,"1",2，要在1289內
			}
				
		   	String c3nd=id.substring(3, 11);
				String c3nds="0-9";
				if (c3nds.contains(c3nd)) {
			}
					}
				}
			}
			boolean ret=true; */
			return ret;
	}
}