package tw.brad.myjava;

import java.util.Timer;
import java.util.TimerTask;

public class Lisa74 {

	public static void main(String[] args) {
		Timer  timer=new Timer();
		MyTask task1=new MyTask();
		timer.schedule(task1, 1000,500);
		EndTask task2=new EndTask(timer);
		timer.schedule(task2, 10*1000);
		System.out.println("ok");
	}
}
	class MyTask extends TimerTask{
	int i;
	public void run() {
	 System.out.println(i++);
}
}
	class EndTask extends TimerTask{
	private Timer timer;
	EndTask(Timer timer){
		this.timer=timer;
	}
	
	public void run() {
		timer.cancel();
		timer.purge();
	}
}