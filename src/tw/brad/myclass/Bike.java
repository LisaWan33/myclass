package tw.brad.myclass;

import java.io.Serializable;

public class Bike extends Object implements Serializable{	
	protected  double speed; //屬性
	/*存取修飾字:   public:對外營業;   private:私有;   protected:保護級  (不開放，但可給Scooter用--相同package、相同子類別)。
	 *public means everyone is allowed to access, 
	 * private means that only members of the same class are allowed to access, 
	 * and protected means that members of subclasses are also allowed
	 */
	
	
	//找Lisa25執行，可以用double,int,boolean，初始化值不一樣
	//void就是空，在方法申明的時候表示該方法沒有返回值就行了。(無返回值。但可以在方法裏用return;來退出方法)
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2; //(:或者)
	}	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.7;
	}
	public double getSpeed() { //保持速度，被封裝，會return給你 ，取得speed(get speed)
		return speed;
	}
		
	@Override
	
	/*(覆寫:指子類別可以覆寫父類別的方法內容，使該方法擁有不同於父類別的行為。)
	 * 參考詳細介紹toString
	 
	 * 此覆寫之後，延伸到下一個class在呼喚的時候，直接已做更改
	 * ex:Lisa32-----78
	 */
	
	public String toString() {
		return "bike: "+speed;
		
	}
}
