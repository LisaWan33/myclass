package tw.brad.myjava;

public class ATMTest {//領沒錢，就走
	public static void main(String[] args) {
		ATM atm=new ATM();
		Bank bank=new Bank(atm);
		Person a=new Person(atm,"A");
		Person b=new Person(atm,"B");
		Person c=new Person(atm,"C");
		
		bank.start();
		a.start();
		b.start();
		c.start();
	}
}
class ATM{
	private int money;
	private final int Limit=1000;
	
	void addmoney(int add) { //void addmoney:方法>""銀行"""加錢  ///int add:add是區域變數
	if(money+add<=Limit) {	
		money+=add;
		System.out.println("addmoney:"+add+"=>"+"total: "+money);
	}else {
		System.out.println("addmoney:沒有補錢=>"+"total:"+money);
		}
	}
	
	void getmoney(int get,String name) {//void getmoney:方法>""""人"""領錢  
	if(money>=get) {	
	   money-=get;
		System.out.println("get:"+get+"=>"+money+":"+name);
	}else {
		System.out.println("get:沒有人拿=>"+get+":"+name);
		}
	}
}



class Bank extends Thread{
	private ATM atm; //擁有
	Bank(ATM atm){this.atm=atm;} //認識
	
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
class Person extends Thread{
	private ATM atm;
	private String name;
	Person(ATM atm,String name){this.atm=atm;this.name=name;} //認識
		
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
	}
}