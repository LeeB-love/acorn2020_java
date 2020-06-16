package test.frame11;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputNum1;
	JTextField inputNum2;
	JButton plus;
	JButton minus;
	JButton multiple;
	JButton division;
	JLabel lab2;
	
	//생성자
	public MyFrame() {
		setLayout(new BorderLayout());
		
		//input field
		inputNum1 = new JTextField(10);
		inputNum2 = new JTextField(10);
		
		//button
		plus = new JButton("+");
		plus.addActionListener(this);
		
		minus = new JButton("-");
		minus.addActionListener(this);
		
		multiple = new JButton("*");
		multiple.addActionListener(this);
		
		division = new JButton("/");
		division.addActionListener(this);
		
			//이벤트 분기 나누기
			plus.setActionCommand("plus");
			minus.setActionCommand("minus");
			multiple.setActionCommand("multiple");
			division.setActionCommand("division");
		
		//label
		JLabel lab1 = new JLabel("=");
		lab2 = new JLabel();
		
		//panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);

			//레이아웃
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(inputNum1);
		panel.add(plus);
		panel.add(minus);
		panel.add(multiple);
		panel.add(division);
		panel.add(inputNum2);
		panel.add(lab1);
		panel.add(lab2);
		
		add(panel, BorderLayout.NORTH);	
	}
	
	//메인
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("계산기");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Double num1 = Double.parseDouble(inputNum1.getText());
			Double num2 = Double.parseDouble(inputNum2.getText());
			
			String command = e.getActionCommand();
			if(command.equals("plus")) {
				Double result1 = num1 + num2; 
				lab2.setText(result1.toString());
			}else if(command.equals("minus")) {
				Double result2 = num1 - num2;
				lab2.setText(result2.toString());
			}else if(command.equals("multiple")) {
				Double result3 = num1 * num2;
				lab2.setText(result3.toString());
			}else if(command.equals("division")) {
				Double result4 = num1 / num2;
				lab2.setText(result4.toString());
			}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "숫자를 입력하세요");
		}
				
	}//override actionPerformed

}//class MyFrame




