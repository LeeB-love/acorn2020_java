package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//여기서부터 main thread (작업의 흐름-작업단위)
public class Frame01 extends JFrame implements ActionListener{
	
	//생성자
	public Frame01() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//패널을 프레임의 상단에 배치
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		add(panel, BorderLayout.NORTH);
		//패널에 버튼추가
		JButton alertBtn = new JButton("알림 띄우기");
		panel.add(alertBtn);
		
		alertBtn.addActionListener(this);

	}
	
	public static void main(String[] args) {
		Frame01 frame = new Frame01();
		frame.setTitle("Frame01");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림~");
		//알림창 확인을 누르기 전까진 리턴하지 않는다. 알림창 끄기 전까지 실행순서를 계속 잡아두고 있음
		System.out.println("알림창이 닫혔습니다.");
		
		try {
			System.out.println("5초동안 무언가 준비작업을 해요");
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	/*
	 * 시간이 오래 걸리거나 불확실한 작업을 할 경우  스레드가 여러개 필요할 수 있다. 
	 */
}
