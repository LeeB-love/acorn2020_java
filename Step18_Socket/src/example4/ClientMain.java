package example4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain extends JFrame implements ActionListener, KeyListener{
	
	JTextField tf_msg;
	//서버와 연결된 Socket 객체으이 참조값을 담을 필드
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	
	//생성자
			public ClientMain(){
				
				//특정한 아이피 주소의 서버에 소켓접속을 한다.
				try {
					//접속이 성공되면 Socket 객체의 참조값이 반환된다.
					//반환되는 객체의 참조값을 필드에 저장해놓는다.
					//접속에 성공하면 소켓객체를 하나 반환해준다.
					socket = new Socket("192.168.0.30", 5000);  //생성자를 통해 접속을 한 번만 하기
					System.out.println("Socket 연결 성공!");
					//문자열을 서버에 전송(출력 Output) 하기
					OutputStream os = socket.getOutputStream(); //출력메소드 - byte출력메소드밖에 없음
					OutputStreamWriter osw =new OutputStreamWriter(os); //출력메소드 확장 - String 출력해주는 기능 有
					bw = new BufferedWriter(osw); //서버에 문자열을 출력할 BufferedWriter 객체의 참조값을 얻어내서 필드에 저장해놓는다.
					//osw가 한번만 사용되고 버려지는 구조 - actionPerformed메소드에 넣지 말고 필드에 넣으면 한번만 new할 수 있다.
					
					//서버로부터 메세지를 받을 스레드도 시작을 시킨다.
					new ClientThread().start();
					
				}catch (Exception e) {
					//접속이 실패하면 예외가 발생한다.
					e.printStackTrace();
				}
				
				//레이아웃을 BorderLayout 으로 지정하기
				setLayout(new BorderLayout());
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.pink);
				tf_msg = new JTextField(20);
				tf_msg.addKeyListener(this);
				
				JButton sendBtn = new JButton("전송");
				sendBtn.setActionCommand("send");
				sendBtn.addActionListener(this);
				
				panel.add(tf_msg);
				panel.add(sendBtn);
			
				add(panel,BorderLayout.SOUTH);
			
				area = new JTextArea();
				area.setEditable(false);
				add(area);
				
				//스크롤 가능하도록
				JScrollPane scroll = new JScrollPane(area, 
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				add(scroll, BorderLayout.CENTER);	
			}
	
	public static void main(String[] args) {
		
		ClientMain f = new ClientMain();
		f.setTitle("채팅창");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void  sendMessage() {
		String msg = tf_msg.getText();
		try {
			//필드에 있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
			bw.write(msg);
			bw.newLine();//개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
			bw.flush();
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
		tf_msg.setText("");
	}

	//KeyListener
	@Override
	public void keyTyped(KeyEvent k) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			sendMessage();
			tf_msg.setText("");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	
	//서버에서 불특정 시점에 도착하는 메세지를 받을 스레드
	//내부클래스의 메소드 안에서 외부클래스의 필드나 메소드를 자유롭게 쓸 수 있다. ==>편..리
	public class ClientThread extends Thread{
		
		@Override
		public void run() {
			try {
				//서버로부터 입력받을 수 있는 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader  isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				while(true) {
					//서버로부터 문자열이 전송되는지 대기한다.
					String msg = br.readLine();
					System.out.println(msg);
					area.append(msg);
					area.append("\r\n");
					//최근 추가된 글 내용이 보일 수 있도록
					int docLength = area.getDocument().getLength();
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			} catch (Exception e) {}	
		}
	}
}

/*	
 * 서버메인은 인터넷 어딘가에 있는 서버컴퓨터에서 실행하는 프로그램
 * 클라이언트 메인은 내컴퓨터
 * 서버메인의 문자열을 읽어오는 작업과 JTextField의 msg를 보내는 기능은 동시에 동작할 수 없다. 
 * 하번에 하나의 작업만 가능하기 때문에... 따라서 Thread를 분리하여 실행순서를 독립적으로 만들어야한다.
 * 
 */
