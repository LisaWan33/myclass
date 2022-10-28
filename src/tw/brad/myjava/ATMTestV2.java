package tw.brad.myjava;

public class ATMTestV2 { //領沒錢，就等
	public static void main(String[] args) {
		System.out.println("ATMTestV2");
		ATMV2 atm=new ATMV2();
		BankV2 bank=new BankV2(atm);
		PersonV2 a=new PersonV2(atm,"A");
		PersonV2 b=new PersonV2(atm,"B");
		PersonV2 c=new PersonV2(atm,"C");
		
		bank.start();
		a.start();
		b.start();
		c.start();
	}
}
class ATMV2{
	private int money;
	private final int Limit=1000;
	
	void addmoney(int add) { //void addmoney:方法>""銀行"""加錢  ///int add:add是區域變數
	while(money+add>Limit) {	
		
		System.out.println("addmoney:xxx.....wait");
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	
	money+=add;	
	System.out.println("addmoney"+add+"=>"+money);
	notifyAll(); //	
	}
	
	void getmoney(int get,String name) {//void getmoney:方法>""""人"""領錢  
	while(money<get) {
		System.out.println("get:xxx=>wait...=>"+get+":"+name);
		try {
		wait();
		}catch(Exception e) {}
		
		money-=get;
		System.out.println("get:"+get+"=>"+money+":"+name);
		
		}
	}
}



class BankV2 extends Thread{
	private ATMV2 atm; //擁有
	BankV2(ATMV2 atm){this.atm=atm;} //認識
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			
			synchronized (atm) { //synchronized (atm):鎖定，只要一鎖定，其他人就不能玩了!
				atm.addmoney(200); //別人領錢時，我們補錢(一次補200)
			}
			try {
				Thread.sleep(1000); //睡一秒
			} catch (InterruptedException e) {
			}
		}
	}
}
class PersonV2 extends Thread{
	private ATMV2 atm;
	private String name;
	PersonV2(ATMV2 atm,String name){this.atm=atm;this.name=name;} //認識
		
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized (atm) {
				atm.getmoney(10+(int )(Math.random()*50),name);//領錢	
			}
		try {
			Thread.sleep(100);//頻率比較高，所以睡比較少
		} catch (InterruptedException e) {
		}
		}
		System.out.println(name + ":stop");
	}

}