package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass01 {
	public static void main(String[] args) {
		//1. JFrame 객체를 생성해서 참조값을 활용하여 생성하는 방법
		//JFrame 객체 생성하고
		JFrame f = new JFrame("Hello Frame");
		// 초기 위치와 크기 지정
		f.setBounds(100, 100, 500, 500);
		//프레임을 닫았을 때 자동으로 프로세스가 종료되도록한다.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임이 보이도록 한다.
		f.setVisible(true);
		//레이아웃 매니저를 사용하지 않도록 설정
		f.setLayout(null);
		//버튼 객체 생성
		JButton btn =  new JButton("눌러보셈");
		//버튼의 위치와 크기 지정
		btn.setBounds(100, 100, 100, 40);
		//프레임에 버튼 추가하기
		f.add(btn);
		
		new MyFrame("나만의 프레임");
		
	}
	
	public static class MyFrame extends JFrame{
		public MyFrame(String title) {
			//2. JFrame 클래스를 상속받아서 클래스 자체를 만들어서 하는 방법.
			super(title);
			//초기화 작업... 원래 this. 붙여야하는데 나의 메소드니까 생략해도 된다.
			setBounds(200, 200, 500, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			setLayout(null);
			JButton btn =new JButton("눌러보세용~");
			btn.setBounds(100, 100, 150, 40);
			add(btn);
		}
	}
}
