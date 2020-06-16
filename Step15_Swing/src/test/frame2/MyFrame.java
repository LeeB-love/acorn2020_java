package test.frame2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {  //이 클래스 자체가 프레임이 됨. 객체 생성하면 바로 프레임 만들어짐
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(700, 200, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//프레임의 레이아웃 매니저를 사용하지 않기 때문에 UI를 절대 좌표에 직접 배치해야한다.
		setLayout(new FlowLayout(FlowLayout.CENTER));  //생성자 세개 : align : 정렬/ hgap : 수평갭 / vgap : 수직갭
		//상수값으로 저장되어있는데 상수만 띡 나오면 뭔 소린지 한눈에 알아먹을 수 없으니까 FlowLayout.CENTER 뭐 이런식으로 보여주는 것. 원래는 상수값
		
		//setLayout을 null로 하면 직접 좌표를 지정해서 배치해야한다.
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
