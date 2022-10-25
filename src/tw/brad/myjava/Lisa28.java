package tw.brad.myjava;

public class Lisa28 { //觀念講解
	public static void main(String[] args) {
		Lisa283 obj1= new Lisa283(); 
		/*java都有父類別(只有Object)
		 * 所有類別有建構式、所有類別建構式都是從初始化而來
		 * 所以阿公爸爸都會被叫出來
		 */
	}
}






class Lisa281 extends Object { //若有其他類別想定義在這個檔案裡，不能用public(只能有一個)  //一代
	Lisa281(){
		System.out.println("Lisa281()");
	}
}
class Lisa282 extends Lisa281{    //二代
	Lisa282(int a){          
			System.out.println("Lisa282()");
	}
}
class Lisa283 extends Lisa282{  //三代        //往爸爸(二代)找，可以找到建構式
	Lisa283() {
			super(1); //定義自己
			System.out.println("Lisa283()");
	}
	
}