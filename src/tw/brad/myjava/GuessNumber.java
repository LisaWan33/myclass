package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{  
	private JButton guess; //宣告 輸guess，就是Button
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;
	
	public  GuessNumber() {
		super("猜數字Game");
		
		//guess.setText(""); NullPoint:
		guess = new JButton("猜");
		input= new JTextField(); 
		log= new JTextArea();
		
		
		
		//BorderLayout():肚子裡面
		setLayout(new BorderLayout());       
		JPanel top =new JPanel(new BorderLayout()); //新增一個top，上面用一個桌子來做
		
		//加內容--center:中間，east:東邊
		top.add(input,BorderLayout.CENTER); 
		top.add(guess,BorderLayout.EAST);
		
		
		//外面整體，將剛剛做的放到北邊，在中間在放入一個輸字區
		add(top,BorderLayout.NORTH);
		add(log,BorderLayout.CENTER);
			
		
		
		guess.addActionListener(this);
		/*this:因為這裡只有一個按鈕
		 * 第二種寫法，多一個類別
		 * 第三種寫法，比較直接，按下按鈕，就做甚麼事
		 
	
		guess.addActionListener(new MyListener());
		guess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Listener 2");
			}
		});*/
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		newRound();
	}
	
	  //核心功能 從PokerV3來，牌洗完，抽出前三個
		private String createAnswer(int dig) {
		int nums = 10;
		int[] poker = new int[nums];
		
		// 
		for (int i=0; i<nums; i++) poker[i] = i;
		
		//
		for (int i = nums -1; i > 0; i--) {
			int rand = (int)(Math.random() * (i+1));
			// poker[rand] <-> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		//一碼一碼抽出來
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<dig;i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
		}
		public static void main(String[] args) {
		new GuessNumber();
	}

		
		private void newRound() {
			answer=createAnswer(3);
			counter = 0;
			log.setText("");
			System.out.println(answer);
					}
		
		
		@Override //聽的機制有被觸發，按猜
		public void actionPerformed(ActionEvent e) {
			System.out.println("Listener 0");
			 /* 
			 */
			counter++;
			String result=checkAB();
			log.append(counter+ " ."+ input.getText()+":"+result+"\n");
			if(result.equals("3A0B")) {
				JOptionPane.showMessageDialog(null, "恭喜老爺夫人! ");
				newRound();
			}else if (counter==10) {
				JOptionPane.showMessageDialog(null, "You're Loser! "+answer);
				newRound();
			}
			input.setText("");
		}
		private String checkAB() {
			int a, b; a = b = 0;
			String gString=input.getText();
			 for (int i=0; i<answer.length(); i++){
				 char ac= answer.charAt(i);
				 char gc= gString.charAt(i);
				 /*if (answer中的第i馬 == guess中的第i馬 ){
				  * a++;
				  * }else if (guess中的第i馬 是否存在於 a 中) {
				  * b++;
				  */
				 
				if (ac== gc ) {
					a++;
				}else if (answer.indexOf(gc)>=0) {
					b++;
				}
			}
			return String.format("%dA%dB",a, b );
		}
		
}
/*第二種寫法，新增一個類別，但比較麻煩
class MyListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Listener 1");
	}

}	*/