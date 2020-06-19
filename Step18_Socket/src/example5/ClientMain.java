package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/*
 * JSON -이런 타입을 사용하려면 JSON 라이브러리를 다운받아야한다.
 * - Java Script Object Notation (자바스크립트 객체 표기법을 따르는 문자열)
 * 
 * -데이터 type
 * 1. { }
 * 2. [ ]
 * 3. "xxx"
 * 4. 10 or 10.1
 * 5. true or false
 * 6. null
 * 
 * -JSON 예제
 * {"num" : 1, "name" : 김구라, "isMan" : true, "phone" : null}
 * value가 될 수 있는 것은 데이터 type 6가지가 전부
 * [10, 20, 30, 40, 50]
 * ["김구라", "해골", "원숭이]
 * [{}, {},{}]
 * {"name":"kim", "friends":["김구라", "해골", "원숭이"]}
 * 
 * type에 따라 분기한 메세지의 종류
 * 1. 일반 대화 메세지 {"type" : "msg", "name":"김구라", "contant":"안녕하세요"}  =>JSONObject
 * 2. 누군가 입장했다는 메세지 {"type" : "enter", "name":"김구라"}
 * 3. 누군가 퇴장했다는 메세지 {"type" : "out", "name" :"김구라"}
 * 4. 참여자 목록 메세지 {"type" : "members", "list" : ["김구라", "해골", "원숭이"]}  =>JSONArray
 */
public class ClientMain extends JFrame implements ActionListener, KeyListener{
	
	JTextField tf_msg;
	//서버와 연결된 Socket 객체으이 참조값을 담을 필드
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	//대화명
	String chatName;
	//참여자 목록
	
	JList<String> jList;
	
	
	
	
	
	//생성자 - 1. Socket 생성&ServerMain에 접속하기     2. JFrame 구성
		public ClientMain(){
			

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
			
			//Vector는 ArrayList 와 같다고 생각하면 된다. 추가기능(스레드 동기화)가 있어서 조금 더 무겁다.
			String[] title = {"참여자 목록"};
			jList = new JList<String>(title);
			jList.setBackground(Color.PINK);
			
			//패널에 JList를 배치하고
			JPanel rightPanel = new JPanel();
			rightPanel.add(jList);
			rightPanel.setBackground(Color.PINK);
			//패널을 동쪽에 배치
			add(rightPanel, BorderLayout.EAST);
			
			
			
			
			chatName = JOptionPane.showInputDialog(this, "대화명을 입력하세요");

			setTitle("대화명 : "+chatName);
			
			//특정한 아이피 주소의 서버에 소켓접속을 한다.
			try {
				//접속이 성공되면 Socket 객체의 참조값이 반환된다.
				//반환되는 객체의 참조값을 필드에 저장해놓는다.
				//접속에 성공하면 소켓객체를 하나 반환해준다.
				socket = new Socket("192.168.0.85", 5000);  //생성자를 통해 접속을 한 번만 하기
				System.out.println("Socket 연결 성공!");
				//문자열을 서버에 전송(출력 Output) 하기
				OutputStream os = socket.getOutputStream(); //출력메소드 - byte출력메소드밖에 없음
				OutputStreamWriter osw =new OutputStreamWriter(os); //출력메소드 확장 - String 출력해주는 기능 有
				bw = new BufferedWriter(osw); //서버에 문자열을 출력할 BufferedWriter 객체의 참조값을 얻어내서 필드에 저장해놓는다.
				//osw가 한번만 사용되고 버려지는 구조 - actionPerformed메소드에 넣지 말고 필드에 넣으면 한번만 new할 수 있다.
				
				//서버로부터 메세지를 받을 스레드도 시작을 시킨다.
				new ClientThread().start();
				
				//내가 입장한다고 서버에 메세지를 보낸다. {"enter":"김구라"}
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("type", "enter");
				jsonObj.put("name", chatName);
				String msg = jsonObj.toString();
				
				//BufferedWriter 객체를 이용해서 내보내기
				bw.write(msg);
				bw.newLine();
				bw.flush();
						//JSONObject : {}, JSONArray : []
				
				
				
			}catch (Exception e) {
				//접속이 실패하면 예외가 발생한다.
				e.printStackTrace();
			}
		}
	
		
		
		
		
		
	//main은 프레임을 만드는 역할만 함 (접어두기)	
	public static void main(String[] args) {
		
		ClientMain f = new ClientMain();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	
	
	
	
	
	
	//ServerMain에 문자열을 보내는 메소드(출력)
	public void  sendMessage() {
		String msg = tf_msg.getText();
		try {
			//JSONObject 객체를 생성해서 정보를 구성하고
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			//JSON 문자열을 얻어낸다.
			String json = jsonObj.toString();
			
			//필드에 있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
			bw.write(json);
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
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			sendMessage();
			tf_msg.setText("");
		}
	}
	@Override
	public void keyTyped(KeyEvent k) {}
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
					//메소드를 호출하면서 문자열 전달
					updateTextArea(msg);
		
					//최근 추가된 글 내용이 보일 수 있도록
					int docLength = area.getDocument().getLength();
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			} catch (Exception e) {}	
		}//run()
		
		
		//JTextArea에 문자열을 출력하는 메소드
		public void updateTextArea(String msg) {
			try {
				JSONObject jsonObj = new JSONObject(msg);
				String type = jsonObj.getString("type");
				
				if(type.equals("enter")) {//입장메세지라면 누가 입장했는지 읽어낸다.
					String name = jsonObj.getString("name");
					area.append("["+name+"] 님이 입장했습니다.");
					area.append("\r\n");
				}else if(type.equals("msg")) {//대화 메세지라면 누가 뭘 썼는지?
					String name = jsonObj.getString("name");
					String content = jsonObj.getString("content");
					//출력하기
					area.append(name+" : "+content);
					area.append("\r\n");
				}else if(type.equals("out")) {
					String name = jsonObj.getString("name");
					area.append("[["+name+"]] 님이 퇴장했습니다.");
					area.append("\r\n");
				}else if(type.equals("members")) {
					JSONArray arr = jsonObj.getJSONArray("list");
					//참여자 목록을 저장할 Vector
					Vector<String> list = new Vector<>();
					list.add("참여자 목록");
					
					//반복문을 돌면서 참여자 목록을 다시 넣어준다.
					for(int i=0; i<arr.length(); i++) {
						String tmp = arr.getString(i);
						list.add(tmp);
					}
					
					//JList에 참여자 목록 연결하기
					jList.setListData(list);
				}
			}catch (JSONException je) {
				je.printStackTrace();
			}
		}
	}
}

/*	
 * 서버메인은 인터넷 어딘가에 있는 서버컴퓨터에서 실행하는 프로그램
 * 클라이언트 메인은 내컴퓨터
 * 서버메인의 문자열을 읽어오는 작업과 JTextField의 msg를 보내는 기능은 동시에 동작할 수 없다. 
 * 하번에 하나의 작업만 가능하기 때문에... 따라서 Thread를 분리하여 실행순서를 독립적으로 만들어야한다.
 * 
 * 1. 서버에 접속하는 소켓을 관리하는 메인스레드
 * 2. 서버에서 문자열을 입력받는 스레드
 * 총 두가지 스레드가 필요하다.
 */
