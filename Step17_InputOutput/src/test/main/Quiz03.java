package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz03 extends JFrame implements ActionListener{
	
	JTextArea area;
	File selectedFile;
	JFileChooser fc;
	
	//생성자
	public Quiz03() {
		//프레임 제목 설정
		setTitle("나의 파일");
		//프레임 레이아웃 지정
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기
		JMenuItem item_new = new JMenuItem("New");
		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_save = new JMenuItem("Save");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		item_open.setActionCommand("open");
		item_open.addActionListener(this);
		item_save.setActionCommand("save");
		item_save.addActionListener(this);
		
		
		//메뉴에 아이템 추가
		JMenu menu1 = new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		
		JMenu menu2 = new JMenu();
		menu2.setText("도움말");
		
		//메뉴바에 메뉴 추가
		JMenuBar mb = new JMenuBar();
		mb.add(menu1);
		mb.add(menu2);
		
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area를 프레임의 가운데에 배치
		area = new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.WHITE);
		area.setVisible(false);
		
	}
	
	public static void main(String[] args) { //프레임 만들기
		Quiz03 f = new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	
	// File > 메뉴아이템을 클릭하면 호출되는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {		
		//눌러진 아이템의 액션 command를 읽어온다.
		String command = e.getActionCommand();
		if(command.equals("new")) { // 빈문서 띄우기
			area.setText("");
			area.setVisible(true);
			area.grabFocus(); //커서가 깜빡이게 하는거
		}else if(command.equals("open")) {
			area.setText("");
			area.setVisible(true);
			fileChooser();
		}else if(command.equals("save")) {
			saveContents();
		}
	}
		
	
	
	public void fileChooser() {
		 fc = new JFileChooser("c:/acorn2020/myFolder");
		 fc.setFileFilter(new FileNameExtensionFilter("txt", "txt")); // 파일 필터
         fc.setMultiSelectionEnabled(false);//다중 선택 불가
         
		int result  = fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			//선택한 파일을 access할 수 있는 파일 객체
			selectedFile = fc.getSelectedFile();
			load();
		}
	}//fileChooser
	
	
	public void load() {		
			//필요한 객체의 참조값을 담을 지역 변수를 미리 만든다.
			FileReader fr=null;
			BufferedReader br=null;
			try {
				if(!selectedFile.exists()) {
					System.out.println("파일이 존재 하지 않습니다.");
					return; //메소드 끝내기 
				}
				//파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어둔 지역 변수에 담는다.
				fr=new FileReader(selectedFile);
				br=new BufferedReader(fr);  //BufferdReader는 생성자로 Reader 타입 객체를 받는다. 근데 FileReader이 Reader 타입이 될 수 있으므로 fr객체 삽입
				while(true) {
					//반복문 돌면서 문자열을 줄단위로(개행기호 기준) 읽어낸다. (readLine = 한줄 읽어오는 메소드)
					String line=br.readLine();
					if(line==null) {//더이상 읽을 문자열이 없으면
						break;//반복문 탈출
					}
					//읽은 문자열 JTextArea 에 출력하기 
					area.append(line); //setText 써버리면 계속 덮어쓰기 돼서 결국 마지막줄만 남는다 ㅠ append로 한줄 씩 추가해줘야함
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
	}//load
	
	
	public void saveContents() {		
		//JTextArea에 입력한 문자열을 읽어온다.
		String contents = area.getText();
		fc = new JFileChooser("c:/acorn2020/myFolder");
		fc.setFileFilter(new FileNameExtensionFilter("txt", "txt")); // 파일 필터
        fc.setMultiSelectionEnabled(false);//다중 선택 불가
		
		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			//새로 만들 예정인 File 객체의 참조값 얻어오기 - File객체에는 문자열을 출력할 수 있는 기능이 없다. 그래서 업시켜셔 FileWriter 사용
			File file = fc.getSelectedFile();
			//파일에 문자열을 출력할 수 있는 객체 생성 (FileWriter)
			try {//FileWriter에 대한 try/catch
				FileWriter fw = new FileWriter(file); 
				fw.write(contents);
				fw.flush();
				fw.close();
				JOptionPane.showMessageDialog(this, file.getName()+"  파일을 저장했습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

