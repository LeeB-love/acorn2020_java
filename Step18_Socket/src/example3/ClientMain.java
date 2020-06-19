package example3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientMain extends JFrame implements ActionListener{
	
	JTextField tf_msg;
	
	//생성자
			public ClientMain(){
				//레이아웃을 BorderLayout 으로 지정하기
				setLayout(new BorderLayout());
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				tf_msg = new JTextField(20);
				JButton sendBtn = new JButton("전송");
				sendBtn.setActionCommand("send");
				sendBtn.addActionListener(this);
				
				panel.add(tf_msg);
				panel.add(sendBtn);
				
				add(panel,BorderLayout.SOUTH);
				
			}
	
	public static void main(String[] args) {
		
		ClientMain f = new ClientMain();
		f.setTitle("채팅창");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//서버에 전송할 문자열을 입력받아서
		Scanner scan = new Scanner(System.in);
		System.out.println("서버에 전송할 문자열 입력");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = tf_msg.getText();
		
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.30", 5000); //누를 때 마다 새롭게 접속하고 텍스트 보내고 바로 접속 끝
			System.out.println("Socket 연결 성공!");
			//문자열을 서버에 전송(출력 Output) 하기
			OutputStream os = socket.getOutputStream(); //출력메소드 - byte출력메소드밖에 없음
			OutputStreamWriter osw =new OutputStreamWriter(os); //출력메소드 확장 - String 출력해주는 기능 有
			osw.write(msg);
			osw.write("\r\n");//개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
			osw.flush();
			osw.close();//소캣을 일회용으로 사용하는 것. 
		}catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e2) {}
		}
		
	}
}
