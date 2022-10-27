package tw.brad.myjava;

import tw.brad.myclass.Bike;
import tw.brad.myclass.Scooter;

public class Lisa25 { //4

	public static void main(String[] args) {
		Bike b1= new Bike();   //宣告Bike=初始化
		System.out.println(b1.getSpeed()); //1
		while(b1.getSpeed()<=10) { //while 迴圈，當()條件成立時，就重覆做的事...，若>10，即停止。
			b1.upSpeed();
		}
		System.out.println(b1.getSpeed()); //2
		System.out.println("--------");
		
		Scooter s1=new Scooter(); 
		//已建立Scooter，且從Bike延伸，先宣告 
		//new:在記憶體產生一個位置--也初始化，物件產生，且要建構(人生中要有一次)  1:color		
		System.out.println(s1.getSpeed()+":"+s1.getGear());//字串相加
		
		s1.changeGear(2);//changeGear()來自scooter，超過5，不執行，回原檔位
		s1.upSpeed();s1.upSpeed(); //1+1*2=3
		System.out.println(s1.getSpeed());
		
		s1.changeGear(s1.getGear() + 1); //現在檔位+1=3
		s1.upSpeed();s1.upSpeed();s1.downSpeed(); //  3+3*3=12、12+12*3=48、48*3*0.2=28.8
		System.out.println(s1.getSpeed());
		
		s1.changeGear(3);
		s1.upSpeed(true); //Scooter所創出的新加速模式，boolean
		System.out.println(s1.getSpeed()); // double a=28.8+28.8*3*1.2=132.48000000000002
	 
	}

}		
		
		/*Bike b2= new Bike();
		//Lisa b2=new Lisa();
		System.out.println(b1.speed);
		System.out.println(b2.speed);
		
		b1.speed=123;
		b2.speed=10.2;
		System.out.println(b1.speed);
		System.out.println(b2.speed);
		System.out.println("------");
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.speed);*/

