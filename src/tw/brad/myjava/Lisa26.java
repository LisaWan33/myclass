package tw.brad.myjava;

import javax.swing.JFrame;

public class Lisa26 {

	public static void main(String[] args) {
		
		JFrame f1 = new JFrame(); //區域變數而已，只在自己開發的小玩具上而已
		f1.setSize(640, 480);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setTitle("I'm f1");
		
		
		JFrame f2 = new JFrame();
		f2.setSize(640, 480);
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setTitle("I'm f2");
	}

}
