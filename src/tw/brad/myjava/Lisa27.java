package tw.brad.myjava;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Lisa27 extends JFrame { 
	//Lisa27 就是JFrame，不用再定義，自家人 (繼承)，直接用
	//Lisa27 Object "is-a" JFrame 
	//Lisa27 Object "has-a" b1,b2,b3
	private JButton b1,b2,b3;
	public Lisa27() {
		//super()
		//super可以理解為是指向自己超（父）類物件的一個指標，而這個超類指的是離自己最近的一個父類。
		super("My Window");   //單一視窗寫法
		b1=new JButton("B1"); //做初始化設定
		b2=new JButton("B2");
		b3=new JButton("B3");
		
		setLayout(new FlowLayout());//找程式設計師
		add(b1);add(b2);add(b3);
		
		setSize(640, 480); //最好寫在後面，不然中間寫的元件會看不到
		setVisible(true); //選true
		setDefaultCloseOperation(EXIT_ON_CLOSE);//輸setDOC收
		
	}
	public static void main(String[] args) {
		new Lisa27();
	}

}
