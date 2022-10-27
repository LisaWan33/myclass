package tw.brad.myclass; //物件導向

public class Scooter extends Bike{ //延伸、擴大、發揚光大(繼承>>>認Bike為父類別)
	private int gear;       //設計多一個檔位 //物件"屬性"
	private int color;      //進行初始化
	
	 public Scooter() {
			this(2); //另一種方法
		}
	
	public Scooter(int color) { 
		//java所有類別一定有建構式!!!  若有血，就不用管爸爸;但沒有寫，就要找爸爸
		//建構式(constructor):將物件實體進行初始化，無傳回值、void，其名稱與類別名稱大小寫嚴格區分一樣，而非將物件做實體化
		this.color=color; 
		//讓人指定顏色，這裡先用int替代
	}
	/*public Scooter() {
		this.color=1;一號色
		} 上種，第1種方法*/
	public void upSpeed() { //改善加速度 //"方法" (override:改寫)   1
		
		speed = speed < 1 ? 1 : speed + speed*gear;
	}
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed *gear*0.2;
	}
	public void upSpeed(boolean isTurbo) {//渦輪加壓 (overloading)
		if(isTurbo) {
			speed = speed < 1 ? 1 : speed +speed*gear*1.2;//更快
		}else {
			upSpeed();//保持原狀
		}
			}

	public int changeGear(int gear /*想不到其他英文，檔位:整數  */ ) {
		if(gear>=0 && gear<=5) {   //int:32768~-32767很大，所以要設計int大小、範圍
			this.gear=gear;
			/*對外接收到的檔位=這個檔位屬性，剛好一樣，別想太多 
			 * this:本類別產生的那個物件實體(特別強調的時候)
			 */
		}
		return this.gear;  //若超過，則回原檔位
	}
	public int getGear() { //傳回目前檔位
		return gear;
	}	
}
//時坐在28 code
