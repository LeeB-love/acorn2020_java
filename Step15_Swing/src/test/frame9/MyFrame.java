package test.frame9;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MyFrame extends JFrame implements ActionListener, KeyListener{
	//필드
	JButton sendBtn;
	JButton removeBtn;
	JTextField inputMsg = new JTextField(20);
	JLabel lab1;
	
	//생성자
	public MyFrame() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//문자열 한 줄을 입력할 수 있는 JTextField
		add(inputMsg);
		inputMsg.addKeyListener(this);
		
		
		JButton sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);
		
		//JLabel 객체 생성
		lab1 = new JLabel("label입니다.");
		add(lab1);
	}
	
	//메인
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("나의 프레임");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	//ActionListener 인터페이스를  구현해서 강제 오버라이드된 메소드
	public void actionPerformed(ActionEvent e) {
		String msg = inputMsg.getText();
		lab1.setText(msg);
		inputMsg.setText("");
		
	}//override actionPerformed

	
	//키를 눌렀을 때 호출되는 메소드
	   @Override
	   public void keyPressed(KeyEvent e) {
	      int a = e.getKeyCode();
	      if(a == KeyEvent.VK_ENTER) {
	         String msg = inputMsg.getText();
	         lab1.setText(msg);
	         inputMsg.setText("");
	      }
	   }


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}//class MyFrame



