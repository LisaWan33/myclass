package tw.brad.myjava;

public class Lisa44 {
	public static void main(String[] args) {
		Bird b1=new Bird();
		try {
		b1.setleg(2);
		}catch(Exception e) { //e 只是隨便放一個變數
			System.out.println("xxx"); //if b1.setleg(3);
		}
		System.out.println(b1.leg); //若是try_catch中，沒有例外的結果，就可以直接跳過"xxx"，直接輸到這條
	}
}



class Bird{
	int leg;
	void setleg(int n) throws Exception{  //要在外面就設定，可能會有例外的情況，用exception，排除所有exception
		if(n>=0&&n<=2) {
			leg=n;  //一隻鳥，只會有0~2隻腳，如果超過就列為是例外!!
		}else { //拋出示好的，比較有彈性
			throw new Exception();
		}
	}
}