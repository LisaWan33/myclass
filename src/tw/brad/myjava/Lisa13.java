package tw.brad.myjava;

public class Lisa13 {

	public static void main(String[] args) {
		int score= (int)(Math.random()*101);
		System.out.println(score);  //90+A ,80+B,70+C,60+D,E
	
/*
		if(score>=90) {
			System.out.println("A");
		}else {
			if(score>=80) {
				System.out.println("B");
		    }else {
			   if(score>=70) {
				   System.out.println("C");
			   }else {
				   if(score>=60) {
					   System.out.println("D");
				   }else {
					   System.out.println("E");
					   }
				   }
			     }
			   }*///全部的if()後面不能加分號，不然else會定義不出來，會出錯
		if(score>=90){    
			System.out.println("A");
		}else if(score>=80) {     
				System.out.println("B");
		} else if(score>=70) {
				System.out.println("C");
		}else if(score>=60) {
				System.out.println("D");
		}else {
			System.out.println("E");
					}
     }
  }