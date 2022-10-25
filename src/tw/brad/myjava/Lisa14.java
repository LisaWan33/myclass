package tw.brad.myjava;

public class Lisa14 {  
/*論平年、閏年
 * 今年2022，是否是閏年?
 * <閏年規定>
 * 1.能被4整除，不能被100整除，閏年
 * 2.不能被100整除，(但能被400整除)，為閏年 
 * 3.能被400整除，閏年
 */
	
	public static void main(String[] args) {
		int year=2022;
		
		if (year % 4 == 0){
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					//ok
				}else {//xx		
				}
			}else {//潤
			}
		}else {//平
		}
//----------------------------------------------
		if(year % 400==0||(year % 4==0 && year % 100!=0)) {
			System.out.println("閏年");
		}else{
			System.out.println("平年");
		}
		}
}