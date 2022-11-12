package tw.brad.myjava;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Lisa81 extends JFrame{
	
	
	public Lisa81() {
		
		super("添加資料表");
		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		

		//容器
		Container pn=getContentPane();
////////////////////////////////////////////////////////		
		//面板
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,5,5));
		//建置內容=>>>>
		//標籤1
		JLabel name =new JLabel("姓名: ");
		p1.add(name);
		//文本域
		JTextField field1 = new JTextField(8);
		p1.add(field1);

		
		
		//標籤2
		JLabel  id=new JLabel("學號: ");
		p1.add(id);
		//文本域
		JTextField field2 = new JTextField(8);
		p1.add(field2);

		
		//標籤3
		JLabel tel =new JLabel("電話/行動電話: ");
		p1.add(tel);
		JTextField field3 = new JTextField(8);
		p1.add(field3);
		
		//標籤4
		
		JLabel addr= new JLabel("通訊地址: ");
		p1.add(addr);
		JTextField field4=new JTextField(32);
		p1.add(field4);
	
	
/////////////////////////////////////////////////
		JPanel p2=new JPanel();
		
		// 設置單選按鈕
		JLabel gender = new JLabel("性別");
		p2.add(gender);

		JRadioButton male = new JRadioButton("男");

		JRadioButton female = new JRadioButton("女");

		// 單選按鈕組,同一個單選按鈕組的互斥.

		ButtonGroup group = new ButtonGroup();

		group.add(male);
		p2.add(male);
		group.add(female);
		p2.add(female);
		
	////////////////////////////////////
		JPanel p3=new JPanel();
		p1.setLayout(new GridLayout(2,2,5,5));
		//標籤5

		JLabel ctp =new JLabel("聯絡人資訊: ");
		p3.add(ctp);
		JTextField field5 = new JTextField(16);
		p3.add(field5);
		
		//標籤6
		JLabel ctptel =new JLabel("聯絡人電話: ");
		p3.add(ctptel);
		JTextField field6 = new JTextField(16);
		p3.add(field6);
		
		
///////////////////////////////////////////////	
		JPanel p4=new JPanel();
	
		
		JLabel remark = new JLabel("備註欄: ");
		p4.add(remark);
		JTextField field7=new JTextField(50);
		p4.add(field7);
		
///////////////////////////////////////////////		
		//可建按鈕(是否新增一筆資料)
		JPanel p5=new JPanel();
		
		JButton bt=new JButton("新增");
		JButton bt1=new JButton("取消");
		p5.add(bt);
		p5.add(bt1);
		
		setLayout(new GridLayout(6,1,5,5));
		
		pn.add(p1);pn.add(p2);pn.add(p3);pn.add(p4);pn.add(p5);
		
		setContentPane(pn);
		
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Properties prop= new Properties();
				prop.put("user", "root");
				prop.put("password", "root");
				
				String url="jdbc:mysql://localhost:3309/eeit53";
									
				try {
						Connection conn = DriverManager.getConnection(url,prop);
//						Statement stmt=conn.createStatement();
						
					String name = field1.getText();
					String id = field2.getText();
					String tel =field3.getText();
					String addr = field4.getText();
					
					String gender = group.getSelection().getActionCommand();
					String ctp = field5.getText();
					String ctptel = field6.getText();
					String remark = field7.getText();
					
					String sql=	
					"INSERT INTO stdnt VALUES"
					+ "(?,?,?,?,?,?,?,?)";
					String[]paras= 
					{field1.getText(),field1.getText(),field1.getText(),};
					
					
					
					PreparedStatement pstmt =conn.prepareStatement(sql);
//					stmt.executeUpdate(sql);
					
					pstmt.execute();
					conn.close();
					System.out.println("ok");
					JOptionPane.showMessageDialog(bt, "添加成功");
					
				} catch (Exception e1) {
					System.out.println(e);
					JOptionPane.showMessageDialog(bt, "添加失敗");

				}
			
			}
			
		});
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			System.exit(HIDE_ON_CLOSE);
			}
		});
	}

	
	
	public static void main(String[] args) {
		new Lisa81();
	}
	}
