package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.myclass.MyClock;

public class TextTest extends JFrame{

	private JButton save,saveas;
	private MyClock myClock;
	
	public TextTest() {
		super("文字編輯器");
		
		setLayout(new BorderLayout());
		save=new JButton("Save");
		saveas=new JButton("Saveas");
		myClock=new MyClock();
		
		JPanel top=new JPanel(new FlowLayout());
		top.add(save);top.add(saveas);top.add(myClock);
		
		add(top,BorderLayout.NORTH);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	}

	
	
	
	
	public static void main(String[] args) {
		new TextTest();
	}

}
