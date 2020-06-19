package example4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;  //클라이언트의 접속을 기다리게 하는 객체. 클라이언트가 접속하고 나면 Socket 객체를 리턴한다.
import java.net.Socket;  //Socket을 이용하여 클라이언트와 소통한다. 10명이 접속하면 Socket 10개, 20명이 접속하면 Socket 20 ...이런식으로 늘어나간다.
import java.util.ArrayList;
import java.util.List;

/*
 * ServerSocket/Socket = 컴퓨터끼리 네트워크를 통해서 데이터를 주고받을 수 있다.
 */

public class ServerMain {
	//필드
	static List<ServerThread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수를 미리 만들기
		ServerSocket serverSocket = null;
		try {
			//5000번 통신 port를 열고 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5000);
			while(true) {
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다");
				Socket socket = serverSocket.accept();
				serverSocket.accept(); 
				System.out.println("클라이언트가 접속을 했습니다.");
				
				//방금 접속한 클라이언트를 응대할 스레드를 시작시킨다.
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
				threadList.add(thread);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket !=null) serverSocket.close();
			}catch (Exception e) {}
		}//try/catch/finally
	}//main
	
	//내부 클래스로 스레드 객체를 생성할 클래스를 정의한다.
	public static class ServerThread extends Thread{
		//필드
		Socket socket;
		BufferedWriter bw;
		
		//생성자
		public ServerThread(Socket socket) {
			this.socket = socket;
			//클라이언트에게 출력할 문자열을 객체
		}
		
		public void sendMessage(String msg) throws IOException {
			//반복문 돌면서 모든 스레드의 BufferWriter 객체를 이용해서 문자열을 전송한다. 
			for(ServerThread tmp : threadList) {
				tmp.bw.write(msg); //문자열 출력
				tmp.bw.newLine(); //개행기호 출력
				tmp.bw.flush(); //방출
			}
		}
		
		//새로운 작업단위가 시작되는 run() 메소드
		@Override
		public void run() {
			
			//클라이언트로부터 읽어들일 (Input) 객체의 참조값 얻어오기
			InputStream is;
			try {
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피 : "+clientIp);
				is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);//역시 줄단위로 읽어오는 메소드는 없음 또 기능 업
				BufferedReader br = new BufferedReader(isr);
				
				//클라이언트에게 출력할 수 있는 객체
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				while(true) {
					/*
					 * 클라이언트가 문자열을 한 줄(개행기호와 함께) 보내면
					 * readLine() 메소드가 리턴하면서 보낸 문자열을 가지고온다.
					 * 보내지 않으면 계속 블로킹되어서 대기하고 있다가 접속이 끊기면 Exception이 발생하거나 혹은 null이 리턴된다.
					 * 따라서 null이 리턴되면 반복문을 빠져나가게 break문을 만나도록한다.
					 * 실행순서가 try 블럭을 번서나면 run()메소드가 리턴하게 되고 run() 메소드가 리턴되면 해당 스레드는 종료된다.
					 */
					String msg = br.readLine();
					System.out.println("메세지 : "+msg);
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					sendMessage(msg);
					if(msg==null) {
						break;  //클라이언트의 접속이 끊겼기 때문에 반복문(while)을 빠져나오도록한다.
					}
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//접속이 끊겨서 종료되는 스레드는 List에서 제거한다. -접속이 끊긴 스레드의 참조값(ServerThread)이 있는 방을 찾아서 알아서 삭제
				threadList.remove(this);
				try {
					if(socket!=null)socket.close();
				} catch (IOException e) {}
			}
		}
	}
	
}//class ServerMain

/*
 * 작업단위가 하나이면 한명의 클라이언트를 응대하는게 시간이 오래걸릴 경우, 다른 클라이언트는 응대할 수 없다. 응대하고있던 클라이언트의 응대가 끝날 때까지 기다려야함
 * 메인스레드와 새로운 스레드를 분리해서 serverSocket은 메인에서, socket 부분은 새로운 스레드에서 ㄱㄱ
 * 
 */
