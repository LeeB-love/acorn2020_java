package test.frame3;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {  //이 클래스 자체가 프레임이 됨. 객체 생성하면 바로 프레임 만들어짐
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(700, 200, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//레이아웃 매니저를 GridLayout으로 지정하기 (2행 2열)
		setLayout(new GridLayout(2,2));
		
		JButton btn1 = new JButton("버튼1");
		add(btn1);//프레임에 btn1 추가하기
		

		JButton btn2 = new JButton("버튼2");
		add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		add(btn4);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
