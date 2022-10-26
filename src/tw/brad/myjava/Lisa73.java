package tw.brad.myjava;

public class Lisa73 {

	public static void main(String[] args) {
		/*多重執行緒( multi-thread)   =>>>multi-process
		 * 
		 * 10、11表現物件實體，12、13產生一個生命
		 */
		MyThread mt1=new MyThread("A");
		MyThread mt2=new MyThread("B");
		MyRunnable mr1=new MyRunnable("C");
		Thread t1=new Thread(mr1);
		//mr1被利用=>>t1，才是真的執行緒
		
		t1.run();
		System.out.println("---------");
		
		mt1.start();
		mt2.start(); //start會去睡0.001秒，run不會
		t1.start();
		System.out.println("main");
	}	
}
//第一種寫法: 較無彈性，寫下來之後，就不能再繼承了
class MyThread extends Thread{
	String name;
	MyThread(String name){
		this.name=name;
	}
	@Override //run()方法:=>>Thread
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(name+":"+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
//第二種寫法
class MyRunnable implements Runnable{
	String name;
	MyRunnable(String name){
		this.name=name;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(name+":"+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}