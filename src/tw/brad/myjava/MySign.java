package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.myclass.MyClock;
import tw.brad.myclass.MyDrawer;

public class MySign extends JFrame{
	private JButton clear, undo, redo, chColor,save, saveObj, loadObj;
	private MyDrawer myDrawer;
	private MyClock myClock;
	
			public MySign() {
		
			super("簽名App");
			
			setLayout(new BorderLayout());
			
			clear = new JButton("Clear");
			undo = new JButton("Undo");
			redo = new JButton("Redo");
			chColor=new JButton("Color");
			save=new JButton("Save JPG");
			saveObj=new JButton("Save Obj");
			loadObj=new JButton("Load Obj");
			myClock= new MyClock();
			
			JPanel top = new JPanel(new FlowLayout());
			top.add(clear); top.add(undo); top.add(redo);
			top.add(chColor);top.add(save);top.add(saveObj); top.add(loadObj);
			top.add(myClock);
			
			
			
			add(top, BorderLayout.NORTH);
			
			myDrawer = new MyDrawer();
			add(myDrawer, BorderLayout.CENTER);
			

			setSize(800, 480);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			setupListener();
			}
			
			
			
		/******************************/	
		private void setupListener() {
			clear.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					myDrawer.clear();
				}
			});
			
			undo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					myDrawer.undo();
				}
			});
			
			
			redo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					myDrawer.redo();
				}
			});
			
			chColor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					changeColor();
				}
			});
			
			save.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				savejpg();
			}
		    });
			
			saveObj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						myDrawer.saveLines();
					}catch (Exception e2) {
					}
				}
			});		
			
			loadObj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						myDrawer.loadLines();
					}catch (Exception e2) {
					}
				}
			});
			
		}
			
		private void savejpg() {
			JFileChooser jfc= new JFileChooser();
			if(jfc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
				File saveFile=jfc.getSelectedFile();
				if(myDrawer.saveJpeg(saveFile)) {
					JOptionPane.showMessageDialog(null,"save ok");
				}else {
					JOptionPane.showMessageDialog(null, "Save Failure");
				}
			}
			
			}
		
		
		private void changeColor() {
			Color newColor = JColorChooser.showDialog(null, "Line Color", myDrawer.getNowColor());
			myDrawer.setNowColor(newColor); 
		}
		
		/******************************/
		public static void main(String[] args) {
			new MySign();
			}
		
		
		
		
	}

