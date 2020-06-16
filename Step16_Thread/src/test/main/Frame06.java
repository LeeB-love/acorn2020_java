package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountRunnable;
import test.mypac.CountTread;
//여기서부터 main thread (작업의 흐름-작업단위)
public class Frame06 extends JFrame implements ActionListener{
	//필드
	JLabel label_result;
	
	//내부클래스
	class CountThread extends Thread{
		@Override
		public void run() {
			int count = 0;
			
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++;  //count 를 1 증가시킨다.
				System.out.println("현재 카운트 : "+count);
				if(count == 10) { //타운트가 10이 되면 반복문 탈출
					break;
				}
			}//while
			/*
			 * 내부 클래스의 메소드 안에서 바깥쪽에 클래스의 필드와 메소~
			 * 드를 사용할 수 있다.
			 */
			label_result.setText("작업종료~");
		}//run
	}//class CountThread
	
	//생성자
	public Frame06() {
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
		
		//JLabel
		label_result = new JLabel();
		panel.add(label_result);

	}
	
	public static void main(String[] args) {
		Frame06 frame = new Frame06();
		frame.setTitle("Frame01");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//내부 클래스를 이용해서 스레드 객체를 생성하여 시작시킨다.
		new CountThread().start();
		System.out.println("새로운 스레드를 시작했습니다.");
	}

}
