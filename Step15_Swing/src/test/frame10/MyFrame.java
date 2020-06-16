package test.frame10;
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


public class MyFrame extends JFrame implements ActionListener, KeyListener{
	//필드
	JButton sendBtn;
	JButton removeBtn;
	JTextField inputMsg = new JTextField(20);
	JLabel lab1;
	DefaultListModel<String> model;
	JList<String> list;
	
	//static final 상수
	static final String COMMAND_SEND = "send";
	static final String  COMMAND_REMOVE = "remove";
	
	//생성자
	public MyFrame() {
		setLayout(new BorderLayout());
		inputMsg.addKeyListener(this);
		
		JButton sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		
		JButton removeBtn = new JButton("선택 삭제");
		removeBtn.addActionListener(this);
		add(removeBtn, BorderLayout.SOUTH);
		
		//버튼 분기 나누기
		sendBtn.setActionCommand(COMMAND_SEND);
		removeBtn.setActionCommand(COMMAND_REMOVE);
		
		//JLabel 객체 생성
		lab1 = new JLabel("label입니다.");
		
		//JPanel 객체 생성
		JPanel panel = new JPanel();
		//패널도 레이아웃을 지정할 수 있다. (기본값은 FlowLayout 가운데 정렬이다)
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//JPanel에 UI 추가
		panel.add(inputMsg);
		panel.add(sendBtn);
		panel.add(lab1);
		
		panel.setBackground(Color.YELLOW);
		
		//JFrame에 JPanel을 북쪽에 배치하기
		add(panel, BorderLayout.NORTH);
		
		//기본 모델 객체(목록에 출력한 data를 가지고 있는 객체)
		list = new JList<>();
		model = new DefaultListModel<>(); //출력할 데이터를 갖고있는 것... 
		model.addElement("김구라");
		model.addElement("해골");
		model.addElement("원숭이");
	
		
		//목록에 모델 연결하기
		list.setModel(model);
		
		//목록을 프레임의 가운데에 배치하기
		add(list, BorderLayout.CENTER);
		
		//스크롤 패널
		JScrollPane sc = new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  //수직 스크롤 바 항상 나오게
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //수평 스크롤바는 안나오게
		
		//스크롤을 프레임의 가운데에 배체하기
		add(sc, BorderLayout.CENTER);
	}
	
	//메인
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("나의 프레임");
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void send() {
		String msg = inputMsg.getText();
        lab1.setText(msg);
        model.addElement(msg);
        inputMsg.setText("");
	}
	
	//ActionListener 인터페이스를  구현해서 강제 오버라이드된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("send")) {
			send();
		}else if(command.equals("remove")) {
			int a = list.getSelectedIndex();
			if(a != -1) {
				int confirm = JOptionPane.showConfirmDialog(this, "정말 삭제할거야?");  //상수값은 static field에 저장되어있으니까 객체에. 찍어서 확인 가능
				if(confirm == JOptionPane.OK_OPTION) {
					model.remove(a);
				}
			}else{
				JOptionPane.showMessageDialog(this, "삭제할 cell을 선택하세요");
			}
		}
	}//override actionPerformed

	
	
	// KeyListener 키를 눌렀을 때 호출되는 메소드
   @Override
   public void keyPressed(KeyEvent e) {
      int a = e.getKeyCode();
      if(a == KeyEvent.VK_ENTER) {
         send();
      }
   	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}//class MyFrame




