package tw.brad.myjava;

public class Lisa76 {

	public static void main(String[] args) { //Thread Priority(執行緒優先順序)
		Lisa751 objA=new Lisa751("A");
		Lisa751 objB=new Lisa751("B");
		Lisa751 objC=new Lisa751("C");
		
		
		
//		objA.setPriority(Thread.MIN_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
//		objA.setPriority(Thread.NORM_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		
//		objA.setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		
		
		//objA.setDaemon(true); (有魔鬼就會在前景直接結束<後景會看前景的臉色>，但若是沒有魔鬼，就會繼續做)
		objA.start();
		objB.start();
		objC.start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}System.out.println("main");
	}
}
