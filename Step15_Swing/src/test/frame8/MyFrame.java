package test.frame8;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MyFrame extends JFrame implements ActionListener{
	
	JButton sendBtn;
	JButton removeBtn;
	JTextField inputMsg = new JTextField(20);
	
	
	public MyFrame() {
		setLayout(new FlowLayout());
		//문자열 한 줄을 입력할 수 있는 JTextField
		add(inputMsg);
		JButton sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("나의 프레임");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	//ActionListener 인터페이스를  구현해서 강제 오버라이드된 메소드
	public void actionPerformed(ActionEvent e) {
		//JTenxtField에 입력한 문자열을 읽어와야한다.
		String msg = inputMsg.getText();
		JOptionPane.showMessageDialog(MyFrame.this, msg); 
	}//override actionPerformed
}//class MyFrame



