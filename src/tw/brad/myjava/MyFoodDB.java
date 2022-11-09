package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.brad.myclass.MyFoodTable;

public class MyFoodDB extends JFrame{
	private MyFoodTable foodTable;
	private JButton delet,add,test;
	
	public MyFoodDB() {
		super("食物");
		
		setLayout(new BorderLayout());
		
		
		try {
			foodTable = new MyFoodTable();
		}catch(Exception e) {
			System.out.println(e);
		}
		JScrollPane jsp = new JScrollPane(foodTable);
		add(jsp,BorderLayout.CENTER);
		
		JPanel top=new JPanel(new FlowLayout());
		delet=new JButton("刪除");
		add=new JButton("增加");
		test=new JButton("重新查詢sql");
		
		add(top,BorderLayout.NORTH);
		top.add(delet);
		top.add(add);
		top.add(test);
		
		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupListener();
	}
	
	private void setupListener() {
		delet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.delRow();
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.addRow();
			}
		});
	
		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.newsql();
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MyFoodDB();
	}

}
