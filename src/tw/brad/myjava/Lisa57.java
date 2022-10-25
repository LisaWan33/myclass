package tw.brad.myjava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Lisa57 {
	public static void main(String[] args) {
		student s1=new student("brad",20,30,40);
		System.out.printf("%s:%d:%f\n",s1.getname(),s1.score(),s1.average());
		
		student s2=new student("eric",60,70,80);
		System.out.printf("%s:%d:%f\n",s2.getname(),s2.score(),s2.average());		
		
		
		
		try {
			ObjectOutputStream oout= 
				new ObjectOutputStream(new FileOutputStream("dir1/brad.score")); 
			//後面從new ObjectOutputStream 中 new FileOutputStream("")進來
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			oout.close();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
class student implements Serializable{ //實作可序列化，才可以讀====>>>但從要如何解序列化(dir1/brad.score看不到)?看Lisa58
	private int ch,eng,math;
	private String name;
	student(String name,int ch,int eng,int math){
		this.name=name;
		this.ch=ch; this.eng=eng; this.math=math;
	}
	String getname() {return name;}
	int score() {return ch+eng+math;}
	double average() {return score()/3.0;}
}