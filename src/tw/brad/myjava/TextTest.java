package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import tw.brad.myclass.MyClock;

public class TextTest extends JFrame{
//開檔、存檔、另存新檔、離開
	private JButton open,save,saveas,close;
	private JTextArea myTextArea;
	private JScrollPane jp;
	private MyClock myClock;
	
	public TextTest() {
		super("文字編輯器");
		
		setLayout(new BorderLayout());
		open=new JButton("Open");
		save=new JButton("Save");
		saveas=new JButton("Saveas");
		close=new JButton("close");
		myClock=new MyClock();
		myTextArea=new JTextArea();
		
		
		JPanel top=new JPanel(new FlowLayout());
		top.add(open);top.add(save);top.add(saveas);top.add(close);
		top.add(myClock);
		add(top,BorderLayout.NORTH);
		
		myTextArea.setLineWrap(true);
		
		jp=new JScrollPane(
		myTextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp.setBounds(100, 100, 600, 300);
		add(jp,BorderLayout.CENTER);
		
		
		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setupListener();
	}

	/**********************************************/
	private void setupListener() {
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				openfile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				savefile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			}
		});
		
		saveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				saveasfile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			}
		});	
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			closefile();
			}
		});
	}
///////////////////////////////////////////////////////////////////////////
	
	private void openfile() throws Exception { // 讀取檔案並附加至文字編輯區
		BufferedReader buf=
				new BufferedReader(
				new FileReader(choosefileToOpen()));
		String text;
		// 取得系統相依的換行字元
		String lineSeparator = System.getProperty("line.separator");
		while( (text = buf.readLine()) != null) { 
			myTextArea.append(text);
			myTextArea.append(lineSeparator);
		} buf.close();
	}
	

	private void savefile() throws Exception {
//		BufferedWriter bufw=
//				new BufferedWriter(
//				new FileWriter(choosefileToSave()));
//		String text=myTextArea.getText();
//		bufw.write(text);
//		bufw.flush();
//		bufw.close();
		

	if(isSaveasFile()) {
		dispose();
	}else{
		if(choosefileToSave()==null){
		int option=JOptionPane.showConfirmDialog(
				null, "未儲存過檔案，是否另存新檔?","另存新檔確認",
				JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null);
			switch(option) {
			case JOptionPane.YES_OPTION:
				saveasfile();
				break;
			case JOptionPane.NO_OPTION:
		}
	}else {
		BufferedWriter bufw=
				new BufferedWriter(
				new FileWriter(choosefileToSave()));
		String text=myTextArea.getText();
		bufw.write(text);
		bufw.flush();
		bufw.close();
	}
}
	}	
	
	private void saveasfile()throws Exception{
		String text=myTextArea.getText();
		BufferedWriter bufw=
				new BufferedWriter(
				new FileWriter(choosefileToSave()));
		
		bufw.write(text);
		bufw.flush();
		bufw.close();
		JOptionPane.showOptionDialog(
				null, "已另存新檔 ! ","確定",JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,null,null,null);
	}
	
	
	private void closefile() {
		if(isSaveFile()) {
			dispose();
		}else {
			int option=JOptionPane.showConfirmDialog(
					null, "檔案是否再次儲存?","要儲存檔案嗎?",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
		switch(option){
		case JOptionPane.YES_OPTION: try {
				savefile();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case JOptionPane.NO_OPTION:dispose();
		}
	}
}
/////////////////////////////////////////////////////////	
	private static  File choosefileToOpen() {
		// fileChooser 是 JFileChooser 的實例
		 // 顯示檔案選取的對話方塊
		JFileChooser jfc =new JFileChooser();
		if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		}else {return null;}
}
	
	private static File choosefileToSave() {
		JFileChooser jfc =new JFileChooser();
		if(jfc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		}else {return null;	}
}
	
	private  boolean isSaveFile() {
		return false ;
	}
	
	private  boolean isSaveasFile() {
		return false ;
	}
/////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new TextTest();
	}
}