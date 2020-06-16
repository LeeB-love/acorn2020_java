package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountTread;
//여기서부터 main thread (작업의 흐름-작업단위)
public class Frame02 extends JFrame implements ActionListener{
	
	//생성자
	public Frame02() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//패널을 프레임의 상단에 배치
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		add(panel, BorderLayout.NORTH);
		//패널에 버튼추가
		JButton countBtn = new JButton("1~10까지 세기");
		panel.add(countBtn);
		
		countBtn.addActionListener(this);

	}
	
	public static void main(String[] args) {
		Frame02 frame = new Frame02();
		frame.setTitle("Frame01");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CountTread t = new CountTread();
		t.start();  //run 메소드 호출 대신 start 메소드를 호출한다. start 메소드는 바로 리턴하는 메소드이기 때문에 다음 실행순서로 바로 넘어갈 수 있다.
		System.out.println("새로운 스레드를 시작했습니다.");
	}
	/*
	 * 시간이 오래 걸리거나 불확실한 작업을 할 경우  스레드가 여러개 필요할 수 있다. - 스레드가 잡혀있는 10초 동안은 다른 작업은 아예 할 수 없다.
	 */
}
