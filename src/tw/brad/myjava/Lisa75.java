package tw.brad.myjava;

public class Lisa75 {//12

	public static void main(String[] args) {
		Lisa751 obj1=new Lisa751("A");
		obj1.start();
		try {
				Thread.sleep(1000); //主緒跑1秒
				} catch (InterruptedException e) {}
			
		
		
		Lisa751 obj2=new Lisa751("B");
		obj2.start();
		
		Lisa752 obj3=new Lisa752();
		obj3.start();
		System.out.println("ok1");
			
		try {
				obj3.join(2000);
				}catch(Exception e) {}
		
		
		System.out.println("ok2");
	}

}
class Lisa751 extends Thread{
	private String name;
	Lisa751(String name){this.name=name;}
	
	
	@Override
	public void run() {
		try {
		for(int i=0;i<10;i++) {
			System.out.println(name+":"+i);
			Thread.sleep(500);
			}
		}catch(Exception e) { //try_catch:任何一次發生例外，就會停止運行
		
		}
	}
}


class Lisa752 extends Thread{
	@Override
	public void run() {
		try {
		for(int i=0;i<10000000;i++) {
			if(i%1000000==0) System.out.println("Lisa");
		}
	
		}catch(Exception e) {
			
		}
}
}