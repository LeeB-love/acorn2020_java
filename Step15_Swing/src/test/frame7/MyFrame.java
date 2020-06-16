package test.frame7;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	
	JButton sendBtn;
	JButton removeBtn;
	
	public MyFrame() {
		//레이아웃 매니저 지정하기
		setLayout(new FlowLayout());  //물 흐르듯이 레이아웃을 배치하는 것 : 창 크기에 따라 레이아웃이 달라진다. - 가운데 정렬, 위에서 아래로 쌓인다.
		//버튼
		sendBtn = new JButton("전송");
		removeBtn = new JButton("삭제");
		
		//분기나누기 방법 2. 버튼에 command 등록하기
		
		
		//프레임에 버튼 추가하기 (FlowLayout의 영향을 받는다.)
		add(sendBtn);
		add(removeBtn);
		
		//MyFrame 객체의 참조값을 전달해서 리스너 등록하기
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		
		//MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역변수 frame 에 담기
		/*
		 * process : 어떠한 운영체제에서 하나의 응용프로그램을 실행할 수 있도록 할당하는 것. 
		 * 실행 중인 프로그램이라고 보면 된다.
		 * 여러개의 응용프로그램을 동시에 실행하려면 여러개의 프로세스를 할당한다. (멀티 프로세싱)
		 * 디버그를 돌렸을 때 terminated 라고 나오면 프로세스가 끝나고 사라진 것
		 */
		MyFrame frame = new MyFrame();
		frame.setTitle("나의 프레임");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		//프레임이 떠있는 동안은 프로세스가 실행중인 상태로 유지된다. 
		//그런데 프레임을 꺼도 프로세스가 살아있는 상태로 나오기 때문에 프로세스 낭비를 막기 위해 아래 설정...
		//EXIT_ON_CLOSE = 3... 상수 3에 대응된다. 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	//ActionListener 인터페이스를  구현해서 강제 오버라이드된 메소드
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트가 일어나는 객체의 참조값을 object 타입으로 리턴해준다.
		if(obj == sendBtn) {
			JOptionPane.showMessageDialog(MyFrame.this, "전송합니다~"); 
		}else if(obj == removeBtn){
			JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다~"); 
		}

	}//override actionPerformed
}//class MyFrame



