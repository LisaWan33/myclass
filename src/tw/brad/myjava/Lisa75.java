package tw.brad.myjava;

public class Lisa75 {

	public static void main(String[] args) {
		Lisa751 obj1=new Lisa751("A");
		obj1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("ok1");
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