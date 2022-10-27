package tw.brad.myjava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tw.brad.myclass.MyClock;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;
	private MyClock myClock;
	
	public Racing() {
		super("賽車");//設計8個賽道+1個按鈕道;一個垂直column
		setLayout(new GridLayout(9,1));
		
		go=new JButton("GO!"); 
		myClock = new MyClock();
		JPanel top = new JPanel(new FlowLayout());
		
		top.add(go);top.add(myClock);
		
		add(top);
		
		go.setBackground(Color.lightGray);
		////////////////////////////////////////
		lanes=new JLabel[8];
		for(int i=0;i<lanes.length;i++) {
			lanes[i]=new JLabel((i+1)+".");
			add(lanes[i]);
			
		}
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
			
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		preGo();
	}
	private void preGo() {
		rank=1;
		cars=new Car[8];
		for (int i=0;i<cars.length;i++) {
			cars[i]=new Car(i);
		}
		for(int i=0;i<lanes.length;i++) {
			lanes[i].setText((i+1)+".");
		}
	}
	private void go() {
		for (int i=0;i<cars.length;i++) {
			cars[i].start();
			go.setEnabled(false);
			preGo();
		}
	}
	
	private class Car extends Thread{
		private int lane;   //跑第幾跑道
	    Car(int lane){this.lane=lane;}
		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				if(i==99) {
					
					lanes[lane].setText(lanes[lane].getText()+">"+rank++);
					stopGame();
				}else {
					lanes[lane].setText(lanes[lane].getText()+">");
				}
				try {
					
					Thread.sleep(10+(int)(Math.random()*200));
				}catch(Exception e){
					break;
				}
			}
		}
	}
	private void stopGame() {
		for(int i=0;i<cars.length;i++) {
			cars[i].interrupt();
		}
	go.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new Racing();
	}
}
