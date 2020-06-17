package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz02 extends JFrame implements ActionListener{

	public JTextField tf_msg;
	public JTextArea area;
	
	//생성자
	public Quiz02() {
		setTitle("나의 프레임");
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		tf_msg = new JTextField(10);
		JButton appendBtn = new JButton("추가하기");
		JButton loadBtn = new JButton("불러오기");
		appendBtn.setActionCommand("append");
		loadBtn.setActionCommand("load");
		
		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		topPanel.add(loadBtn);
		
		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.WHITE);
		
		appendBtn.addActionListener(this);
		
		//JTextArea
		area = new JTextArea();
		//프레임의 가운데에 JTextArea 배치하기
		add(area, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		Quiz02 f = new Quiz02();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String command = event.getActionCommand();
		if(command.equals("append")) {
			append();
		}else if(command.equals("load")) {
			load();
		}
	}//actionPerformed
	
	
	public void append() {
		tf_msg.setText("");
		
		FileWriter fw =null;
		String str = tf_msg.getText();
		File quiz2 = new File("c:/acorn2020/myFolder/quiz2.txt");
		
		try {
			boolean isExist = quiz2.exists();
			if(!isExist) {
				quiz2.createNewFile();
			}
			fw = new FileWriter(quiz2, true);
			fw.append(str);
			fw.append("\r\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(fw!=null)fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void load() {
		//JTextArea를 한번 clear하고
		area.setText("");
		
		//1. 파일에서 문자열을 읽어와서
				//2. JTextArea 에 출력하기 
				File memoFile=new File("c:/acorn2020/myFolder/quiz2.txt");
				//필요한 객체의 참조값을 담을 지역 변수를 미리 만든다.
				FileReader fr=null;
				BufferedReader br=null;
				try {
					if(!memoFile.exists()) {
						System.out.println("파일이 존재 하지 않습니다.");
						return; //메소드 끝내기 
					}
					//파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어둔 지역 변수에 담는다.
					fr=new FileReader(memoFile);
					br=new BufferedReader(fr);
					while(true) {
						//반복문 돌면서 문자열을 줄단위로(개행기호 기준) 읽어낸다.
						String line=br.readLine();
						if(line==null) {//더이상 읽을 문자열이 없으면
							break;//반복문 탈출
						}
						//읽은 문자열 JTextArea 에 출력하기 
						area.append(line);
						area.append("\r\n");//개행 기호도 출력해 준다.
					}
				}catch(IOException ie) {
					ie.printStackTrace();
				}finally { //예외가 발생하던 안하던 반드시 실행이 보장되는 블럭 
					//마무리 작업을 한다 (보통 열었던 스트림 객체를 닫는 작업을 한다)
					try {
						//null 체크를 한 다음에 메소들 호출해서 마무리 작업을 한다. 
						if(fr!=null)fr.close();
						if(br!=null)br.close();
					}catch(IOException ie) {}
				}		
	}
}
