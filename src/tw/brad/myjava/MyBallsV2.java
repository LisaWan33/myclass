package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.myclass.MyClock;
import tw.brad.myclass.MyPanel;

public class MyBallsV2 extends JFrame {//先建立基礎外觀，再去剖析內部元素=>>MyPanel
	private MyPanel myPanel;
	private MyClock myClock;
	
	public MyBallsV2() {
		super("My Game");
	
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		myClock = new MyClock();
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		top.add(myClock);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyBallsV2();
	}

}